package cn.hnust.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户实体类
 * @author 龙伟
 * 2018年9月18日
 */
@Entity
@Table(name="sys_user")
public class SysUser implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="user_id")
	@GenericGenerator(name="uuid",strategy="uuid")//自定义主键生成策略,.strategy:String 指定生成策略
	@GeneratedValue(generator="uuid")//要与自定义的name一致
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_state")
	private Integer userState;
	
	//多对多关系映射：一个用户可以演多个角色
	@ManyToMany(mappedBy="users",cascade=CascadeType.ALL)//不维护关联关系，添加级联操作
	private Set<SysRole> roles = new HashSet<SysRole>(0);
	
	public Set<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserState() {
		return userState;
	}
	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userState=" + userState + "]";
	}
	
	
	
}
