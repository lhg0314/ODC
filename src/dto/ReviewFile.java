package dto;

public class ReviewFile {

    private int reviewFileno;
    private int reviewno; 
    private String reviewOriginFilename; 
    private String reviewRenameFilename;
	@Override
	public String toString() {
		return "ReviewFile [reviewFileno=" + reviewFileno + ", reviewno=" + reviewno + ", reviewOriginFilename="
				+ reviewOriginFilename + ", reviewRenameFilename=" + reviewRenameFilename + "]";
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
	public String getReviewOriginFilename() {
		return reviewOriginFilename;
	}
	public void setReviewOriginFilename(String reviewOriginFilename) {
		this.reviewOriginFilename = reviewOriginFilename;
	}
	public String getReviewRenameFilename() {
		return reviewRenameFilename;
	}
	public void setReviewRenameFilename(String reviewRenameFilename) {
		this.reviewRenameFilename = reviewRenameFilename;
	}
    
    
}
