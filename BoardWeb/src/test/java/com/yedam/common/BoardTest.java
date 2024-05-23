package com.yedam.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.ReplyMapper;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class BoardTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);

		ReplyService svc = new ReplyServiceImpl();
		List<Map<String, String>> list = svc.categoryList();

		List<Map<String, Object>> categoryList = new ArrayList<>();
		Map<String, Object> catMap = null;
		List<String> catList = null;
		String curCateName = null, preCateName = null;
		for (Map<String, String> map : list) {
			String p_code, p_name, c_code, c_name;
			p_code = map.get("cate_col1");
			p_name = map.get("cate_col2");
			c_code = map.get("cate_col3");
			c_name = map.get("cate_col4");
			curCateName = p_name == null ? curCateName : p_name;
			if (p_code != null) {
				catMap = new HashMap<String, Object>();
				catList = new ArrayList<>();
				catMap.put("대분류", p_name);
			} else {
				catList.add(c_name);
			}
			if (!curCateName.equals(preCateName)) {
				catMap.put("소분류", catList);
				categoryList.add(catMap);
			}
			preCateName = curCateName;
		}
		// 결과보기.
		for (Map<String, Object> tmap : categoryList) {
			System.out.println(tmap);
		}
	}
}
