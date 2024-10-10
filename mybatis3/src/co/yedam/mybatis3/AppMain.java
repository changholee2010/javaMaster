package co.yedam.mybatis3;

import java.util.Scanner;

public class AppMain {
	// 메세지 보여주고.. 0.5초 있다가 화면 지우기.
	public static void scr(String msg) {
		try {
			System.out.println(msg);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}

	// 화면 지우기.
	public static void scrNoWait() {
		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		boolean run = true;
		scrNoWait();
		while (run) {
			System.out.println("-------------------");
			System.out.println("1.입출고 2.상품 9.종료");
			System.out.println("-------------------");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				scr("입출고를 선택했습니다.");
				TxnExe.getInstance().start();
				break;

			case 2:
				scr("상품메뉴를 선택했습니다.");
				ProductExe.getInstance().start();
				break;

			case 9:
				System.out.println("종료합니다.");
				run = false;
			}

		} // end of while.
		System.out.println("----- end of program. -----");
		scn.close();
	} // end of main.

}
