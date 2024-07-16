package co.yedam.mybatis4;

import co.yedam.mybatis4.service.BoardService;
import co.yedam.mybatis4.service.BoardServiceImpl;
import co.yedam.mybatis4.service.BoardServiceMybatis;
import co.yedam.mybatis4.vo.SearchVO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SearchVO search = new SearchVO();
		// search condition: T(title), W(writer), TW(title or writer)
//		search.setSearchCondition("TW");
//		search.setKeyword("test");
		search.setOrderBy("writer");

		BoardService svc = new BoardServiceMybatis();
//		svc = new BoardServiceImpl();

		svc.boardList(search).forEach(System.out::println);
	}
}
