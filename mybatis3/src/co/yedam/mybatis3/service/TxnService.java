package co.yedam.mybatis3.service;

import java.util.List;
import java.util.Map;

import co.yedam.mybatis3.common.SearchDTO;
import co.yedam.mybatis3.vo.ProductVO;

public interface TxnService {
	boolean inOutTransactions(Map<String, Object> map);
	List<ProductVO> searchProduct(SearchDTO search);
	List<ProductVO> onhandList(SearchDTO search);
}
