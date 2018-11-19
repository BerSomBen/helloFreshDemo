package com.hellofresh.challenge.entitys;

import java.util.Date;

/**
 * User entity
 * 
 * @author benja
 *
 */
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAdress1() {
		return adress1;
	}

	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}

	public String getAdress2() {
		return adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getBirth_month() {
		return birth_month;
	}

	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone_mobile() {
		return phone_mobile;
	}

	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * returns the one and only default user (only neccessary data is returned)
	 * 
	 * @return User Joe Black with mail hf@... and pass 123...
	 */
	public static User getExistingUser() {
		String existingUserEmail = "hf_challenge_123456@hf12345.com";
		String existingUserPassword = "12345678";
		String firstname = "Joe";
		String lastname = "Black";

		return new User(existingUserEmail, existingUserPassword, firstname, lastname);
	}

	/**
	 * generate default new user with some valid data and unique salt.
	 * 
	 * @return initialed user that should be able to register
	 */
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

	/**
	 * to be able to create an empty user, we need an empty constuctor
	 */
	public User() {
	}

	/**
	 * default user, might need some mail and password
	 * 
	 * @param mail
	 * @param pass
	 */
	public User(String mail, String pass) {
		this();
		this.email = mail;
		this.passwd = pass;
	}

	/**
	 * test user must provide mail, pass name and lastname
	 * 
	 * @param mail
	 * @param pass
	 * @param name
	 * @param surname
	 */
	public User(String mail, String pass, String name, String surname) {
		this(mail, pass);
		this.name = name;
		this.surname = surname;
	}
}
