package co.yedam.mybatis4;

import co.yedam.mybatis4.service.BoardService;
import co.yedam.mybatis4.service.BoardServiceMybatis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceMybatis();
		svc.boardList().forEach(System.out::println);
	}
}
