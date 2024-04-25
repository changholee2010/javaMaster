package co.yedam.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", viewCnt=" + viewCnt + "]";
	}

	public String showBrief() {
		while (10 > title.length()) {
			title += " ";
		}
		// 1 게시판테스트1 user01 2024-04-22 3
		return String.format(" %3d  %-10s\t%8s  %10s %3d", boardNo, title.substring(0, 10), writer, writeDate, viewCnt);
	}

	public String showDetail() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String message = "           <<글상세화면>>\n";
		message += "---------------------------------------------\n";
		message += "글번호: " + boardNo + "   제목: 게시판테스트1\n";
		message += "내용: " + content + "\n";
		message += "작성일시: " + sdf.format(writeDate) + "\n";
		message += "작성자: " + writer + "   조회수: " + viewCnt + "\n";
		message += "---------------------------------------------";

//		String.format(message, boardNo, title, content, writer, writeDate, viewCnt);
		return message;
	}

}
