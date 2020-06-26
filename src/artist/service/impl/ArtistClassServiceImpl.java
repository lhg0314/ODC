package artist.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.mail.imap.protocol.Item;

import artist.dao.face.ArtistClassDao;
import artist.dao.impl.ArtistClassDaoImpl;
import artist.service.face.ArtistClassService;
import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

public class ArtistClassServiceImpl implements ArtistClassService {
	
	private ArtistClassDao artistClassDao = new ArtistClassDaoImpl();

	@Override
	public ArtistInfo getArtInfoByArtId(String artId) {
		
		ArtistInfo artInfo = artistClassDao.getArtInfoByArtId(artId);
		return artInfo;
	}
	
	public int parseLocation(ArtistInfo artInfo) {
		
		String loc = artInfo.getArtAddr();
		
		String[] arr = loc.split(";");
		System.out.println(arr[0]);
		int num = Integer.parseInt(arr[0].substring(0, 2));
		System.out.println(num);
		int location = 0;
		
		if( num <10 ) {
			location = 1;
		}else if( num < 24 ) {
			location = 2;
		}else if( num < 27) {
			location = 3;
		}else if( num < 36 ) {
			location = 4;
		}else if( num < 54 ) {
			location = 5;
		}else if( num < 63 ) {
			location = 6;
		}else {
			location = 7;
		}
		
		System.out.println(location);
		return location;
	}

	@Override
	public void insertClassInfo(HttpServletRequest req, HttpServletResponse resp, ArtistInfo artInfo) {

		// 응답 객체 Content-Type 설정
		resp.setContentType("text/html; charset=utf-8");
		
		// 1. 파일 업로드 형태가 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if( !isMultipart ) {
			System.out.println("인코딩 타입이 멀티파트데이터가 아닙니다");
			return;
		}
		
		// 전달파라미터를 저장할 DTO 객체
		int classno = artistClassDao.getClassNo();
		ClassInfo classInfo = new ClassInfo();
		ClassFile mainFile = new ClassFile();
		ClassFile detailFile = new ClassFile();
		
		classInfo.setArtno(artInfo.getArtno());
		classInfo.setClassno(classno);
		
		// 지역 우편번호로 파싱 처리
		int location = parseLocation(artInfo);
		classInfo.setLocation(location);
		
