package co.yedam.book.mapper;

import java.util.List;

import co.yedam.book.vo.BookVO;

public interface BookMapper {
	String selectMessage();
	String selectHint();
	//추가.
	int insertBook(BookVO bvo);
	//삭제.
	int deleteBook(String bcode);
	//목록
	List<BookVO> selectList();
}
