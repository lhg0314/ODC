package dto;

public class ArtistDetail {

    private int artno;
    private String artContent;
	@Override
	public String toString() {
		return "ArtistDetail [artno=" + artno + ", artContent=" + artContent + "]";
	}
	public int getArtno() {
		return artno;
	}
	public void setArtno(int artno) {
		this.artno = artno;
	}
	public String getArtContent() {
		return artContent;
	}
	public void setArtContent(String artContent) {
		this.artContent = artContent;
	}   
    
    
}
