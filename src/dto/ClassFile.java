package dto;

public class ClassFile {

    private int classFileno;
    private int classno;
    private String classOriginFilename;
    private String classRenameFilename;
	@Override
	public String toString() {
		return "ClassFile [classFileno=" + classFileno + ", classno=" + classno + ", classOriginFilename="
				+ classOriginFilename + ", classRenameFilename=" + classRenameFilename + "]";
	}
	public int getClassFileno() {
		return classFileno;
	}
	public void setClassFileno(int classFileno) {
		this.classFileno = classFileno;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getClassOriginFilename() {
		return classOriginFilename;
	}
	public void setClassOriginFilename(String classOriginFilename) {
		this.classOriginFilename = classOriginFilename;
	}
	public String getClassRenameFilename() {
		return classRenameFilename;
	}
	public void setClassRenameFilename(String classRenameFilename) {
		this.classRenameFilename = classRenameFilename;
	}
    
    
}
