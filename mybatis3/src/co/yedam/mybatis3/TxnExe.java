package co.yedam.mybatis3;

import java.util.Scanner;

// 입출고 처리.
// 1.입고 2.출고 3.재고 9.상위
public class TxnExe {
	private static TxnExe instance = new TxnExe();

	private TxnExe() {
	}

	public static TxnExe getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);

	void start() {
		boolean run = true;
		while (run) {
			System.out.print("1.입고 2.출고 3.재고 9.상위");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				receipt();
				break;
			case 2:
				issue();
				break;
			case 3:
				onHand();
				break;
			case 9:
				System.out.println("이전메뉴로 이동합니다.");
				return;
			}

		} // end of while
	} // end of exe()

	void receipt() {

	}

	void issue() {

	}

	void onHand() {

	}
}
