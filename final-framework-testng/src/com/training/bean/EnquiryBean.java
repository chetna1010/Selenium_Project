package com.training.bean;

public class EnquiryBean {
	
	private String name;
	private String email;
	private String subject;
	private String message;
	private String password;
	
	public EnquiryBean() {
	}
	//Inquiry Bean class to provide details for Inquiry form
	public EnquiryBean(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject= subject;
		this.message= message;
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*public void setPassword(String password) {
		this.password = password;
	}
	*/
	@Override
	public String toString() {
		return "EnquiryBean [name=" + name + ", email=" + email + ",subject=" + subject + ", message=" + message + "]";
	}

}

