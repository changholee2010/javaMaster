package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.web.BookForm;
import co.yedam.book.web.BookList;
import co.yedam.common.Control;

// init -> service -> destroy.
public class FrontController extends HttpServlet {

	// Map타입으로 url과 실행할 클래스.
	Map<String, Control> controls;

	public FrontController() {
		controls = new HashMap<>();
	}

	// init. 최초한번 실행.
	@Override
	public void init(ServletConfig config) throws ServletException {
		controls.put("bookForm.do", new BookForm());
		
	}

	// service. 요청때마다 실행.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // post일 경우.

		String uri = req.getRequestURI(); // 현재 페이지의 url.
		String context = req.getContextPath(); // 어플리케이션
		String path = uri.substring(context.length());
		System.out.println("path: " + path);

		Control control = controls.get(path);
		control.exec(req, resp); // 요청url에 따른 실행컨트롤을 호출.

	}

}
