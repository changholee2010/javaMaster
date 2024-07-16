package co.yedam.mybatis4.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mybatis4.common.DataSource;
import co.yedam.mybatis4.mapper.BoardMapper;
import co.yedam.mybatis4.vo.BoardVO;

public class BoardServiceMybatis implements BoardService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	}
}
