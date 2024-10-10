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
			System.out.println("-------------------------------------");
			System.out.println("1.목록 2.등록 3.수정 4.삭제 9.상위메뉴로 이동");
			System.out.println("-------------------------------------");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				AppMain.scr("상품목록을 선택했습니다.");
				list();
				break;
			case 2:
				AppMain.scr("상품등록을 선택했습니다.");
				add();
				break;
			case 3:
				AppMain.scr("상품수정을 선택했습니다.");
				modify();
				break;
			case 4:
				AppMain.scr("상품삭제를 선택했습니다.");
				remove();
				break;
			case 5:
				search();
				break;
			case 9:
				AppMain.scr("상위메뉴로 이동합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택하세요!");
			}
		}
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
