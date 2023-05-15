package application;

public class Employees {

	private int employees_ID;
	private String name_employee;
	private String gender;
	private String phoneNum;
	private String dateOfBirth;
	private double salary;
	private String role;
	private String name_bulding;
	private String city;

	public Employees(int employees_ID, String name_employee, String gender, String phoneNum, String dateOfBirth,
			double salary, String name_bulding, String city) {
		super();
		this.employees_ID = employees_ID;
		this.name_employee = name_employee;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.name_bulding = name_bulding;
		this.city = city;
	}

	public Employees(int employees_ID, String name_employee, String gender, String phoneNum, String dateOfBirth,
			double salary, String role, String name_bulding, String city) {
		super();
		this.employees_ID = employees_ID;
		this.name_employee = name_employee;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.role = role;
		this.name_bulding = name_bulding;
		this.city = city;
	}

	public Employees(String name_employee, String gender, String phoneNum, String dateOfBirth, double salary,
			String role, String name_bulding, String city) {
		super();
		this.name_employee = name_employee;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.role = role;
		this.name_bulding = name_bulding;
		this.city = city;
	}

	public int getEmployees_ID() {
		return employees_ID;
	}

	public void setEmployees_ID(int employees_ID) {
		this.employees_ID = employees_ID;
	}

	public String getName_employee() {
		return name_employee;
	}

	public void setName_employee(String name_employee) {
		this.name_employee = name_employee;
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

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName_bulding() {
		return name_bulding;
	}

	public void setName_bulding(String name_bulding) {
		this.name_bulding = name_bulding;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employees [employees_ID=" + employees_ID + ", name_employee=" + name_employee + ", gender=" + gender
				+ ", phoneNum=" + phoneNum + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + ", role=" + role
				+ ", name_bulding=" + name_bulding + ", city=" + city + "]";
	}

}
