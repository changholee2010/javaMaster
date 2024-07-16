package co.yedam.mybatis4.service;

import java.util.List;

import co.yedam.mybatis4.dao.BoardDAO;
import co.yedam.mybatis4.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	BoardDAO bdao = new BoardDAO();

	@Override
	public List<BoardVO> boardList() {
		return bdao.boardList();
	}

}
