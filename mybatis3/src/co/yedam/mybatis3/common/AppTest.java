package co.yedam.mybatis3.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTest {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(today));
	}
}
