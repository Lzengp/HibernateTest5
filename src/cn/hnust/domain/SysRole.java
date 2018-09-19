package cn.hnust.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色实体类
 * @author 龙伟
 * 2018年9月18日
 */
@Entity
@Table(name="sys_role")
public class SysRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="role_id")
	@GenericGenerator(name="uuid",strategy="uuid")//自定义主键生成策略
	@GeneratedValue(generator="uuid")
	private String roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_password")
	private String rolePassword;
	
	@Column(name="role_mome")
	private String roleMome;
	
	//多对多关系映射：一个角色可以让多个用户演
	@ManyToMany(cascade=CascadeType.ALL)
	//加入一张中间表
	@JoinTable(name="user_role_ref",
			   joinColumns= {@JoinColumn(name="role_id",referencedColumnName="role_id")},//写的是当前实体在中间表的外键字段
			   inverseJoinColumns= {@JoinColumn(name="user_id",referencedColumnName="user_id")}//写的是对方实体在中间表的外键字段
	
			)
	private Set<SysUser> users = new HashSet<SysUser>(0);
	
	public Set<SysUser> getUsers() {
		return users;
	}
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRolePassword() {
		return rolePassword;
	}
	public void setRolePassword(String rolePassword) {
		this.rolePassword = rolePassword;
	}
	public String getRoleMome() {
		return roleMome;
	}
	public void setRoleMome(String roleMome) {
		this.roleMome = roleMome;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", rolePassword=" + rolePassword + ", roleMome="
				+ roleMome + "]";
	}
	
	
	
}
