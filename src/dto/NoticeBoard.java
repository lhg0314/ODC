package dto;

import java.util.Date;

public class NoticeBoard {

	private int noticeNo;  
	private Date noticeDate; 
	private String noticeContent; 
	private String noticeTitle;
	@Override
	public String toString() {
		return "NoticeBoard [noticeNo=" + noticeNo + ", noticeDate=" + noticeDate + ", noticeContent=" + noticeContent
				+ ", noticeTitle=" + noticeTitle + "]";
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	

}
