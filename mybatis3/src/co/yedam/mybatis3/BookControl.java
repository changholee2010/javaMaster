package co.yedam.mybatis3;

import java.util.Scanner;

public class BookControl {
	// 목록, 검색, 대출, 반납, 대출목록
	BookDAO dao = new BookDAO();
	Scanner scn = new Scanner(System.in);

	void run() {

		while (true) {
			System.out.println("1.목록 2.검색 3.대출 4.반납 5.대여목록 6.이전메뉴");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				bookList();
				break;
			case 2:
				searchBook();
				break;
			case 3:
				rentBook();
				break;
			case 4:
				returnBook();
				break;
			case 5:
				rentList();
				break;
			case 6:
				System.out.println("이전메뉴 이동");
				return;
			default:
				System.out.println("메뉴를 선택하세요");
			}

		} // end of while.
	} // end of run.

	void bookList() {
		System.out.println("bookList");
	}

	void searchBook() {
		System.out.println("searchBook");

	}

	void rentBook() {
		System.out.println("rentBook");

	}

	void returnBook() {
		System.out.println("returnBook");

	}

	void rentList() {
		System.out.println("rentList");

	}
}
