package model;

public class T_user {
	private String userName;
	private String password;
	private String chrName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	@Override
	public String toString() {
		return "t_user [userName=" + userName + ", password=" + password + ", chrName=" + chrName + "]";
	}
	public T_user(String userName, String password, String chrName) {
		super();
		this.userName = userName;
		this.password = password;
		this.chrName = chrName;
	}
	
	

}
