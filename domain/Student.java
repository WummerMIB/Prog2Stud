package domain;


public class Student {
   private String name;
   private String forename;
   private String faculty;
   private String course;
   private int semesterYear;
   private int mtkNumberStarter = 22100000;
   private static int numberOfExistingStudents;
   private int mtkNumber;

   public Student( String name, String forename, String faculty, String course,int semesterYear, int mtkNumber) {
		this.name = name;
		this.forename = forename;
		this.faculty = faculty;
		this.course = course;
		this.semesterYear = semesterYear;
		this.mtkNumber = mtkNumber;
	}

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public int getSemesterYear() {
		return semesterYear;
	}
	public void setSemesterYear(int semesterYear) {
		this.semesterYear = semesterYear;
	}

	public void setMtkNumber(int mtkNumber){
		this.mtkNumber = mtkNumberStarter + createMtkNumber();
	}

	public int getMtkNumber(){
		return mtkNumber;
	}

	public static int createMtkNumber(){
		return numberOfExistingStudents++;
		   
	}


	public String toString(){
		return name+" "+forename+" "+faculty+" "+course+" "+semesterYear+" "+ mtkNumber;
	}

}
