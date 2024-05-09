package com.yedam.common;

import java.util.Map;
import java.util.Set;

import com.yedam.dao.EmpDAO;

public class AppTest {
	public static void main(String[] args) {

		EmpDAO edao = new EmpDAO();
		Map<String, Integer> resultMap = edao.getCntPerDept();
		Set<String> keyset = resultMap.keySet();
		for (String key : keyset) {
			System.out.println("key: " + key + ", val: " + resultMap.get(key));
		}
	} // end of main().
}
