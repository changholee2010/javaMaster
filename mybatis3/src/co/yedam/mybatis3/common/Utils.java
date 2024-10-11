package co.yedam.mybatis3.common;

public class Utils {

	public static void printWidth(int lnth, String msg) {
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
		System.out.print(String.format("%" + lnth + "s", msg).substring(0, lnth - (hwpCnt / 2)));
	}
}
