package co.yedam.mybatis4.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.mybatis4.common.DAO;
import co.yedam.mybatis4.vo.BoardVO;

public class BoardDAO extends DAO {
	public List<BoardVO> boardList() {
		conn = getConn();
		String sql = "select * from tbl_board where rownum <= 10 order by board_no";
		List<BoardVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
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
			disConnect();
		}
		return list;
	} // end of boardList().

}
