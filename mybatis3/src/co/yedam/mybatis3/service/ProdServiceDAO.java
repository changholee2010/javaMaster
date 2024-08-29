package co.yedam.mybatis3.service;

import java.util.List;

import co.yedam.mybatis3.dao.ProductDAO;
import co.yedam.mybatis3.vo.ProductVO;

public class ProdServiceDAO implements ProdService {

	ProductDAO dao = new ProductDAO();

	@Override
	public List<ProductVO> productList() {
		return dao.productList();
	}

	@Override
	public boolean addProduct(ProductVO pvo) {
		return false;
	}

	@Override
	public boolean removeProduct(String prodCode) {
		return false;
	}

	@Override
	public boolean modifyProduct(ProductVO pvo) {
		return false;
	}

	@Override
	public ProductVO getProduct(String prodCode) {
		return null;
	}

}
