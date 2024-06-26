package co.yedam.book.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.common.Control;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		Date dueDate = new Date();
		String remainTimeStr = "";
		try {

			dueDate = sdf.parse("2024-06-25 17:00:00");
			long diff = dueDate.getTime() - now.getTime();
			long h = diff / (1000 * 60 * 60);
			diff -= (h * (1000 * 60 * 60));
			long m = diff / (1000 * 60);
			diff -= (m * (1000 * 60));
			long s = diff / 1000;
			remainTimeStr = h + "시간 " //
					+ ("0" + m).substring(("0" + m).length() - 2) + "분 "//
					+ ("0" + s).substring(("0" + s).length() - 2) + "초 남음.";

		} catch (ParseException e) {
			e.printStackTrace();
		}

		BookService svc = new BookServiceImpl();
		String cheers = svc.cheeringMessage();
		String hints = svc.hintMessage(remainTimeStr);

		req.setAttribute("message", cheers);
		req.setAttribute("hint", hints);

		req.getRequestDispatcher("WEB-INF/view/cheers.jsp")//
				.forward(req, resp);
	}

}
