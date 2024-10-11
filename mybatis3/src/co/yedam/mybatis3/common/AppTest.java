package co.yedam.mybatis3.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTest {
	public static void main(String[] args) {
		int lnth = 5;

		String str0 = "123456789012345678901234567890";
//		String str0 = "__모나미 0.5mm 샤프_____________";
		System.out.println(String.format("%" + lnth + "s", str0.substring(0, lnth)));
		String str1 = "모나미의 0.5mm 샤프심";
		str1 = "안녕하세요a 모나미 1.00mm 샤프와 노트입니다.";
		str1 = "P001";
		String[] ary1 = str1.split("");
		int hwpCnt = 0;
		int totalLength = 0;
		for (int i = 0; //
				(i < ary1.length && ary1.length < lnth) || (totalLength < lnth * 2 && ary1.length > lnth); //
				i++) {
			if (ary1[i].charAt(0) > 200) {
//				System.out.print(ary1[i]);
				hwpCnt++;
				totalLength += 3;
			} else {
				totalLength += 2;
			}
		}
//		System.out.println();
		// 25개의 문자보다 적은 내용일 경우에는 공백을 " " 을 더 추가해준다. 한글이 홀수개 있을 경우에는 "ㅇ"를 임의로 붙여줌.
		for (int i = ary1.length; i <= lnth; i++) {
			if (hwpCnt % 2 == 1) {
				str1 += "ㅇ";
				hwpCnt++;
			} else {
				str1 += " ";
			}
		}
//		System.out.println(String.format("%25s", str1).substring(0, lnth));
		System.out.println(String.format("%" + lnth + "s", str1).substring(0, lnth - (hwpCnt / 2)));
//		System.out.println(hwpCnt);

	}

	void printWidth(int lnth, String msg) {
		String[] ary1 = msg.split("");
		int hwpCnt = 0;
		int totalLength = 0;
		for (int i = 0; //
				(i < ary1.length && ary1.length < lnth) || (totalLength < lnth * 2 && ary1.length > lnth); //
				i++) {
			if (ary1[i].charAt(0) > 200) {
				hwpCnt++;
				totalLength += 3;
			} else {
				totalLength += 2;
			}
		}
		// 25개의 문자보다 적은 내용일 경우에는 공백을 " " 을 더 추가해준다. 한글이 홀수개 있을 경우에는 "ㅇ"를 임의로 붙여줌.
		for (int i = ary1.length; i <= lnth; i++) {
			if (hwpCnt % 2 == 1) {
				msg += "ㅇ";
				hwpCnt++;
			} else {
				msg += " ";
			}
		}
		System.out.println(String.format("%" + lnth + "s", msg).substring(0, lnth - (hwpCnt / 2)));
	}
}
