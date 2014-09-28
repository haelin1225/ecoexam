package kr.co.eco.vo;

public class ClubTestVO {
	private String testNo;
	private int clubNo;
	
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public int getclubNo() {
		return clubNo;
	}
	public void setclubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	
	public String toString() {
		return "clubTestVO [testNo=" + testNo + ", clubNo=" + clubNo + "]";
	}
}
