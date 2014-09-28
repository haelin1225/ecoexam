package kr.co.eco.vo;

public class PostNoVO {
	private int postNo;
	private int pre_postNo;
	private int next_postNo;
	
	public int getPostNo() {
		return postNo;
	}
	
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	public int getPre_postNo() {
		return pre_postNo;
	}
	
	public void setPre_postNo(int pre_postNo) {
		this.pre_postNo = pre_postNo;
	}
	
	public int getNext_postNo() {
		return next_postNo;
	}
	
	public void setNext_postNo(int next_postNo) {
		this.next_postNo = next_postNo;
	}

	@Override
	public String toString() {
		return "PostNoVO [postNo=" + postNo + ", pre_postNo=" + pre_postNo
				+ ", next_postNo=" + next_postNo + "]";
	}
		
}
