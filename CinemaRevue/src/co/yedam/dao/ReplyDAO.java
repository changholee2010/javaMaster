package co.yedam.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.ReplyVO;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.internal.OracleCallableStatement;

public class ReplyDAO extends DAO {

	// 글목록
	public List<ReplyVO> replyList(int bno) {
		conn();
		String sql = "select * from tbl_reply where board_no = ? order by 1 desc";
		List<ReplyVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);

			rs = psmt.executeQuery();

			while (rs.next()) {
				ReplyVO bvo = new ReplyVO();
				bvo.setBoardNo(rs.getInt("board_no"));
				bvo.setReply(rs.getString("reply"));
				bvo.setReplyDate(rs.getDate("reply_date"));
				bvo.setReplyer(rs.getString("replyer"));
				bvo.setReplyNo(rs.getInt("reply_no"));
				list.add(bvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}

	// 댓글등록
	public boolean insertReply(ReplyVO rvo) {
		conn();
		String sql = "insert into tbl_reply(reply_no, reply, replyer, board_no)\r\n" //
				+ "values (reply_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rvo.getReply());
			psmt.setString(2, rvo.getReplyer());
			psmt.setInt(3, rvo.getBoardNo());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 글삭제
	public boolean deleteReply(int rno) {
		conn();
		String sql = "delete from tbl_reply where reply_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rno);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 커서반환값 받기.
	public void getCursor() {
		conn();
		try {
			CallableStatement csmt = conn.prepareCall("begin create_order_item_proc(?,?); end; ");
			csmt.setString(1, "202406");
			csmt.registerOutParameter(2, OracleTypes.CURSOR);
			csmt.executeQuery();
			OracleCallableStatement ocsmt = (OracleCallableStatement) csmt;
			ResultSet rs = ocsmt.getCursor(2);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("end of while");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of getCursor.

}
