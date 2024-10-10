package co.yedam.mybatis3.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mybatis3.common.DataSource;
import co.yedam.mybatis3.common.SearchDTO;
import co.yedam.mybatis3.mapper.TxnMapper;
import co.yedam.mybatis3.vo.ProductVO;

public class TxnServiceMybatis implements TxnService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	TxnMapper mapper = sqlSession.getMapper(TxnMapper.class);

	@Override
	public boolean inOutTransactions(Map<String, Object> map) {
		return mapper.insertTransactions(map) == 1;
	}

	@Override
	public List<ProductVO> searchProduct(SearchDTO search) {
		return mapper.searchList(search);
	}
	
	@Override
	public List<ProductVO> onhandList(SearchDTO search) {
		return mapper.onhandList(search);
	}
}
