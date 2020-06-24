package dto;

import java.util.Date;

public class ClassInfo {
	
	private int classno;
	private int artno;
	private String className;
	private int category;
	private int location;
	private int classprice;
	private int talentDonation;
	private Date postdate;
	private Date recruitStartdate;
    private Date recruitEnddate;
    private int maxPeople;
    private int minPeople;
    private Date classStartdate;
    private Date classEnddate;
    private String classContent;
    private int postStatus;
    private int classCheck;
     

	@Override
	public String toString() {
		return "ClassInfo [classno=" + classno + ", artno=" + artno + ", className=" + className + ", category="
				+ category + ", location=" + location + ", classprice=" + classprice + ", talentDonation="
				+ talentDonation + ", postdate=" + postdate + ", recruitStartdate=" + recruitStartdate
				+ ", recruitEnddate=" + recruitEnddate + ", maxPeople=" + maxPeople + ", minPeople=" + minPeople
				+ ", classStartdate=" + classStartdate + ", classEnddate=" + classEnddate + ", classContent="
				+ classContent + ", postStatus=" + postStatus + ", classCheck=" + classCheck + "]";
	}

	
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getArtno() {
		return artno;
	}
	public void setArtno(int artno) {
		this.artno = artno;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getClassprice() {
		return classprice;
	}
	public void setClassprice(int classprice) {
		this.classprice = classprice;
	}
	public int getTalentDonation() {
		return talentDonation;
	}
	public void setTalentDonation(int talentDonation) {
		this.talentDonation = talentDonation;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Date getRecruitStartdate() {
		return recruitStartdate;
	}
	public void setRecruitStartdate(Date recruitStartdate) {
		this.recruitStartdate = recruitStartdate;
	}
	public Date getRecruitEnddate() {
		return recruitEnddate;
	}
	public void setRecruitEnddate(Date recruitEnddate) {
		this.recruitEnddate = recruitEnddate;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getMinPeople() {
		return minPeople;
	}
	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}
	public Date getClassStartdate() {
		return classStartdate;
	}
	public void setClassStartdate(Date classStartdate) {
		this.classStartdate = classStartdate;
	}
	public Date getClassEnddate() {
		return classEnddate;
	}
	public void setClassEnddate(Date classEnddate) {
		this.classEnddate = classEnddate;
	}
	public String getClassContent() {
		return classContent;
	}
	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}
	public int getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}
	public int getClassCheck() {
		return classCheck;
	}
	public void setClassCheck(int classCheck) {
		this.classCheck = classCheck;
	}
    
    
	

}
