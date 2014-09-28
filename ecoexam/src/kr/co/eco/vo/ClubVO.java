package kr.co.eco.vo;

public class ClubVO {
	private int clubNo;
	private String clubName;
	private String clubManagerID;
	private String clubClearOk;
	private int clubBoardNo;
	private String clubCreateDate;

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubManagerID() {
		return clubManagerID;
	}

	public void setClubManagerID(String clubManagerID) {
		this.clubManagerID = clubManagerID;
	}



	public String getClubClearOk() {
		return clubClearOk;
	}

	public void setClubClearOk(String clubClearOk) {
		this.clubClearOk = clubClearOk;
	}

	public int getClubBoardNo() {
		return clubBoardNo;
	}

	public void setClubBoardNo(int clubBoardNo) {
		this.clubBoardNo = clubBoardNo;
	}

	public String getClubCreateDate() {
		return clubCreateDate;
	}

	public void setClubCreateDate(String clubCreateDate) {
		this.clubCreateDate = clubCreateDate;
	}

	public String toString() {
		return "clubVO [clubNo=" + clubNo + ", clubName=" + clubName
				+ ", clubManagerID=" + clubManagerID + ", clubClearOk="
				+ clubClearOk + ", clubBoardNo=" + clubBoardNo
				+ ", clubCreateDate=" + clubCreateDate + "]";
	}

}
