package dto;

import java.util.Date;

public class AskBoardComm {

    private int askCommno;    
    private int askBoardno;    
    private String commContent;    
    private Date commDate;
	@Override
	public String toString() {
		return "AskBoardComm [askCommno=" + askCommno + ", askBoardno=" + askBoardno + ", commContent=" + commContent
				+ ", commDate=" + commDate + "]";
	}
	public int getAskCommno() {
		return askCommno;
	}
	public void setAskCommno(int askCommno) {
		this.askCommno = askCommno;
	}
	public int getAskBoardno() {
		return askBoardno;
	}
	public void setAskBoardno(int askBoardno) {
		this.askBoardno = askBoardno;
	}
	public String getCommContent() {
		return commContent;
	}
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}
	public Date getCommDate() {
		return commDate;
	}
	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}  
    
    
}
