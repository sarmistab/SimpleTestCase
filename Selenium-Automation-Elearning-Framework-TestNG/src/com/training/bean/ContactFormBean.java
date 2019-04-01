package com.training.bean;

public class ContactFormBean {
	private String userName;
	private String email;
	private String message;
	private String info;

	public ContactFormBean() {
	}

	public ContactFormBean(String userName, String email,String textmsg, String message) {
		super();
		this.userName = userName;
		this.email = email;
		this.message=message;
		this.info=info;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", =" + email + " , message=" + message +", info=" + info + "]";
	}

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		
	}

}
