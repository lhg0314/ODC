package dto;

import java.util.Date;

public class UserInfo {

	private int userno;
	private String userid;
	private String userpw;
	private String username;
	private Long userphone;
	private String useremail;
	private Date userbirth;
	private String usernick;
	private int usergrade;
	
	
	@Override
	public String toString() {
		return "UserInfo [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userphone=" + userphone + ", useremail=" + useremail + ", userbirth=" + userbirth + ", usernick="
				+ usernick + ", usergrade=" + usergrade + "]";
	}
	
	
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getUserphone() {
		return userphone;
	}
	public void setUserphone(Long userphone) {
		this.userphone = userphone;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Date getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(Date userbirth) {
		this.userbirth = userbirth;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public int getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(int usergrade) {
		this.usergrade = usergrade;
	}
	
}
