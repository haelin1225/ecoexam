package kr.co.eco.vo;

public class ClubMemberVO {
	private String memberID;
	private String memberEmail;
	private String clubJoinDate;
	private String clubAgreeOk;
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
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
	@Override
	public String toString() {
		return "ClubMemberVO [memberID=" + memberID + ", memberEmail="
				+ memberEmail + ", clubJoinDate=" + clubJoinDate
				+ ", clubAgreeOk=" + clubAgreeOk + "]";
	}

}
