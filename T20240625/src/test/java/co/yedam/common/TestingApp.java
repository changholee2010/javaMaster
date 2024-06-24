package co.yedam.common;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;

public class TestingApp {
	public static void main(String[] args) {
//		SqlSession sqlSession = DataSource.getInstance().openSession(true);
//		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		BookService svc = new BookServiceImpl();

		System.out.println(svc.cheeringMessage());

	}
}
