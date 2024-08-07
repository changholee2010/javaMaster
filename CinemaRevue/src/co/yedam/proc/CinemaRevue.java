package co.yedam.proc;

import co.yedam.common.ScanUtils;

public class CinemaRevue {

	public void start() {
		boolean run = true;
		while (run) {
			mainMenuPrint();
			int menu = ScanUtils.chooseMenu("선택");

			switch (menu) {
			case 1: // 영화예매
				CinemaProc.getInstance().exe();
				break;
			case 2: // 포인트조회
				break;
			case 3: // 게시판
				BoardProc.getInstance().exec();
//				startBoard();
				break;
			default: // 종료
				System.out.println("종료합니다.");
				run = false;
			}
		}
		System.out.println("<< End Of Program >>");
	} // end of start()

	private void mainMenuPrint() {
		String msg = "===========================================================\r\n"//
				+ "                   영화예매 키오스크 ver 1.0\r\n"
				+ "-----------------------------------------------------------\r\n" //
				+ "- 1.영화예매 2.포인트조회 3.게시판 9.종료\r\n"//
				+ "-----------------------------------------------------------";
		System.out.println(msg);
	}

	// 로그인 기능을 CinemaRevue에서 구현할 경우.
	private void startBoard() {
		MemberProc mproc = new MemberProc();
		if (mproc.loginCheck()) {
			BoardProc bproc = new BoardProc(mproc.getLogId());
			bproc.exec();
		}
	}
}
