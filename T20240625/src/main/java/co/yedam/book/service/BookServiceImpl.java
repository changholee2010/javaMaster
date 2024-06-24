package co.yedam.book.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.book.mapper.BookMapper;
import co.yedam.common.DataSource;

public class BookServiceImpl implements BookService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	@Override
	public String cheeringMessage() {
		return mapper.selectMessage();
	}
}
