package co.yedam.vo;

import java.util.Date;

public class ReservationVO {
	private int reservationNo;
	private String movieCode;
	private String movieName;
	private String seatLine;
	private int seatNo;
	private String memberId;
	private Date reserveDate;
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getSeatLine() {
		return seatLine;
	}
	public void setSeatLine(String seatLine) {
		this.seatLine = seatLine;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	@Override
	public String toString() {
		return "ReservationVO [reservationNo=" + reservationNo + ", movieCode=" + movieCode + ", movieName=" + movieName
				+ ", seatLine=" + seatLine + ", seatNo=" + seatNo + ", memberId=" + memberId + ", reserveDate="
				+ reserveDate + "]";
	}

}