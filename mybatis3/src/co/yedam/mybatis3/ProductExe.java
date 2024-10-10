package co.yedam.mybatis3;

import java.util.Scanner;

import co.yedam.mybatis3.service.ProdService;
import co.yedam.mybatis3.service.ProdServiceDAO;
import co.yedam.mybatis3.service.ProdServiceMybatis;

public class ProductExe {
	private static ProductExe instance = new ProductExe();

	private ProductExe() {
	}

	public static ProductExe getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
	ProdService svc = new ProdServiceDAO();
//	ProdService svc = new ProdServiceMybatis();

	public void start() {
		boolean run = true;

		while (run) {
			System.out.println("1.목록 2.등록 3.수정 4.삭제 9.이전");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				list();
				break;
			case 2:
				add();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				search();
				break;
			case 9:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!");
			}
		}
	}

	void menu() {
		System.out.println("1.목록 2.등록 3.수정 4.삭제 5.조회 9.이전");
		System.out.print("선택>> ");
	}

	// 목록.
	void list() {
		svc.productList().forEach(System.out::println);
	}

	// 추가.
	void add() {

	}

	// 수정.
	void modify() {

	}

	// 삭제.
	void remove() {

	}

	// 단건조회.
	void search() {

	}
}
