package com.mypoc;

public class MyClient {
	

	
	public MyClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyClient(String id, String name, String phone, String address, String potalCd, String type, String balance) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.potalCd = potalCd;
		this.type = type;
		this.balance = balance;
	}
	
	private String id;
	private String name;
	private String phone;
	private String address;
	private String potalCd;
	private String type;
	private String balance;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPotalCd() {
		return potalCd;
	}
	public void setPotalCd(String potalCd) {
		this.potalCd = potalCd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

}
