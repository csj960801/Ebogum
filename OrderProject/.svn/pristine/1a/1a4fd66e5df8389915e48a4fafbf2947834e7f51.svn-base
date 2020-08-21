package com.project.Session;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.dao.ApprovalDao;

public class SqlSessionInstance {
	private static Logger instancelog = LoggerFactory.getLogger(ApprovalDao.class);

	private static String mybatisPath = "mybatis_config/mybatis_config.xml";
	private static InputStream stream;
	private static SqlSessionFactory factory;

	/**
	 * SqlSession싱글톤(없애고 효율적인 방법 고안중)
	 * 
	 * @return
	 */
	public static SqlSessionFactory getInstanceSession() {
		try {
			stream = Resources.getResourceAsStream(mybatisPath);
			factory = new SqlSessionFactoryBuilder().build(stream);

		} catch (Exception e) {
			instancelog.info("=====================================");
			instancelog.info("session인스턴스 동작실패: " + e.toString());
			instancelog.info("=====================================");
		}
		return (factory != null) ? factory : null;
	}// end of getInsanceSession()

}
