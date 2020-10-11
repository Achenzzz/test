package model;

public class T_role_resource {
	private int id;
	private String resourceId;
	private int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "t_role_resource [id=" + id + ", resourceId=" + resourceId + ", roleId=" + roleId + "]";
	}
	public T_role_resource(int id, String resourceId, int roleId) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.roleId = roleId;
	}
	
	

}
