package kr.co.eco.vo;

import org.springframework.web.multipart.MultipartFile;

public class TestVO {
	private String testNo;
	private String testMakerID;
	private String testName;
	private int testTime;
	private int testTotalScore;
	private String testPoint;
	private String testKind;
	private int testExampleCount;
	private int testTotalQuestion;
	private String testFileName;
	private String testCreateDate;
	private MultipartFile updloadFile;
	
	public MultipartFile getUpdloadFile() {
		return updloadFile;
	}
	public void setUpdloadFile(MultipartFile updloadFile) {
		this.updloadFile = updloadFile;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public String getTestMakerID() {
		return testMakerID;
	}
	public void setTestMakerID(String testMakerID) {
		this.testMakerID = testMakerID;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public int getTestTotalScore() {
		return testTotalScore;
	}
	public void setTestTotalScore(int testTotalScore) {
		this.testTotalScore = testTotalScore;
	}
	public String getTestPoint() {
		return testPoint;
	}
	public void setTestPoint(String testPoint) {
		this.testPoint = testPoint;
	}
	public String getTestKind() {
		return testKind;
	}
	public void setTestKind(String testKind) {
		this.testKind = testKind;
	}
	public int getTestExampleCount() {
		return testExampleCount;
	}
	public void setTestExampleCount(int testExampleCount) {
		this.testExampleCount = testExampleCount;
	}
	public int getTestTotalQuestion() {
		return testTotalQuestion;
	}
	public void setTestTotalQuestion(int testTotalQuestion) {
		this.testTotalQuestion = testTotalQuestion;
	}
	public String getTestFileName() {
		return testFileName;
	}
	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}
	public String getTestCreateDate() {
		return testCreateDate;
	}
	public void setTestCreateDate(String testCreateDate) {
		this.testCreateDate = testCreateDate;
	}
	@Override
	public String toString() {
		return "TestVO [testNo=" + testNo + ", testMakerID=" + testMakerID
				+ ", testName=" + testName + ", testTime=" + testTime
				+ ", testTotalScore=" + testTotalScore + ", testPoint="
				+ testPoint + ", testKind=" + testKind + ", testExampleCount="
				+ testExampleCount + ", testTotalQuestion=" + testTotalQuestion
				+ ", testFileName=" + testFileName + ", testCreateDate="
				+ testCreateDate + "]";
	}

}
