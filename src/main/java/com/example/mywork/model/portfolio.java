package com.example.mywork.model;

public class portfolio 
{
	/************************* Define *************************/
	public static final String TYPE_PROJECT_A = "A";//Android
	public static final String TYPE_PROJECT_I = "I";//IOS
	public static final String TYPE_PROJECT_W = "W";//Web
	
	/************************* Member *************************/
	public int seq;
	public String port_type;
	public String title;
	public String content;
	public String my_part;
	public String img;
	public String work_date;
	public String reg_date;
	
	/************************* 생성자 *************************/
	//-----------------------------------------------------------------------------
	//
	public portfolio() 
	{
		
	}
	//-----------------------------------------------------------------------------
	//
	public portfolio(String port_type, String title, String content, String my_part, String img, String work_date) 
	{
		this.port_type = port_type;
		this.title = title;
		this.content = content;
		this.my_part = my_part;
		this.img = img;
		this.work_date = work_date;
	}
	
	/************************* getter&setter *************************/
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getPort_type() {
		return port_type;
	}


	public void setPort_type(String port_type) {
		this.port_type = port_type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getMy_part() {
		return my_part;
	}


	public void setMy_part(String my_part) {
		this.my_part = my_part;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getWork_date() {
		return work_date;
	}


	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
