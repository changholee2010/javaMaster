package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.MovieVO;
import co.yedam.vo.ReservationVO;

public class CinemaDAO extends DAO {

	// 좌석의 예약여부 확인하기.
	public boolean alreadyReservedCheck(ReservationVO rvo) {
		conn();
		String sql = "select 1 from tbl_reservation"//
				+ "   where movie_code=? "//
				+ "   and   seat_line=? "//
				+ "   and   seat_no=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rvo.getMovieCode());
			psmt.setString(2, rvo.getSeatLine());
			psmt.setInt(3, rvo.getSeatNo());

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}

	// 예약.
	public boolean insertReservation(ReservationVO rvo) {
		conn();
		String sql = "insert into tbl_reservation values(reservation_seq.nextval, ?,?,?,?,sysdate)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rvo.getMovieCode());
			psmt.setString(2, rvo.getSeatLine());
			psmt.setInt(3, rvo.getSeatNo());
			psmt.setString(4, rvo.getMemberId());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}

	// 예약목록.
	public List<ReservationVO> reserveList(String runningRoom) {
		conn();
		String sql = "select r.movie_code" + "         ,r.reservation_no" + "         ,r.seat_line"
				+ "         ,r.seat_no" + "         ,r.member_id" + "         ,r.reserve_date"
				+ "         ,get_movie_name(r.movie_code) movie_name "//
				+ "from tbl_reservation r "//
				+ "join tbl_runtime t "//
				+ "on r.movie_code = t.movie_code "//
				+ "where t.running_type = 'Y' "//
				+ "and t.running_room = ?";
		List<ReservationVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, runningRoom);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReservationVO rvo = new ReservationVO();
				rvo.setMemberId(rs.getString("member_id"));
				rvo.setMovieCode(rs.getString("movie_code"));
				rvo.setMovieName(rs.getString("movie_name"));
				rvo.setReservationNo(rs.getInt("reservation_no"));
				rvo.setReserveDate(rs.getDate("reserve_date"));
				rvo.setSeatLine(rs.getString("seat_line"));
				rvo.setSeatNo(rs.getInt("seat_no"));

				list.add(rvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;

	} //

	// 상영작목록.
	public List<MovieVO> runningMovieList() {
		conn();
		String sql = "select r.movie_code, v.movie_name, r.running_room "//
				+ "from tbl_runtime r "//
				+ "join tbl_movie v "//
				+ "on r.movie_code = v.movie_code "//
				+ "where running_type='Y' " //
				+ "order by r.running_room ";
		List<MovieVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieCode(rs.getString("movie_code"));
				mvo.setMovieName(rs.getString("movie_name"));
				mvo.setRunningRoom(rs.getString("running_room"));
				list.add(mvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	} // end of method.

	public MovieVO getRunningMovie(int runningRoom) {
		conn();
		String sql = "select m.*\r\n"//
				+ "from tbl_movie  m\r\n"//
				+ "join tbl_runtime r\r\n"//
				+ "on m.movie_code = r.movie_code\r\n"//
				+ "where r.running_type='Y'\r\n"//
				+ "and r.running_room = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, runningRoom);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieCode(rs.getString("movie_code"));
				mvo.setMovieName(rs.getString("movie_name"));
				return mvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return null;
	}
}
