package com.hellofresh.challenge.commons;

import java.util.Date;

public class User {
	public String timestamp;
	public boolean male;
	public String email;
	public String passwd;
	public String name;
	public String surname;
	public String company;
	public String adress1;
	public String adress2;
	public String city;
	public int birth_day;
	public String state;
	public int birth_month;
	public int birth_year;
	public String zip;
	public String other;
	public String phone;
	public String phone_mobile;
	public String alias;

	public static User getExistingUser() {
		String existingUserEmail = "hf_challenge_123456@hf12345.com";
		String existingUserPassword = "12345678";
		String firstname = "Joe";
		String lastname = "Black";

		return new User(existingUserEmail, existingUserPassword, firstname, lastname);
	}

	public static User generateUnique() {
		User temp = new User();
		temp.timestamp = String.valueOf(new Date().getTime());
		temp.email = "hf_challenge_" + temp.timestamp + "@hf" + temp.timestamp.substring(7) + ".com";
		temp.name = "Firstname";
		temp.passwd = "zakila";
		temp.surname = "Lastname";
		temp.company = "Company";
		temp.adress1 = "Qwerty, 123";
		temp.male = Math.random() < 0.5;
		temp.adress2 = "zxcvb";
		temp.city = "Qwerty";
		temp.state = "Colorado";
		temp.birth_day = 1;
		temp.birth_month = 1;
		temp.birth_year = 2000;
		temp.zip = "12345";
		temp.other = "Qwerty";
		temp.phone = "12345123123";
		temp.phone_mobile = "12345123123";
		temp.alias = "hf";
		return temp;
	}

	public String getFullName() {
		return this.name + " " + this.surname;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String mail, String pass) {
		this.email = mail;
		this.passwd = pass;
	}

	public User(String mail, String pass, String name, String surname) {
		this(mail, pass);
		this.name = name;
		this.surname = surname;
	}
}
