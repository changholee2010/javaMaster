package co.yedam;

import java.util.Scanner;

public class ScanUtils {
	static String NUMBER_EXCEPTION = "숫자를 입력하세요.";
	static Scanner scn = new Scanner(System.in);

	public static int chooseMenu(String msg) {
		int menu = -1;
		while (true) {
			System.out.print(msg + ">> ");
			try {
				menu = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(NUMBER_EXCEPTION);
//				scn.nextLine();
			}
		}
		return menu;
	}

	public static String chooseVal(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
}
