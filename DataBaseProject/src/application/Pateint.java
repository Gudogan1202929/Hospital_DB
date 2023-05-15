package application;

import java.util.Date;

public class Pateint {

	private int pateint;
	private String pateint_Name;
	private String gender;
	private String phoneNum;
	private String dateOfBirth;
	private String insurance;
	private String name_building;
	private String city;
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Pateint(int pateint, String pateint_Name, String gender, String phoneNum, String dateOfBirth,
			String insurance, String name_building, String city, String name_city) {
		super();
		this.pateint = pateint;
		this.pateint_Name = pateint_Name;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.insurance = insurance;
		this.name_building = name_building;
		this.city = city;
	}

	public String getName_building() {
		return name_building;
	}

	public void setName_building(String name_building) {
		this.name_building = name_building;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Pateint(String pateint_Name, String gender, String phoneNum, String dateOfBirth, String insurance,
			String name_building, String city, String cityName) {
		super();
		this.pateint_Name = pateint_Name;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.insurance = insurance;
		this.name_building = name_building;
		this.city = city;
		this.cityName = cityName;

	}

	public Pateint(int pateint, String pateint_Name, String gender, String phoneNum, String dateOfBirth,
			String insurance, String name_building, String city) {
		super();
		this.pateint = pateint;
		this.pateint_Name = pateint_Name;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.insurance = insurance;
		this.name_building = name_building;
		this.city = city;
	}

	public int getPateint() {
		return pateint;
	}

	public void setPateint(int pateint) {
		this.pateint = pateint;
	}

	public String getPateint_Name() {
		return pateint_Name;
	}

	public void setPateint_Name(String pateint_Name) {
		this.pateint_Name = pateint_Name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String real) {
		this.phoneNum = real;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Pateint [pateint=" + pateint + ", pateint_Name=" + pateint_Name + ", gender=" + gender + ", real="
				+ phoneNum + ", dateOfBirth=" + dateOfBirth + ", insurance=" + insurance + "]";
	}

}
