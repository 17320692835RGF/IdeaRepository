package model;

import java.util.Map;

/**
 * 用户信息的模型类
 * @author zhouliang
 *
 */
public class Users {
	private int userID;
	private String username;
	private String password;
	private String contact;//联系方式
	private String address;//地址
	private int money;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username
				+ ", password=" + password + ", contact=" + contact
				+ ", address=" + address + ", money=" + money + "]";
	}
	public Users() {
		super();
	}
	public Users(int userID, String username, String password, String contact,
			String address) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.address = address;
	}
	public Users(Map<String, Object> map) {
		this.userID = (Integer)map.get("userID");
		this.username = (String)map.get("username");
		this.password = (String)map.get("password");
		this.contact = (String)map.get("contact");
		this.address = (String)map.get("address");
		this.money=     (Integer)map.get("money");
	}
}
