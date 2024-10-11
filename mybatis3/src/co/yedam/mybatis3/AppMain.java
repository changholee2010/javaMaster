package co.yedam.mybatis3;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mybatis3.common.DataSource;

public class AppMain {

	// main...start here.
	public static void main(String[] args) {

		// log를 출력하는 것을 미리 한번 보이고 실행중에는 안보이도록 하기 위한 용도.
		SqlSession sqlSession = DataSource.getInstance().openSession(true);

		// 변수 초기화.
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		scrNoWait(); // 화면의 메뉴를 아래쪽에 출력하기.

		while (run) {
			System.out.println("-------------------");
			System.out.println("1.입출고처리 2.상품관리 9.종료");
			System.out.println("-------------------");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				scr("입출고처리를 선택했습니다.");
				TxnExe.getInstance().start();
				break;

			case 2:
				scr("상품관리를 선택했습니다.");
				ProductExe.getInstance().start();
				break;

			case 9:
				scr("종료합니다.");
				run = false;
			}

		} // end of while.
		System.out.println("----- end of program. -----");
		scn.close();
	} // end of main.

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

}
