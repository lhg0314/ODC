package user.service.impl;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.ClassBooking;
import dto.ReviewBoard;
import dto.ReviewFile;
import user.dao.UserMyPageClassDaoImpl;
import user.dao.face.UserMyPageClassDao;
import user.service.face.UserMyPageClassService;

public class UserMyPageClassServiceImpl implements UserMyPageClassService{
	private UserMyPageClassDao usermypageclassDao = new UserMyPageClassDaoImpl();
	
	@Override
	public Date nowday() {
		//현재 날짜 기준 년원일
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		Date nowdat = new Date();
		String resday = format.format(nowdat);
		
		Date nowday = null;
		
		try {
			nowday = format.parse(resday);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
						
		return nowday;
	}
	
	@Override
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday) {
		ArrayList<Map<String, Object>> userbooking = usermypageclassDao.userbooking(userid,nowday);
		return userbooking;
	}
	
	@Override
	public int bookingnoparam(HttpServletRequest req) {

		String param = req.getParameter("bookingno");
		
        int bookingno = 0;
        if( param != null && !"".equals(param)) {
        	bookingno  = Integer.parseInt(param);
        }
		
		return bookingno;
	}
	
	@Override
	public int bookingcancel(int bookingno) {
		int bookingcancel  = usermypageclassDao.bookingcancel(bookingno);
		return bookingcancel;
	}
	
	@Override
	public ArrayList<Map<String, Object>> userwish(String userid) {
		ArrayList<Map<String, Object>> userwish = usermypageclassDao.userwish(userid);
		return userwish;
	}
	
	@Override
	public int wishnoparam(HttpServletRequest req) {
		String param = req.getParameter("wishno");
		
        int wishno = 0;
        if( param != null && !"".equals(param)) {
        	wishno  = Integer.parseInt(param);
        }
		
		return wishno;
	}
	
	@Override
	public void wishcancel(int wishno) {
		usermypageclassDao.wishcancel(wishno);
	}
	
	@Override
	public Map<String, Object> classpayment(String userid, int wishno) {
		Map<String, Object> classpayment = usermypageclassDao.classpayment(userid,wishno);
		return classpayment;
	}
	
	@Override
	public int userno(String userid) {
		int userno = usermypageclassDao.userno(userid);
		return userno;
	}
	
	@Override
	public int classbookingno() {
		int classbookingno = usermypageclassDao.classbookingno();
		return classbookingno;
	}
	
