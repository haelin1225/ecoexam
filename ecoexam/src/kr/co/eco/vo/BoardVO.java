package kr.co.eco.vo;

public class BoardVO {
	private int boardNo;
	private String boardName;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardName=" + boardName + "]";
	}
	
}
