package kr.co.eco.vo;

public class ExampleVO {
	private String testNo;
	private int questionNo;
	private int exampleNo;
	private String exampleContent;
	
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
	public int getExampleNo() {
		return exampleNo;
	}
	public void setExampleNo(int exampleNo) {
		this.exampleNo = exampleNo;
	}
	public String getExampleContent() {
		return exampleContent;
	}
	public void setExampleContent(String exampleContent) {
		this.exampleContent = exampleContent;
	}
	
	public String toString() {
		return "ExampleVO [testNo=" + testNo + ", questionNo=" + questionNo
				+ ", exampleNo=" + exampleNo + ", exampleContent="
				+ exampleContent + "]";
	}
	
}
