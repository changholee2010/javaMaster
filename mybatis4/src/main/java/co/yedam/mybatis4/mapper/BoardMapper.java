package co.yedam.mybatis4.mapper;

import java.util.List;

import co.yedam.mybatis4.vo.BoardVO;
import co.yedam.mybatis4.vo.SearchVO;

public interface BoardMapper {
	List<BoardVO> boardList(SearchVO search);
}
