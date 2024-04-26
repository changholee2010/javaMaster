package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

public class BoardDAO extends DAO {

	// 회원조회.
	public MemberVO selectMember(String id, String pw) {
		conn();
		String sql = "select * from tbl_member where member_id=? and member_pw=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setMemberId(id);
				mvo.setMemberPw(pw);
				mvo.setMemberName(rs.getString("member_name"));
				return mvo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return null;

	}

	// 글목록
	public List<BoardVO> boardList(int page) {
		conn();
		String sql = "select * from tbl_board where title like '%'||?||'%' order by 1 desc";
		sql = "select o.*\r\n"//
				+ "from (select rownum rn, a.*\r\n"//
				+ "        from (select b.*\r\n"//
				+ "                 from tbl_board b\r\n"//
				+ "                 order by board_no desc) a\r\n"//
				+ "        where rownum <= (5 * ?)) o\r\n"//
				+ "where rn > (? - 1) * 5";
		List<BoardVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page);
			psmt.setInt(2, page);

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoardNo(rs.getInt("board_no"));
				bvo.setContent(rs.getString("content"));
				bvo.setTitle(rs.getString("title"));
				bvo.setViewCnt(rs.getInt("view_cnt"));
				bvo.setWriteDate(rs.getDate("write_date"));
				bvo.setWriter(rs.getString("writer"));

				list.add(bvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}

	public List<BoardVO> boardAll(String keyword) {
		conn();
		String sql = "select * from tbl_board where title like '%'||?||'%' order by 1 desc";
		List<BoardVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, keyword);

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoardNo(rs.getInt("board_no"));
				bvo.setContent(rs.getString("content"));
				bvo.setTitle(rs.getString("title"));
				bvo.setViewCnt(rs.getInt("view_cnt"));
				bvo.setWriteDate(rs.getDate("write_date"));
				bvo.setWriter(rs.getString("writer"));

				list.add(bvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}

	public BoardVO selectBoard(int bno) {
		conn();
		String sql = "select * from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoardNo(rs.getInt("board_no"));
				bvo.setContent(rs.getString("content"));
				bvo.setTitle(rs.getString("title"));
				bvo.setViewCnt(rs.getInt("view_cnt"));
				bvo.setWriteDate(rs.getDate("write_date"));
				bvo.setWriter(rs.getString("writer"));

				return bvo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return null;
	}

	// 글등록
	public boolean insertBoard(BoardVO board) {
		conn();
		String sql = "insert into tbl_board(board_no, title, content, writer)\r\n" //
				+ "values (board_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 글수정
	public boolean updateBoard(BoardVO board) {
		conn();
		String sql = "update tbl_board set content=?, title=? where board_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(2, board.getTitle());
			psmt.setString(1, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 글삭제
	public boolean deleteBoard(int bno) {
		conn();
		String sql = "delete from tbl_board where board_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
