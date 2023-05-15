package application;

public class Secretaries {

	private String name_Secretaries;
	private int employees_ID;

	public Secretaries(String name_Secretaries, int employees_ID) {
		super();
		this.name_Secretaries = name_Secretaries;
		this.employees_ID = employees_ID;
	}
	public Secretaries( int employees_ID) {
		super();
		this.employees_ID = employees_ID;
	}
	public String getName_Secretaries() {
		return name_Secretaries;
	}

	public void setName_Secretaries(String name_Secretaries) {
		this.name_Secretaries = name_Secretaries;
	}

	public int getEmployees_ID() {
		return employees_ID;
	}

	public void setEmployees_ID(int employees_ID) {
		this.employees_ID = employees_ID;
	}

	@Override
	public String toString() {
		return "Secretaries [name_Secretaries=" + name_Secretaries + ", employees_ID=" + employees_ID + "]";
	}

}
