package cn.hnust.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 抽取hibernate的工具类
 * @author 龙伟
 * 2018年9月18日
 */
public class JPAUtil {
	//就相当于SessionFactory
	private static EntityManagerFactory managerFactory;
	
	//hibernate把可以遇见的异常都转换成运行时异常
	static {
		try {
			managerFactory = Persistence.createEntityManagerFactory("myJPAUnit");	
		}catch(ExceptionInInitializerError e){
			throw new ExceptionInInitializerError("初始化EntityManagerFactory失败，请检查配置文件！");
		}
	}
		/*
		 * 获取JPA操作数据库对象
		 */
		public static  EntityManager createEntityManager() {
			return managerFactory.createEntityManager();
		}
	
		//生成表结构
		public static void main(String[] args) {
			createEntityManager();
		}
	}
