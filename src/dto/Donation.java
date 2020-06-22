package dto;

import java.util.Date;

public class Donation {

	private int userno; 
	private int artno; 
	private Date donationDate;  
	private int donationPrice;
	@Override
	public String toString() {
		return "Donation [userno=" + userno + ", artno=" + artno + ", donationDate=" + donationDate + ", donationPrice="
				+ donationPrice + "]";
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getArtno() {
		return artno;
	}
	public void setArtno(int artno) {
		this.artno = artno;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	public int getDonationPrice() {
		return donationPrice;
	}
	public void setDonationPrice(int donationPrice) {
		this.donationPrice = donationPrice;
	}
	
	
}
