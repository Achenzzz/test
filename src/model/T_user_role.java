package model;

public class T_user_role {
	private int id;
	private int roleId;
	private String userName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "t_user_role [id=" + id + ", roleId=" + roleId + ", userName=" + userName + "]";
	}
	public T_user_role(int id, int roleId, String userName) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.userName = userName;
	}
	
	

}
