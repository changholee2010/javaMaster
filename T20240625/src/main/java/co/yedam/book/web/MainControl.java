package co.yedam.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.common.Control;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService svc = new BookServiceImpl();
		String cheers = svc.cheeringMessage();
		String hints = svc.hintMessage();

		req.setAttribute("message", cheers);
		req.setAttribute("hint", hints);

		req.getRequestDispatcher("WEB-INF/view/cheers.jsp")//
				.forward(req, resp);
	}

}
