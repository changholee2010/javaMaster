package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class CateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		ReplyService svc = new ReplyServiceImpl();
		List<Map<String, String>> list = svc.categoryList();

		// 새로 생성할 목록.
		List<Map<String, Object>> categoryList = new ArrayList<>();
		Map<String, Object> catMap = null;
		List<String> catList = null;
		String curCateName = null, preCateName = null;
		// 반복문. 데이터 건수만큼 반복하고 있음.
		String p_code, p_name, c_code, c_name;
		for (Map<String, String> map : list) {
			p_code = map.get("cate_col1");
			p_name = map.get("cate_col2");
			c_code = map.get("cate_col3");
			c_name = map.get("cate_col4");
			curCateName = p_name == null ? curCateName : p_name; // 현재대분류에 값을 확인.

			if (p_code != null) { // 대분류일 경우에...
				catMap = new HashMap<String, Object>(); // 컬렉션에 담을 값을 초기화.
				catList = new ArrayList<>();
				catMap.put("p_cat", p_name); // 대분류는 하나 담아둔다.
			} else { // 소분류일 경우에...
				catList.add(c_name); // 소분류를 담는다.
			}
			if (!curCateName.equals(preCateName)) { // 대분류 바뀔 경우에...
				catMap.put("c_cat", catList);
				categoryList.add(catMap);
			}
			preCateName = curCateName;
		}
		// 결과보기.
		for (Map<String, Object> tmap : categoryList) {
			System.out.println(tmap);
		}

//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(categoryList);
//
//		resp.getWriter().print(json);
		req.setAttribute("list", categoryList);
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

}
