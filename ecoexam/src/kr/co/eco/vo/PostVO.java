package kr.co.eco.vo;

public class PostVO {
	private int postNo;
	private String postTitle;
	private String memberID;
	private String postContent;
	private String postCreateDate;
	private int postCount;
	private int boardNo;
	
	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCreateDate() {
		return postCreateDate;
	}

	public void setPostCreateDate(String postCreateDate) {
		this.postCreateDate = postCreateDate;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String toString() {
		return "PostVO [postNo=" + postNo + ", postTitle=" + postTitle
				+ ", memberID=" + memberID + ", postContent=" + postContent
				+ ", postCreateDate=" + postCreateDate + ", postCount="
				+ postCount + ", boardNo=" + boardNo + "]";
	}
	
}
