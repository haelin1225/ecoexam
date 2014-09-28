package kr.co.eco.vo;

public class MemberAnswerVO {
	private String testNo;
	private String memberID;
	private int questionNo;
	private String memberAnswer;
	

	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public String getmemberID() {
		return memberID;
	}
	public void setmemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getmemberAnswer() {
		return memberAnswer;
	}
	public void setmemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}
	
	public String toString() {
		return "memberAnswerVO [testNo=" + testNo + ", memberID=" + memberID
				+ ", questionNo=" + questionNo + ", memberAnswer=" + memberAnswer
				+ "]";
	}
	
	
}
