package dto;

import java.util.Date;

public class ReviewBoard {

    private int reviewno; 
    private int userno;
    private int classno;
    private Date reviewDate; 
    private int sat_level; 
    private String reviewContent;
	@Override
	public String toString() {
		return "ReviewBoard [reviewno=" + reviewno + ", userno=" + userno + ", classno=" + classno + ", reviewDate="
				+ reviewDate + ", sat_level=" + sat_level + ", reviewContent=" + reviewContent + "]";
	}
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getSat_level() {
		return sat_level;
	}
	public void setSat_level(int sat_level) {
		this.sat_level = sat_level;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
 
    
}