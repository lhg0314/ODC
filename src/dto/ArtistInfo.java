package dto;

import java.util.Date;

public class ArtistInfo {

    private int artno;
    private String artid;           
    private String artpw;
    private String artName;
    private String artNick;
    private int artCode;
    private Long artPhone;       
    private Long artTel;          
    private String artAddr;         
    private String artEmail;
    private Date artBirth;
    private int artEmailAuth;
	@Override
	public String toString() {
		return "ArtistInfo [artNo=" + artno + ", artId=" + artid + ", artPw=" + artpw + ", artName=" + artName
				+ ", artNick=" + artNick + ", artCode=" + artCode + ", artPhone=" + artPhone + ", artTel=" + artTel
				+ ", artAddr=" + artAddr + ", artEmail=" + artEmail + ", artBirth=" + artBirth + ", artEmailAuth="
				+ artEmailAuth + "]";
	}
	public int getArtno() {
		return artno;
	}
	public void setArtno(int artno) {
		this.artno = artno;
	}
	public String getArtid() {
		return artid;
	}
	public void setArtid(String artid) {
		this.artid = artid;
	}
	public String getArtpw() {
		return artpw;
	}
	public void setArtpw(String artpw) {
		this.artpw = artpw;
	}
	public String getArtName() {
		return artName;
	}
	public void setArtName(String artName) {
		this.artName = artName;
	}
	public String getArtNick() {
		return artNick;
	}
	public void setArtNick(String artNick) {
		this.artNick = artNick;
	}
	public int getArtCode() {
		return artCode;
	}
	public void setArtCode(int artCode) {
		this.artCode = artCode;
	}
	public Long getArtPhone() {
		return artPhone;
	}
	public void setArtPhone(Long artPhone) {
		this.artPhone = artPhone;
	}
	public Long getArtTel() {
		return artTel;
	}
	public void setArtTel(Long artTel) {
		this.artTel = artTel;
	}
	public String getArtAddr() {
		return artAddr;
	}
	public void setArtAddr(String artAddr) {
		this.artAddr = artAddr;
	}
	public String getArtEmail() {
		return artEmail;
	}
	public void setArtEmail(String artEmail) {
		this.artEmail = artEmail;
	}
	public Date getArtBirth() {
		return artBirth;
	}
	public void setArtBirth(Date artBirth) {
		this.artBirth = artBirth;
	}
	public int getArtEmailAuth() {
		return artEmailAuth;
	}
	public void setArtEmailAuth(int artEmailAuth) {
		this.artEmailAuth = artEmailAuth;
	}
    
    
}
