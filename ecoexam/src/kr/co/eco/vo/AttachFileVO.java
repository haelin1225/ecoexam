package kr.co.eco.vo;

public class AttachFileVO {
	private int fileNo;
	private int postNo;
	private String fileName;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String toString() {
		return "AttachFileVO [fileNo=" + fileNo + ", postNo=" + postNo
				+ ", fileName=" + fileName + "]";
	}
	
}
