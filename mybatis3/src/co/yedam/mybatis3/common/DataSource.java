package co.yedam.mybatis3.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {

	public static SqlSessionFactory getInstance() {
		String resource = "co/yedam/mybatis-config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sqlSessionFactory;
	}
}
