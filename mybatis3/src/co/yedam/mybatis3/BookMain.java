package co.yedam.mybatis3;

import java.util.Scanner;

public class BookMain {
	static String logId;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		BookControl ctrl = new BookControl();

		boolean run = true;

		while (run) {
			if (logId == null)
				System.out.println("1.도서목록 2.도서검색 3.로그인 4.종료");
			else
				System.out.println("1.도서목록 2.도서검색 3.로그아웃 4.종료");

			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("도서목록메뉴");
				ctrl.bookList();
				break;
			case 2:
				System.out.println("도서검색메뉴");
				ctrl.searchBook();
				break;
			case 3:
				login();
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 선택하세요");
			}
		} // end of while.
		System.out.println("end of prog.");
		scn.close();
	} // end of main.

	static void login() {
		if (logId == null) {
			logId = "user01";
		} else {
			logId = null;
			return;
		}

		BookControl ctrl = new BookControl();
		ctrl.run();
	}
}
