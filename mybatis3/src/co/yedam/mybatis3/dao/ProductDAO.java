package co.yedam.mybatis3.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.mybatis3.common.DAO;
import co.yedam.mybatis3.vo.ProductVO;

public class ProductDAO extends DAO {

	// 목록.
	public List<ProductVO> productList() {
		connect();
		String sql = "select * from tbl_product";
		List<ProductVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setCreationDate(rs.getDate("creation_date"));
				pvo.setProdCode(rs.getString("prod_code"));
				pvo.setProdDesc(rs.getString("prod_desc"));
				pvo.setProdName(rs.getString("prod_name"));
				pvo.setSellingPrice(rs.getInt("selling_price"));
				list.add(pvo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 등록.
	public int insertProduct(ProductVO pvo) {
		return 0;
	}

	// 수정.
	public int updateProduct(ProductVO pvo) {
		return 0;
	}

	// 삭제.
	public int deleteProduct(ProductVO pvo) {
		return 0;
	}

	// 단건조회.
	public ProductVO selectProduct(String prodCode) {
		return null;
	}

}