		mainFile.setClassno(classno);
		detailFile.setClassno(classno);
		
		
		// 2. 아이템 팩토리 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 파일 용량이 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시 파일만들어서 처리
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); // 임시 저장 폴더
		
		factory.setRepository(repository);
		
		// 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드
		int maxFile = 10*1024*1024; // 10MB
		
		// 파일 업로드 수행 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(maxFile);
		
		// 6. 업로드된 데이터 파싱
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. 파싱될 요청정보 데이터 처리
		
		// 파일 아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		// String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfName = new SimpleDateFormat("yyyyMMddhhmmssS");

		while( iter.hasNext()) {
			
			FileItem item = iter.next();
			
			// 1) 빈파일
			if( item.getSize() <= 0) continue;
			
			// 2) 기본 전달 파라미터 처리
			if( item.isFormField()) {
				String key = item.getFieldName();
				
				String param = null;
				
				if("className".equals(key)) {
					try {
						classInfo.setClassName(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classPrice".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int classprice = Integer.parseInt(param);
							classInfo.setClassprice(classprice);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("talentDonation".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int talentDonation = Integer.parseInt(param);
							classInfo.setTalentDonation(talentDonation);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("category".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int category = Integer.parseInt(param);
							classInfo.setCategory(category);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("minPeople".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int minPeople = Integer.parseInt(param);
							classInfo.setMinPeople(minPeople);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("maxPeople".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int maxPeople = Integer.parseInt(param);
							classInfo.setMaxPeople(maxPeople);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classStartDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date classStartdate = sdf.parse(param);
							classInfo.setClassStartdate(classStartdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classEndDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date classEnddate = sdf.parse(param);
							classInfo.setClassEnddate(classEnddate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("recruitStartDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date recruitStartdate = sdf.parse(param);
							classInfo.setRecruitStartdate(recruitStartdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("recruitEndDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date recruitEnddate = sdf.parse(param);
							classInfo.setRecruitEnddate(recruitEnddate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classContent".equals(key)) {
					try {
						classInfo.setClassContent(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				
			}// f( item.isFormField()) end
			
			if( !item.isFormField()) {
				
				File up = null;
				
				if( "mainFile".equals(item.getFieldName()) ) {
					
					// 3) 파일 처리
					String rename = sdfName.format(new Date());
					
					String origin = item.getName(); // 원본 파일
					String ext = origin.substring(origin.lastIndexOf(".") + 1);
					
					// 저장될 이름
					String stored = "main" + rename + "." + ext;
					
					// 실제 업로드 파일
					up = new File(context.getRealPath("upload")// 업로드될 폴더
//						, item.getName() // 업로드될 파일 이름
							, stored // 저장 파일의 이름(변환됨)
							);
					
					mainFile.setClassOriginFilename(origin);
					mainFile.setClassRenameFilename(stored);
					
					System.out.println(mainFile);
					try {
						item.write(up); // 실제 업로드
						item.delete(); // 임시파일삭제
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if( "detailFile".equals(item.getFieldName())) {
					
					// 3) 파일 처리
					String rename = sdfName.format(new Date());
					
					String origin = item.getName(); // 원본 파일
					String ext = origin.substring(origin.lastIndexOf(".") + 1);
					
					// 저장될 이름
					String stored = rename + "." + ext;
					
					// 실제 업로드 파일
					up = new File(context.getRealPath("upload")// 업로드될 폴더
//						, item.getName() // 업로드될 파일 이름
							, stored // 저장 파일의 이름(변환됨)
							);
					
					detailFile.setClassOriginFilename(origin);
					detailFile.setClassRenameFilename(stored);
					
					System.out.println(detailFile);
					
					try {
						item.write(up); // 실제 업로드
						item.delete(); // 임시파일삭제
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} //if( !item.isFormField()) end
			
		} //while( iter.hasNext()) End
		
		artistClassDao.insertClassInfo(classInfo);
		artistClassDao.insertClassFile(mainFile);
		artistClassDao.insertClassFile(detailFile);
		
	}

	@Override
	public List<Map<String, Object>> selectAllClassCheck(int artno) {
		return artistClassDao.selectAllClassCheck(artno);
	}

	@Override
	public Paging getPagingClassManage(HttpServletRequest req, int artno) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		
		int curPage = 0;
		
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//				System.out.println("curPage : " + curPage);
		
		//검색어
		String search = (String)req.getParameter("search");


		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = artistClassDao.selectCntAll(search, artno);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public List<Map<String, Object>> selectAllClass(Paging paging, int artno) {
		return artistClassDao.selectAllClass(paging, artno);
	}

	@Override
	public Map<String, Object> selectClassByClassNo(int classno) {
		
		return artistClassDao.selectClassByClassNo(classno);
	}

	@Override
	public void updateClassInfo(HttpServletRequest req, HttpServletResponse resp) {

		// 응답 객체 Content-Type 설정
		resp.setContentType("text/html; charset=utf-8");
		
		// 1. 파일 업로드 형태가 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if( !isMultipart ) {
			System.out.println("인코딩 타입이 멀티파트데이터가 아닙니다");
			return;
		}
		
		// 전달파라미터를 저장할 DTO 객체
		ClassInfo classInfo = new ClassInfo();
		ClassFile mainFile = new ClassFile();
		ClassFile detailFile = new ClassFile();
		
		// 2. 아이템 팩토리 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 파일 용량이 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시 파일만들어서 처리
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); // 임시 저장 폴더
		
		factory.setRepository(repository);
		
		// 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드
		int maxFile = 10*1024*1024; // 10MB
		
		// 파일 업로드 수행 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(maxFile);
		
		// 6. 업로드된 데이터 파싱
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 7. 파싱될 요청정보 데이터 처리
		
		// 파일 아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		// String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfName = new SimpleDateFormat("yyyyMMddhhmmssS");

		while( iter.hasNext()) {
			
			FileItem item = iter.next();
			
			// 1) 빈파일
			if( item.getSize() <= 0) continue;
			
			// 2) 기본 전달 파라미터 처리
			if( item.isFormField()) {
				String key = item.getFieldName();
				
				String param = null;
				
				if("classNo".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int classNo = Integer.parseInt(param);
							classInfo.setClassno(classNo);
							mainFile.setClassno(classNo);
							detailFile.setClassno(classNo);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classPrice".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int classprice = Integer.parseInt(param);
							classInfo.setClassprice(classprice);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("minPeople".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int minPeople = Integer.parseInt(param);
							classInfo.setMinPeople(minPeople);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("maxPeople".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int maxPeople = Integer.parseInt(param);
							classInfo.setMaxPeople(maxPeople);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classStartDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date classStartdate = sdf.parse(param);
							classInfo.setClassStartdate(classStartdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classEndDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date classEnddate = sdf.parse(param);
							classInfo.setClassEnddate(classEnddate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("recruitStartDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date recruitStartdate = sdf.parse(param);
							classInfo.setRecruitStartdate(recruitStartdate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("recruitEndDate".equals(key)) {
					try {
						param = item.getString("UTF-8");
						
						try {
							Date recruitEnddate = sdf.parse(param);
							classInfo.setRecruitEnddate(recruitEnddate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("classContent".equals(key)) {
					try {
						classInfo.setClassContent(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				
			}// f( item.isFormField()) end
			
			if( !item.isFormField()) {
				
				File up = null;
				
				if( "mainFile".equals(item.getFieldName()) ) {
					
					// 3) 파일 처리
					String rename = sdfName.format(new Date());
					
					String origin = item.getName(); // 원본 파일
					String ext = origin.substring(origin.lastIndexOf(".") + 1);
					
					// 저장될 이름
					String stored = "main" + rename + "." + ext;
					
					// 실제 업로드 파일
					up = new File(context.getRealPath("upload")// 업로드될 폴더
//						, item.getName() // 업로드될 파일 이름
							, stored // 저장 파일의 이름(변환됨)
							);
					
					mainFile.setClassOriginFilename(origin);
					mainFile.setClassRenameFilename(stored);
					
					System.out.println(mainFile);
					try {
						item.write(up); // 실제 업로드
						item.delete(); // 임시파일삭제
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if( "detailFile".equals(item.getFieldName())) {
					
					// 기존 파일 삭제
					artistClassDao.deleteClassFile(detailFile);
					// 3) 파일 처리
					String rename = sdfName.format(new Date());
					
					String origin = item.getName(); // 원본 파일
					String ext = origin.substring(origin.lastIndexOf(".") + 1);
					
					// 저장될 이름
					String stored = rename + "." + ext;
					
					// 실제 업로드 파일
					up = new File(context.getRealPath("upload")// 업로드될 폴더
//						, item.getName() // 업로드될 파일 이름
							, stored // 저장 파일의 이름(변환됨)
							);
					
					detailFile.setClassOriginFilename(origin);
					detailFile.setClassRenameFilename(stored);
					
					System.out.println(detailFile);
					
					try {
						item.write(up); // 실제 업로드
						item.delete(); // 임시파일삭제
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} //if( !item.isFormField()) end
			
		} //while( iter.hasNext()) End
		
		artistClassDao.updateClassInfo(classInfo);
		artistClassDao.insertClassFile(mainFile);
		artistClassDao.insertClassFile(detailFile);
		
	}

	@Override
	public ClassFile selectDetailFileByClassno(int classno) {
		return artistClassDao.selectDetailFileByClassno(classno);
	}

}
