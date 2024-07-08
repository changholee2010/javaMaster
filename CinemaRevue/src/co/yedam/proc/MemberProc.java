package co.yedam.proc;

import co.yedam.common.ScanUtils;
import co.yedam.dao.BoardDAO;
import co.yedam.vo.MemberVO;

public class MemberProc {
	private String logId;

	public String getLogId() {
		return logId;
	}

	public boolean loginCheck() {
		BoardDAO dao = new BoardDAO();
		int loginCnt = 3;

		// 로그인체크.
		while (loginCnt-- > 0) {
			String id = ScanUtils.chooseVal("아이디");
			String pw = ScanUtils.chooseVal("비밀번호");
			MemberVO mvo = new MemberVO();
			mvo = dao.selectMember(id, pw);
			if (mvo != null) {
				System.out.println(mvo.getMemberName() + "님 환영합니다.");
				logId = id;
				return true;
			}
			if (loginCnt > 0)
				System.out.println("id와 pw를 확인하세요.");
		}
		return false;

	}
}
