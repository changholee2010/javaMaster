package co.yedam.mybatis3.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.mybatis3.common.SearchDTO;
import co.yedam.mybatis3.vo.ProductVO;

public interface TxnMapper {
	List<ProductVO> searchList(SearchDTO search);
	int insertTransactions(Map map);
	List<ProductVO> onhandList(SearchDTO search);
}
