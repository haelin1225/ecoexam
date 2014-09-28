package kr.co.eco.vo;

public class ClubJoinVO {
	private int clubNo;
	private String memberID;
	private String clubRole;
	private String clubJoinDate;
	private String clubAgreeOk;
	
	public int getClubNo() {
		return clubNo;
	}
	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getClubRole() {
		return clubRole;
	}
	public void setClubRole(String clubRole) {
		this.clubRole = clubRole;
	}
	public String getClubJoinDate() {
		return clubJoinDate;
	}
	public void setClubJoinDate(String clubJoinDate) {
		this.clubJoinDate = clubJoinDate;
	}
	public String getClubAgreeOk() {
		return clubAgreeOk;
	}
	public void setClubAgreeOk(String clubAgreeOk) {
		this.clubAgreeOk = clubAgreeOk;
	}
	
	public String toString() {
		return "clubJoinVO [clubNo=" + clubNo + ", memberID=" + memberID
				+ ", clubRole=" + clubRole + ", clubJoinDate="
				+ clubJoinDate + ", clubAgreeOk=" + clubAgreeOk + "]";
	}
	
}
