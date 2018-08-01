package com.vishnu;

public class patient {
	String name;
	int age;
	java.sql.Date date;
	int timeslot;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
	
	public patient(String name, int age, String date, int timeslot) {
		super();
		this.name = name;
		this.age = age;
		 this.date = java.sql.Date.valueOf(date);
		this.timeslot = timeslot;
	
	}
}
