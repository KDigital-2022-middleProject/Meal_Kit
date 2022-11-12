package dto;

import java.sql.Blob;
import java.util.Date;

public class Review {
	
	private int id;
	private Date date;
	private Blob picture; 
	private String content;
	private int star;
	private int itemCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

}
