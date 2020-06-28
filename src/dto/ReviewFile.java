package dto;

public class ReviewFile {

    private int reviewFileno;
    private int reviewno; 
    private String revieworigin; 
    private String reviewrename;
	@Override
	public String toString() {
		return "ReviewFile [reviewFileno=" + reviewFileno + ", reviewno=" + reviewno + ", revieworigin=" + revieworigin
				+ ", reviewrename=" + reviewrename + "]";
	}
	public int getReviewFileno() {
		return reviewFileno;
	}
	public void setReviewFileno(int reviewFileno) {
		this.reviewFileno = reviewFileno;
	}
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public String getRevieworigin() {
		return revieworigin;
	}
	public void setRevieworigin(String revieworigin) {
		this.revieworigin = revieworigin;
	}
	public String getReviewrename() {
		return reviewrename;
	}
	public void setReviewrename(String reviewrename) {
		this.reviewrename = reviewrename;
	}

    
    
    
}
