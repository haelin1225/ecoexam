package kr.co.eco.vo;

public class MemberVO {
	private String memberID;
	private String memberPW;
	private String memberEmail;
	private String memberCreateDate;
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(String memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	public String toString() {
		return "memberVO [memberID=" + memberID + ", memberPW=" + memberPW
				+ ", memberEmail=" + memberEmail + ", memberCreateDate="
				+ memberCreateDate + "]";
	}
	
}
