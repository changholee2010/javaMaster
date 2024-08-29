package co.yedam.mybatis3.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mybatis3.common.DataSource;
import co.yedam.mybatis3.mapper.ProductMapper;
import co.yedam.mybatis3.vo.ProductVO;

public class ProdServiceMybatis implements ProdService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

	@Override
	public List<ProductVO> productList() {
		return mapper.selectList();
	}

	@Override
	public boolean addProduct(ProductVO pvo) {
		return mapper.insertProduct(pvo) == 1;
	}

	@Override
	public boolean removeProduct(String prodCode) {
		return mapper.deleteProduct(prodCode) == 1;
	}

	@Override
	public boolean modifyProduct(ProductVO pvo) {
		return mapper.updateProduct(pvo) == 1;
	}

	@Override
	public ProductVO getProduct(String prodCode) {
		return mapper.selectProduct(prodCode);
	}
}
