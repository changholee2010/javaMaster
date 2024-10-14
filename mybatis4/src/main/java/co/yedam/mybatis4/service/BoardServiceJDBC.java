package co.yedam.mybatis4.service;

import java.util.List;

import co.yedam.mybatis4.dao.BoardDAO;
import co.yedam.mybatis4.vo.BoardVO;
import co.yedam.mybatis4.vo.SearchVO;

public class BoardServiceJDBC implements BoardService {
	BoardDAO bdao = new BoardDAO();

	@Override
	public List<BoardVO> boardList(SearchVO search) {
		return bdao.boardList(search);
	}

}