	@Override
	public Map<String,Object> paymentparam(HttpServletRequest req) {
		
		Map<String, Object> paymentparam = new HashMap<String,Object>();
		
		//String merchant_uid - 고유주문번호 - random, unique 
		paymentparam.put("merchantuid",req.getParameter("merchant_uid"));
		
		//String classname - 주문명 - 선택항목, 결제정보 확인을 위한 입력, 16자 이내로 작성
//		paymentparam.put("classname",req.getParameter("name"));
		
		//int totalprice 결제금액 - 필수항목
		String param = req.getParameter("amount");
		if(param != null && !"".equals(param)) {
			paymentparam.put("totalprice",Integer.parseInt(param));
		}
		
		//String useremail 주문자Email - 선택항목
		paymentparam.put("useremail",req.getParameter("buyer_email"));
		
		//String username  주문자명 - 선택항목
		paymentparam.put("username",req.getParameter("buyer_name"));
		
		//Long userphone 주문자연락처 - 필수항목, 누락되면 PG사전송 시 오류 발생
		param = req.getParameter("userphone");
		if(param != null && !"".equals(param)) {
			paymentparam.put("userphone",Long.parseLong(param));
		}
		
		//Date bookingdate //클래스 예약날짜
		param = req.getParameter("bookingdate"); //2020-07-01 String
		if(param != null && !"".equals(param)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				paymentparam.put("bookingdate",format.parse(param));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//int wishcount // 예약인원
		param = req.getParameter("wishcount");
		if(param != null && !"".equals(param)) {
			paymentparam.put("wishcount",Integer.parseInt(param));
		}
		
		//int classno // 클래스 번호
		param = req.getParameter("classno");
		if(param != null && !"".equals(param)) {
			paymentparam.put("classno",Integer.parseInt(param));
		}
		
		return paymentparam;
	}
	
	@Override
	public void insertclassbooking(int classbookingno, int userno, Map<String, Object> paymentparam) {
		usermypageclassDao.insertclassbooking(classbookingno,userno,paymentparam);
		
	}
	
	@Override
	public ArrayList<Map<String, Object>> usersignup(String userid, Date nowday) {
		ArrayList<Map<String, Object>> usersignup = usermypageclassDao.usersignup(userid,nowday);
		return usersignup;
	}
	
	@Override
	public int classno(HttpServletRequest req) {
		String param = req.getParameter("classno");
		
        int classno = 0;
        if( param != null && !"".equals(param)) {
        	classno  = Integer.parseInt(param);
        }
		
		return classno;
	}
	
	@Override
	public int bookingno(HttpServletRequest req) {
		String param = req.getParameter("bookingno");
		
        int bookingno = 0;
        if( param != null && !"".equals(param)) {
        	bookingno  = Integer.parseInt(param);
        }
		
		return bookingno;
	}
	
	@Override
	public int reviewboardno() {
		int reviewboardno = usermypageclassDao.reviewboardno();
		return reviewboardno;
	}
	
	@Override
	public int reviewcount(int bookingno) {
		int reviewcount = usermypageclassDao.reviewcount(bookingno);
		return reviewcount;
	}
	
	@Override
	public void insertreview(HttpServletRequest req, HttpServletResponse resp, int userno, int classno, int bookingno,int reviewboardno) {
		
		//전달 파라미터를 저장할 DTO 객체
		ReviewBoard reviewboard = new ReviewBoard();
		ReviewFile reviewfile = null;
		
		//reviewboardno insert
		reviewboard.setReviewno(reviewboardno);
		
		//classno insert
		reviewboard.setClassno(classno);
		
		//userno insert
		reviewboard.setUserno(userno);
		
		//merchantuid insert
		reviewboard.setBookingno(bookingno);
		
		
		//응답 객체 Context-Type 설정
		resp.setContentType("text/html; charset=utf-8");
		
		//응답 객체 출력 스트림 얻기
		PrintWriter out = null;
		
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//1. 파일업로드 형태가 데이터가 맞는지 검사
		// 요청 메세지 Content-Type이 multipart/form-data 가 맞는지 확인한다
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우 처리 중단 하기
		if(!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드 페이지로 이동</a>");
			
			return; //fileupload() 메소드 중단시키기
		}
		
		// 1-2. 여기이후 부터는 multipart/form-data로 요청된 상황
		// 파일이 전송되었음. 정상적인 흐름으로 처리
//		System.out.println("TEST");
		
		
		//2. 업로드된 파일을 처리하는 아이템팩토리 객체 생성
		
		//ItemFactory : 업로드된 데이터 (FileItem)를 처리하는 방식을 설정하는 클래스  
		//				설정값들을 미리 가지고 있는 클래스 / 사전에 만들어지는 클래스 
		
		// FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것
		
		//DiskFileItemFactory class 
		//		-> 디스크(HDD) 기반의 파일아이템 처리 API 
		//		-> 업로드된 파일을 디스크(HDD)에 임시 저장하고 나중에 처리한다 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		
		//3. 업로드된 파일아이템의 용량이 적당히 작으면 메모리에서 하도록 설정
		int maxMen = 1* 1024 * 1024; //1MB 
		factory .setSizeThreshold(maxMen);
		
		//4. 용량이 적당히 크면 임시 파일(HDD) 만들어서 처리하도록 설정
		// 		-> 임시파일 폴더 설정
		
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); //임시 저장 폴더
		
		factory.setRepository(repository);
		
		
		//5. 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드 처리되도록 설정
		// 	   -> 기준을 넘으면업로드 차단됨 
		int maxFile = 10 * 1024 * 1024; //10MB
		
		
		//파일업로드 수행 객체 생성
		//DiskFileItemFactory 객체 이용해서 생성함
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);
		
		// 파일 업로드 준비 완료 --------------------------------------------------------------
		
		//6. 업로드된 데이터 추출(파싱)
		// 임시 파일 업로드도  같이 수행된다 
		
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 7. 파싱된 요청정보 데이터 처리하기
		//  items 리스트에 요청파라미터(파일포함)이 파싱되어 들어있음 
		
