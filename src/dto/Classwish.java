package dto;

public class Classwish {

	   private int classno; 
	   private int user_no; 
	   private int wishCount;
	   private int wishno;
	@Override
	public String toString() {
		return "Classwish [classno=" + classno + ", user_no=" + user_no + ", wishCount=" + wishCount + ", wishno="
				+ wishno + "]";
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getWishCount() {
		return wishCount;
	}
	public void setWishCount(int wishCount) {
		this.wishCount = wishCount;
	}
	public int getWishno() {
		return wishno;
	}
	public void setWishno(int wishno) {
		this.wishno = wishno;
	}
	   
	   
}
