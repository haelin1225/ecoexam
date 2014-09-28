package kr.co.eco.vo;

public class GradeVO {
	private int clubNo;
	private String memberID;
	private String testNo;
	private int grade;
	
	public int getclubNo() {
		return clubNo;
	}
	public void setclubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	public String getmemberID() {
		return memberID;
	}
	public void setmemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String toString() {
		return "GradeVO [clubNo=" + clubNo + ", memberID=" + memberID
				+ ", testNo=" + testNo + ", grade=" + grade + "]";
	}
	
}
