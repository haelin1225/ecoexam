package kr.co.eco.vo;

public class QuestionVO {
	private String testNo;
	private int questionNo;
	private String question;
	private String questionContent;
	private String questionKind;
	

	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionKind() {
		return questionKind;
	}
	public void setQuestionKind(String questionKind) {
		this.questionKind = questionKind;
	}
	
	public String toString() {
		return "QuestionVO [testNo=" + testNo + ", questionNo=" + questionNo
				+ ", question=" + question + ", questionContent="
				+ questionContent + ", questionKind=" + questionKind + "]";
	}
	
}
