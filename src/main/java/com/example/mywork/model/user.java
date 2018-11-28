package com.example.mywork.model;

public class user 
{
	/************************* Define *************************/
	
	/************************* Member *************************/
	public int seq;
	public String id;
	public String pw;
	/************************* 생성자 *************************/
	//-----------------------------------------------------------------------------
	//
	public user() 
	{
		
	}
	//-----------------------------------------------------------------------------
	//
	public user(String id, String pw) 
	{
		this.id = id;
		this.pw = pw;
	}
	/************************* getter&setter *************************/
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
