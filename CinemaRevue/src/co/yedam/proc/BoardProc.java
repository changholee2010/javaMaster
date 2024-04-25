package co.yedam.proc;

import java.util.List;

import co.yedam.ScanUtils;
import co.yedam.dao.BoardDAO;
import co.yedam.dao.ReplyDAO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.ReplyVO;

public class BoardProc {

	private String logid;
	BoardDAO bdao = new BoardDAO();
	ReplyDAO rdao = new ReplyDAO();

	public BoardProc(String logid) {
		this.logid = logid;
	}

	// 처음 실행되는 메소드.
	public void exec() {
		int menu = -1;
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.목록 2.등록 3.삭제 9.게시판종료");
			System.out.println("-------------------------------------------------");
			menu = ScanUtils.chooseMenu("선택");

			switch (menu) {
			case 1:
				boardList();
				break;
			case 2:
				addBoard();
				break;
			case 3:
				delBoard();
				break;
			case 9:
				run = false;
				System.out.println("게시판 종료합니다.");
			}
		} // end of while.
	}// end of exec();

	// 글목록보기.
	void boardList() {
		int page = 1;
		while (true) {
			System.out.println("\n-------------------------------------------------");
			System.out.println("글번호          제목         작성자     작성일자    조회수");
			System.out.println("-------------------------------------------------");
			boardPaging(page);
			System.out.println("-------------------------------------------------");

			// 하위메뉴보여주기.
			String choice = ScanUtils.chooseVal("\n상세보기> (글번호) 이전페이지> p 다음페이지> n 이전메뉴: q");
			try {
				// 상세보기.
				readBoard(Integer.parseInt(choice));

			} catch (NumberFormatException e) {
				if (choice.equals("p")) {
					page--;
				} else if (choice.equals("n")) {
					page++;
				} else if (choice.equals("q")) {
					return;
				} else {
					System.out.println("다시 선택하세요.");
				}
			} // end of try.
		}
	} // end of boardList().

	// 게시글 페이징목록 보기.
	void boardPaging(int page) {
		List<BoardVO> list = bdao.boardList(page);
		for (BoardVO bvo : list) {
			System.out.println(bvo.showBrief());
		}
	}

	// 게시글 상세보기.
	void readBoard(int bno) {
		BoardVO bvo = bdao.selectBoard(bno);
		if (bvo != null) {
			System.out.println(bvo.showDetail());

			System.out.println("--------------------------------------------------");
			System.out.println("댓글번호        내용         작성자         작성일시\r\n"//
					+ "--------------------------------------------------");
			replyList(bno);
		} else {
			System.out.println("조회된 내용이 없습니다.");
		}

		String choice = ScanUtils.chooseVal("1.댓글달기 2.댓글삭제 q.이전메뉴");
		if (choice.equals("1")) {
			addReply(bno);
			readBoard(bno);
		} else if (choice.equals("2")) {
			delReply();
			readBoard(bno);
		} else {
			return;
		}

	} // 상세보기 종료.

	// 댓글목록보기.
	void replyList(int bno) {
		List<ReplyVO> list = rdao.replyList(bno);
		for (ReplyVO rvo : list) {
			System.out.println(rvo.briefShow());
		}
	}

	// 댓글등록
	void addReply(int bno) {
		String reply = ScanUtils.chooseVal("댓글입력");

		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(bno);
		rvo.setReply(reply);
		rvo.setReplyer(this.logid);

		rdao.insertReply(rvo);

		System.out.println("댓글달기완료.");
	}

	void delReply() {
		int rno = ScanUtils.chooseMenu("삭제할 댓글번호");
		if (rdao.deleteReply(rno)) {
			System.out.println("삭제완료.");
		} else {
			System.out.println("없는 댓글번호.");
		}
	}

	///////////////////////////////////////////////////////////
	// 글등록.
	void addBoard() {
		String title = ScanUtils.chooseVal("제목");
		String content = ScanUtils.chooseVal("내용");

		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(logid);

		if (bdao.insertBoard(bvo)) {
			System.out.println("등록완료");
		}

	}

	// 글삭제.
	void delBoard() {
		int bno = ScanUtils.chooseMenu("삭제글 번호");
		if (bdao.deleteBoard(bno)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("글번호 없음.");
		}

	}
	///////////////////////////////////////////////////////////

}
