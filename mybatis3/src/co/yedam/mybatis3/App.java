package co.yedam.mybatis3;

import co.yedam.mybatis3.service.ProdService;
import co.yedam.mybatis3.service.ProdServiceDAO;
import co.yedam.mybatis3.service.ProdServiceMybatis;

public class App {
	public static void main(String[] args) {
		System.out.println("start");
//		ProdService svc = new ProdServiceDAO();
		ProdService svc = new ProdServiceMybatis();

		svc.productList().forEach(prod -> {
			System.out.println(prod.toString());
		});
		System.out.println("end");
	}
}
