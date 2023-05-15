package application;

public class Appointments {

	private int appointments_ID;
	private int pateint_ID;

	private int doctor_ID;
	private int secretaries_ID;
	private String patient_Name;
	private String doctor_Name;
	private String secretaries_Name;
	private String dateApponitments;
	private String time;

	public Appointments(int pateint_ID, int doctor_ID, int secretaries_ID, String patient_Name, String doctor_Name,
			String secretaries_Name, String dateApponitments, String time) {
		super();
		this.pateint_ID = pateint_ID;
		this.doctor_ID = doctor_ID;
		this.secretaries_ID = secretaries_ID;
		this.patient_Name = patient_Name;
		this.doctor_Name = doctor_Name;
		this.secretaries_Name = secretaries_Name;
		this.dateApponitments = dateApponitments;
		this.time = time;
	}

	public Appointments(int appointments_ID, int pateint_ID, int doctor_ID, int secretaries_ID, String patient_Name,
			String doctor_Name, String secretaries_Name, String dateApponitments, String time) {
		super();
		this.appointments_ID = appointments_ID;
		this.pateint_ID = pateint_ID;
		this.doctor_ID = doctor_ID;
		this.secretaries_ID = secretaries_ID;
		this.patient_Name = patient_Name;
		this.doctor_Name = doctor_Name;
		this.secretaries_Name = secretaries_Name;
		this.dateApponitments = dateApponitments;
		this.time = time;
	}

	public Appointments(int appointments_ID, int pateint_ID, int doctor_ID, int secretaries_ID, String dateApponitments,
			String time) {
		super();
		this.appointments_ID = appointments_ID;
		this.pateint_ID = pateint_ID;
		this.doctor_ID = doctor_ID;
		this.secretaries_ID = secretaries_ID;

		this.dateApponitments = dateApponitments;
		this.time = time;
	}

	public int getAppointments_ID() {
		return appointments_ID;
	}

	public void setAppointments_ID(int appointments_ID) {
		this.appointments_ID = appointments_ID;
	}

	public int getPateint_ID() {
		return pateint_ID;
	}

	public void setPateint_ID(int pateint_ID) {
		this.pateint_ID = pateint_ID;
	}

	public int getDoctor_ID() {
		return doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		this.doctor_ID = doctor_ID;
	}

	public int getSecretaries_ID() {
		return secretaries_ID;
	}

	public void setSecretaries_ID(int secretaries_ID) {
		this.secretaries_ID = secretaries_ID;
	}

	public String getPatient_Name() {
		return patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}

	public String getDoctor_Name() {
		return doctor_Name;
	}

	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}

	public String getSecretaries_Name() {
		return secretaries_Name;
	}

	public void setSecretaries_Name(String secretaries_Name) {
		this.secretaries_Name = secretaries_Name;
	}

	public String getDateApponitments() {
		return dateApponitments;
	}

	public void setDateApponitments(String dateApponitments) {
		this.dateApponitments = dateApponitments;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointments [appointments_ID=" + appointments_ID + ", pateint_ID=" + pateint_ID + ", doctor_ID="
				+ doctor_ID + ", secretaries_ID=" + secretaries_ID + ", patient_Name=" + patient_Name + ", doctor_Name="
				+ doctor_Name + ", secretaries_Name=" + secretaries_Name + ", dateApponitments=" + dateApponitments
				+ ", time=" + time + "]";
	}

}
