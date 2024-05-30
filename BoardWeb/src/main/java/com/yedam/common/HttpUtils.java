package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpUtils {
	public static void forward(HttpServletRequest req//
			, HttpServletResponse resp//
			, String path) { // 원래 이동하려고 했던 페이지.

		try {
			// 로그인정보가 없으면 이동해야할 페이지 지정.
			String logPath = (String) req.getAttribute("redirectPath");

			HttpSession session = req.getSession();
			// 로그인정보가 있어야 가능.
			if (logPath != null && session.getAttribute("logId") == null) {
				session.setAttribute("reqPath", path); // reqPath: 로그인 전에 요청했던 페이지.
				resp.sendRedirect(req.getContextPath() + logPath);
				return;
			}
			// 로그인정보가 없어도 가능.
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
