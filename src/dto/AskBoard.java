package dto;

import java.util.Date;

public class AskBoard {

    private int askBoardno;
    private int userno;   
    private int artno;    
    private int classno;
    private Date askDate;    
    private String askContent;
	@Override
	public String toString() {
		return "AskBoard [askBoardno=" + askBoardno + ", userno=" + userno + ", artno=" + artno + ", classno=" + classno
				+ ", askDate=" + askDate + ", askContent=" + askContent + "]";
	}
	public int getAskBoardno() {
		return askBoardno;
	}
	public void setAskBoardno(int askBoardno) {
		this.askBoardno = askBoardno;
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
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public Date getAskDate() {
		return askDate;
	}
	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
    
    
}
