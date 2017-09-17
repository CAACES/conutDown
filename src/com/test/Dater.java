package com.test;

import java.util.Date;

public class Dater {

	private int year;
	private int month;
	private int day;
	private int hours;
	private int minutes;
	private int seconds;
	
	public Dater(int year,int month,int day,int hours ,int minutes ,int seconds) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		
	}
	public Dater() {
		//Data
	}
	public Dater(Date date) {
		this.year = date.getYear()+1900;
		this.month = date.getMonth()+1;
		this.day = date.getDate();
		this.hours = date.getHours();
		this.minutes = date.getMinutes();
		this.seconds = date.getSeconds();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
}
