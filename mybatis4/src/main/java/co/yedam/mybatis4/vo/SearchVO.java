package co.yedam.mybatis4.vo;

import lombok.Data;

@Data
public class SearchVO {
	private String orderBy;
	private String searchCondition; // T:title, W:writer, TW:: title or writer
	private String keyword;
}
