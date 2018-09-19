package cn.hnust.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import cn.hnust.domain.SysRole;
import cn.hnust.domain.SysUser;
import cn.hnust.util.JPAUtil;

/**
 * JPA多对多测试
 * @author 龙伟
 * 2018年9月18日
 */
public class JPADemo1 {

	/*
	 * 保存操作(级联双向保存)
	 * 用户1具备角色1和角色2
	 * 用户2具备角色2和角色3
	 */
	@Test
	public void test1() {
		//创建用户与角色
		SysUser user1 = new SysUser();
		user1.setUserName("user1");
		SysUser user2 = new SysUser();
		user2.setUserName("user2");
		SysRole role1 = new SysRole();
		role1.setRoleName("role1");
		SysRole role2 = new SysRole();
		role2.setRoleName("role2");
		SysRole role3 = new SysRole();
		role3.setRoleName("role3");
		//用户1具备角色1和角色2(角色12也具备用户1)
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		//用户2具备角色2和角色3(角色34也具备用户2)
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		//保存（级联保存）
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//执行这一句便可以保存上面所有的信息
		em.persist(user1);
		tx.commit();
		em.close();
	}
	/*
	 * 删除操作
	 * 	双向级联删除，不管是hibernate还是JPA，多对多中都不配置
	 */
	@Test
	public void test2() {
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//查询用户
		SysUser user1 = em.find(SysUser.class,"062118e665ecb2410165ecb243830000");
		em.remove(user1);
		tx.commit();
		em.close();
	}
}
