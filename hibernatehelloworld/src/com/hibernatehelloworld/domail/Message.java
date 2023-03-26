package com.hibernatehelloworld.domail;

public class Message {
	private int id;
	private String text;
	
	
	public Message (String string){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
