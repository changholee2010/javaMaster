package co.yedam.book.service;

import java.util.List;

import co.yedam.book.vo.BookVO;

public interface BookService {
	String cheeringMessage();
	String hintMessage();
	// 목록
	List<BookVO> bookList();
	// 추가
	boolean addBook(BookVO bvo);
	// 삭제
	boolean removeBook(String bcode);	
}
