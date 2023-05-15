package application;

import java.util.Date;

public class Diagnosis {

	private int diagnosis_ID;
	private String treatment_discription;
	private String diagnosis_description;
	private String dateOfBirth;
	private int pateint_ID;
	private String pateint_name;
	private int cost;
	private int doctor_ID;

	public Diagnosis(int diagnosis_ID, String pateint_name, String treatment_discription, String diagnosis_description,
			String dateOfBirth, int pateint_ID, int doctor_ID,int cost) {
		super();
		this.diagnosis_ID = diagnosis_ID;
		this.treatment_discription = treatment_discription;
		this.diagnosis_description = diagnosis_description;
		this.dateOfBirth = dateOfBirth;
		this.pateint_ID = pateint_ID;
		this.pateint_name = pateint_name;
		this.doctor_ID = doctor_ID;
		this.cost=cost;
	}
	public Diagnosis(int diagnosis_ID, int pateint_ID, String pateint_name, String diagnosis_description,String treatment_discription, int doctor_ID,String dateOfBirth) {
		super();
		this.diagnosis_ID = diagnosis_ID;
		this.treatment_discription = treatment_discription;
		this.diagnosis_description = diagnosis_description;
		this.dateOfBirth = dateOfBirth;
		this.pateint_ID = pateint_ID;
		this.pateint_name = pateint_name;
		this.doctor_ID = doctor_ID;
	}
	public Diagnosis( String pateint_name, String treatment_discription, String diagnosis_description,
			String dateOfBirth, int pateint_ID, int doctor_ID) {
		super();
		this.treatment_discription = treatment_discription;
		this.diagnosis_description = diagnosis_description;
		this.dateOfBirth = dateOfBirth;
		this.pateint_ID = pateint_ID;
		this.pateint_name = pateint_name;
		this.doctor_ID = doctor_ID;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPateint_ID() {
		return pateint_ID;
	}

	public void setPateint_ID(int pateint_ID) {
		this.pateint_ID = pateint_ID;
	}

	public String getPateint_name() {
		return pateint_name;
	}

	public void setPateint_name(String pateint_name) {
		this.pateint_name = pateint_name;
	}

	public int getDiagnosis_ID() {
		return diagnosis_ID;
	}

	public void setDiagnosis_ID(int diagnosis_ID) {
		this.diagnosis_ID = diagnosis_ID;
	}

	public String getTreatment_discription() {
		return treatment_discription;
	}

	public void setTreatment_discription(String treatment_discription) {
		this.treatment_discription = treatment_discription;
	}

	public String getDiagnosis_description() {
		return diagnosis_description;
	}

	public void setDiagnosis_description(String diagnosis_description) {
		this.diagnosis_description = diagnosis_description;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getPateintpateint() {
		return pateint_ID;
	}

	public void setPateintpateint(int pateintpateint) {
		this.pateint_ID = pateintpateint;
	}

	public int getDoctor_ID() {
		return doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		this.doctor_ID = doctor_ID;
	}
	@Override
	public String toString() {
		return "Diagnosis [diagnosis_ID=" + diagnosis_ID + ", treatment_discription=" + treatment_discription
				+ ", diagnosis_description=" + diagnosis_description + ", dateOfBirth=" + dateOfBirth + ", pateint_ID="
				+ pateint_ID + ", pateint_name=" + pateint_name + ", cost=" + cost + ", doctor_ID=" + doctor_ID + "]";
	}

	
}
