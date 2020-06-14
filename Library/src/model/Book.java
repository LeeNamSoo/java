package model;

import java.sql.Date;

public class Book {

	private int code;// 도서관리 번호
	private String title;// 도서 제목
	private String author;// 도서 저자
	private String img;

	private String publisher;// 출판사
	private String location;// 도서위치
	private Date rentaled_date;
	private Date returned_date;

	public Book() {
	}

	public Book(int code, String title, String author, String img, String publisher, String location,
			Date rentaled_date, Date returned_date) {
		super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.img = img;
		this.publisher = publisher;
		this.location = location;
		this.rentaled_date = rentaled_date;
		this.returned_date = returned_date;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getRentaled_date() {
		return rentaled_date;
	}

	public void setRentaled_date(Date rentaled_date) {
		this.rentaled_date = rentaled_date;
	}

	public Date getReturned_date() {
		return returned_date;
	}

	public void setReturned_date(Date returned_date) {
		this.returned_date = returned_date;
	}

	public int getcode() {
		return code;
	}

	public void setcode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String toString() {
		return "Book{ [code : " + this.code + "] [title : " + this.title + "] [author : " + this.author + "]}";
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
