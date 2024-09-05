package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// id, pw 파라미터.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.login(id, pw);
		mvo = new MemberVO();
		mvo.setUserId("test");
		mvo.setResponsibility("User");

//		if (mvo == null) {
//			resp.sendRedirect("logForm.do");
//		}

		HttpSession session = req.getSession();
		session.setAttribute("logId", mvo.getUserId());

		// 관리자, 회원.
		if (mvo.getResponsibility().equals("Admin"))
			resp.sendRedirect("memberList.do");
		else {
			String reqPath = (String) session.getAttribute("reqPath");
			if (reqPath != null) {
				resp.sendRedirect(reqPath);
				return;
			}
			resp.sendRedirect("main.do");
		}

	}

}
