package dto;

public class ArtistFile {

    private int profileFileNo;
    private int art_no;
    private String profileOriginFilename;
    private String profileRenameFilename;
	@Override
	public String toString() {
		return "ArtistFile [profileFileNo=" + profileFileNo + ", art_no=" + art_no + ", profileOriginFilename="
				+ profileOriginFilename + ", profileRenameFilename=" + profileRenameFilename + "]";
	}
	public int getProfileFileNo() {
		return profileFileNo;
	}
	public void setProfileFileNo(int profileFileNo) {
		this.profileFileNo = profileFileNo;
	}
	public int getArt_no() {
		return art_no;
	}
	public void setArt_no(int art_no) {
		this.art_no = art_no;
	}
	public String getProfileOriginFilename() {
		return profileOriginFilename;
	}
	public void setProfileOriginFilename(String profileOriginFilename) {
		this.profileOriginFilename = profileOriginFilename;
	}
	public String getProfileRenameFilename() {
		return profileRenameFilename;
	}
	public void setProfileRenameFilename(String profileRenameFilename) {
		this.profileRenameFilename = profileRenameFilename;
	}
    
    
}
