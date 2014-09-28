package kr.co.eco.vo;

public class CommentsVO {
	private int commentsNo;
	private int postNo;
	private String memberID;
	private String commentsContent;
	private String commentsCreateDate;
	
	public int getCommentsNo() {
		return commentsNo;
	}
	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	public String getCommentsCreateDate() {
		return commentsCreateDate;
	}
	public void setCommentsCreateDate(String commentsCreateDate) {
		this.commentsCreateDate = commentsCreateDate;
	}
	
	public String toString() {
		return "CommentsVO [commentsNo=" + commentsNo + ", postNo=" + postNo
				+ ", memberID=" + memberID + ", commentsContent=" + commentsContent
				+ ", commentsCreateDate=" + commentsCreateDate + "]";
	}
	
}
