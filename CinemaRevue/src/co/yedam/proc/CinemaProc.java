package co.yedam.proc;

import java.util.List;

import co.yedam.common.ScanUtils;
import co.yedam.dao.CinemaDAO;
import co.yedam.vo.MovieVO;
import co.yedam.vo.ReservationVO;

public class CinemaProc {
	private static CinemaProc instance;
	CinemaDAO cdao = new CinemaDAO();

	private CinemaProc() {
	}

	public static CinemaProc getInstance() {
		if (instance == null)
			instance = new CinemaProc();
		return instance;
	}

	public void exe() {
		boolean run = true;
		// while (run) {
		int runningRoom = printMovie();
		reserveMovie(runningRoom);
		// }
	} // end of exe().

	void reserveMovie(int runningRoom) {
		List<ReservationVO> rlist = null;

		rlist = cdao.reserveList(runningRoom + "");
		showReserveSeat(rlist);

		String sline = ScanUtils.chooseVal("좌석선택");
		int sno = ScanUtils.chooseMenu("번호선택");

		if (ScanUtils.chooseYN("예약하시겠습니까? (Y/n) ")) {
			ReservationVO rvo = new ReservationVO();
			rvo.setMemberId("user01");
			rvo.setMovieCode(cdao.getRunningMovie(runningRoom).getMovieCode());
			rvo.setSeatLine(sline);
			rvo.setSeatNo(sno);

			if (cdao.insertReservation(rvo)) {
				System.out.println("예약이 완료되었습니다.");
				rlist = cdao.reserveList(runningRoom + "");
				showReserveSeat(rlist);
			}
		} else {
			System.out.println("취소를 선택했습니다.");
		}

	} // end of reserveMovie.

	void showReserveSeat(List<ReservationVO> rlist) {

		String[] lineAry = { "A", "B", "C", "D" };

		System.out.println("================================================================");
		System.out.println("               1관 범죄도시 (전체 40/ 예약 5)");
		System.out.println("----------------------------------------------------------------");

		for (int i = 0; i < lineAry.length; i++) {
			System.out.println("  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  |");
			String seatLine = lineAry[i];

			for (int j = 0; j < 10; j++) {
				// A, 3
				int seatNo = j + 1;
				boolean seatExist = false;

				// 컬렉션에서 해당값이 있는 지 확인.
				for (ReservationVO rvo : rlist) {
					if (rvo.getSeatLine().equals(seatLine) && rvo.getSeatNo() == seatNo) {
						seatExist = true;
						break;
					}
				}

				if (seatExist)
					System.out.print(String.format(" %3s |", "(O)"));
				else
					System.out.print(String.format(" %3s |", "   "));

				if (j == 9) {
					System.out.println(lineAry[i] + "열");
				}
			}
			System.out.println("----------------------------------------------------------------");
		}
	}

	int printMovie() {
		List<MovieVO> list = cdao.runningMovieList();
		String movie = "-----------------------------------------------------------\r\n";//
		for (MovieVO mvo : list) {
//		movie += "1. 1관(범죄도시) 2. 2관(쿵푸팬더) 3. 3관(챌린저스) 4. 4관(파묘)\r\n";//
			movie += mvo.getRunningRoom() + ". " + mvo.getRunningRoom() + "관(" + mvo.getMovieName() + ") ";
		}
		movie += "\n-----------------------------------------------------------\r\n";
		System.out.println(movie);
		return ScanUtils.chooseMenu("영화관");
	} // end of printMovie()

}
