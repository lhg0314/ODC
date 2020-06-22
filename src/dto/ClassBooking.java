package dto;

import java.util.Date;

public class ClassBooking {
    private int bookingNo;      
    private int classno;          
    private int userno;           
    private Date paymentDate;    
    private Date bookingDate;     
    private int bookingCount;     
    private int totalPrice;
    
	@Override
	public String toString() {
		return "ClassBooking [bookingNo=" + bookingNo + ", classno=" + classno + ", userno=" + userno + ", paymentDate="
				+ paymentDate + ", bookingDate=" + bookingDate + ", bookingCount=" + bookingCount + ", totalPrice="
				+ totalPrice + "]";
	}
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getBookingCount() {
		return bookingCount;
	}
	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
   
    
    
}
