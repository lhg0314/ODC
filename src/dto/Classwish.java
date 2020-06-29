package dto;

import java.util.Date;

public class Classwish {

	   private int classno; 
	   private int user_no; 
	   private int wishCount;
	   private int wishno;
	   private Date wishDate;
	   private int totalPrice;
	@Override
	public String toString() {
		return "Classwish [classno=" + classno + ", user_no=" + user_no + ", wishCount=" + wishCount + ", wishno="
				+ wishno + ", wishDate=" + wishDate + ", totalPrice=" + totalPrice + "]";
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
	public Date getWishDate() {
		return wishDate;
	}
	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	   
	
	   
	   
}
