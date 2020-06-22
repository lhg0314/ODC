package dto;

public class AdminInfo {
    private String admintId;    
    private String adminPw;
	@Override
	public String toString() {
		return "AdminInfo [admintId=" + admintId + ", adminPw=" + adminPw + "]";
	}
	public String getAdmintId() {
		return admintId;
	}
	public void setAdmintId(String admintId) {
		this.admintId = admintId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}     
    
    

}