		// 요청정보의 3가지 형태
		//		1. 빈파일(용량이 0인 파일)
		//		2. form-data (전달파라미터)
		//		3. 파일
		
		//파일아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//모든 요청정보 처리하는 반복문
		while (iter.hasNext()) {
			
			//요청정보 객체
			FileItem item = iter.next();
			
			// 1) 빈파일에 대한 처리
			if(item.getSize() <= 0 ) continue;
			
			
			// 2) 기본 전달 파라미터에 대한 처리
			if(item.isFormField()) {
				
				// ---------------------파라미터 저리 개요----------------------
				
				//form-data(form filed)는 key=value 쌍으로 전달됨
				
				//key는 item.getFieidName()으로 얻어옴
				//value는 item.getString()으로 얻어옴
				
				// ** 전달 값이 한글일 경우 인코딩 설정 방법
				// 		item.getStirng("UTF-8")을 사용한다 
				
				// ** req.setCharacterEncoding("UTF-8")이 적용되지 않는다 
				
				//--------------------------------------------------------
				
				//----------------- 기본 처리 방식 ---------------------------- 
				
//				out.println("----폼 필드-----<br>");
//				out.println("키 : " + item.getFieldName()+"<br>");
//				
//				try {
//					out.println("값 : " + item.getString("UTF-8")+"<br>");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
				
				
				
				//--------------------------------------------------------
				
				//----------------- 키값에 따라 처리하는 방식--------------------
				//전달 파라미터를 저장할 DTO 객체
//				reviewboard
				
				//키 값 꺼내기
				String key = item.getFieldName();
				
				 if ("reviewtitle".equals(key)) { //전달파라미터 name이 "title"
					try {
						reviewboard.setReviewtitle(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if("satlevel".equals(key)) {
					try {
						String param = item.getString("UTF-8");
						
						if( param != null && !"".equals(param)) {
							int satlevel = Integer.parseInt(param);
							reviewboard.setSatlevel(satlevel);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				}else if ("reviewcontent".equals(key)) { //전달파라미터 name이 "content"
					try {
						reviewboard.setReviewContent(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				}
				
//				 System.out.println("[TEST] item : " +item);
				 
				//--------------------------------------------------------
				
			}//if(item.isFormField()) end
			
			
			// 3) 파일에 대한 처리 
			if( !item.isFormField() ) {
				
				// 업로드된 파일을 처리하는 방식 ------
				// 1) 파일을 웹서버의 로컬 디스크에 저장
				//    파일의 정보를 DB에 기록해야한다
				
				
				// 2) 테이블의 컬럼으로 파일의 내용을 저장
				// BLOB 타입을 사용한다 
				//   -> DB에 무리가 간다 ( 사용 안함 )
				
				// 1번 방식 사용할 예정
				
				//------------------------------
				
				//서버에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
				
				//파일명  - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
				String rename = sdf.format(new Date());

				//확장자 
				String origin = item.getName(); //원본파일명
				String ext = origin.substring(origin.lastIndexOf(".")+1);
			
				//저장될 이름
				String stored = rename + "." + ext;
				
//				System.out.println("[TEST] stored file name : " +stored);
				
				//----- DB에 업로드된 파일에 대한 정보 기록하기--------------
				reviewfile = new ReviewFile();
				
				reviewfile.setReviewno(reviewboardno);
				
				reviewfile.setRevieworigin(origin);
				reviewfile.setReviewrename(stored);
				
				//----------------------------------------------
				
				//실제  업로드가 파일
				File up = new File( 
						context.getRealPath("upload")//업로드될 폴더
//						, item.getName() //원본 파일의 이름
						,stored //저장파일의 이름(변환됨)
						);

				try {
					item.write(up); //실제 업로드 (최종결과 파일 생성)
					item.delete(); //임시 파일 삭제 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}//if(!item.isFormField()) end
			
		}//while (iter.hasNext() ) end
		
		usermypageclassDao.insertreviewboard(reviewboard);
		
		if(reviewfile != null) {
			//DB에 기록하기 
			usermypageclassDao.insertreviewfile(reviewfile);
		}
		
		//전달파라미터 저장한 DTO확인
//		System.out.println("[TEST] fileupload boardParam :" +boardParam); //content 값 출력 됨
		
	}

}
