package co.yedam.mybatis3.mapper;

import java.util.List;

import co.yedam.mybatis3.vo.ProductVO;

public interface ProductMapper {
	// 목록.등록.수정.삭제.조회.
	List<ProductVO> selectList();
	int insertProduct(ProductVO pvo);
	int updateProduct(ProductVO pvo);
	int deleteProduct(String prodCode);
	ProductVO selectProduct(String prodCode);
}
