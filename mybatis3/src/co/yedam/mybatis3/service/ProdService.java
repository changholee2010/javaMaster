package co.yedam.mybatis3.service;

import java.util.List;

import co.yedam.mybatis3.vo.ProductVO;

public interface ProdService {
	// 목록. 등록. 삭제. 수정, 단건조회.
	List<ProductVO> productList();
	boolean addProduct(ProductVO pvo);
	boolean removeProduct(String prodCode);
	boolean modifyProduct(ProductVO pvo);
	ProductVO getProduct(String prodCode);
}
