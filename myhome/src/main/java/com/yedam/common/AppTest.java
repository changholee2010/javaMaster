package com.yedam.common;

import java.util.List;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

public class AppTest {
	public static void main(String[] args) {

		EmpVO evo = new EmpVO();
		evo.setEmpName("testname");
		evo.setEmpPhone("02-1010-2020");
		evo.setHireDate("2020-01-05");
		
		evo.setEmail("test44@email.com");
		evo.setSalary(4600);
		evo.setEmpNo(43);

		EmpDAO edao = new EmpDAO();
		if (edao.deleteEmp(evo.getEmpNo())) {
			System.out.println("처리성공.");
		} else {
			System.out.println("처리실패.");
		}

		System.out.println("====목록=====");
		List<EmpVO> list = edao.selectList();
		for (EmpVO vo : list) {
			System.out.println(vo.toString());
		}
	}
}
