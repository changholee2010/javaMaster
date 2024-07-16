package co.yedam.mybatis4.service;

import java.util.List;

import co.yedam.mybatis4.vo.BoardVO;
import co.yedam.mybatis4.vo.SearchVO;

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
}
