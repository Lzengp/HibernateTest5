package cn.hnust.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;


import cn.hnust.util.JPAUtil;

/**
 * JPA中使用c3p0连接池
 * @author 龙伟
 * 2018年9月18日
 */
public class JPADemo2 {

	
	/*
	 * 验证c3p0连接池是否配置成功
	 */
	@Test
	public void test1() {
		//获取jpa中的操作对象
		EntityManager em = JPAUtil.createEntityManager();
		//得到session对象
		Session session = em.unwrap(Session.class);
		//执行session的doWork方法
		session.doWork(new Work() {
			public void execute(Connection conn) throws SQLException{
				System.out.println(conn.getClass().getName());
			}
		});
		
	}
}
