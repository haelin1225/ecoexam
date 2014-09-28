package kr.co.eco.vo;

public class CorrectAnswerVO {
	private String testNo;
	private int questionNo;
	private String correctAnswer;
	private int questionPoint;
	
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
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getQuestionPoint() {
		return questionPoint;
	}
	public void setQuestionPoint(int questionPoint) {
		this.questionPoint = questionPoint;
	}
	
	public String toString() {
		return "CorrectAnswerVO [testNo=" + testNo + ", questionNo="
				+ questionNo + ", correctAnswer=" + correctAnswer
				+ ", questionPoint=" + questionPoint + "]";
	}
	
}
