package dto;

import java.util.Date;

public class ReviewBoard {

    private int reviewno; 
    private int userno;
    private int classno;
    private Date reviewDate; 
    private String satlevel; 
    private String reviewContent;
    private String reviewtitle;
    private int bookingno;
    
    
    
	@Override
	public String toString() {
		return "ReviewBoard [reviewno=" + reviewno + ", userno=" + userno + ", classno=" + classno + ", reviewDate="
				+ reviewDate + ", satlevel=" + satlevel + ", reviewContent=" + reviewContent + ", reviewtitle="
				+ reviewtitle + ", bookingno=" + bookingno + "]";
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
<<<<<<< HEAD

	public String getSatlevel() {
		return satlevel;
	}

=======
	public String getSatlevel() {
		return satlevel;
	}
>>>>>>> 98509b83aff6f42cdb18da9848dd01780c669681
	public void setSatlevel(String satlevel) {
		this.satlevel = satlevel;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewtitle() {
		return reviewtitle;
	}

	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}

	public int getBookingno() {
		return bookingno;
	}

	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}

    
	
	
    
}