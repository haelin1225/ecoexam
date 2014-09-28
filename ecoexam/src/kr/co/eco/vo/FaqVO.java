package kr.co.eco.vo;

public class FaqVO {
	private int faqNo;
	private String faqTitle;
	private String faqContent;
	private String faqCreateDate;
	private int faqCount;
	private String category;
	private int boardNo;
	
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqCreateDate() {
		return faqCreateDate;
	}
	public void setFaqCreateDate(String faqCreateDate) {
		this.faqCreateDate = faqCreateDate;
	}
	public int getFaqCount() {
		return faqCount;
	}
	public void setFaqCount(int faqCount) {
		this.faqCount = faqCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	@Override
	public String toString() {
		return "FaqVO [faqNo=" + faqNo + ", faqTitle=" + faqTitle
				+ ", faqContent=" + faqContent + ", faqCreateDate="
				+ faqCreateDate + ", faqCount=" + faqCount + ", category="
				+ category + ", boardNo=" + boardNo + "]";
	}
	
}
