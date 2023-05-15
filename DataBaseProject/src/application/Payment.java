package application;

import java.util.Date;

// secretaries_ID int(10) NOT NULL, pateint_id int(10) NOT NULL, PRIMARY KEY (payment_ID));

public class Payment {

	private int payment_ID;
	private double cost;
	private String datePayment;
	private int doctor_ID;
	private int secretaries_ID;
	private int pateint_id;

	public Payment(int payment_ID, int pateint_id, int secretaries_ID, int doctor_ID, String datePayment, double cost) {
		super();
		this.payment_ID = payment_ID;
		this.cost = cost;
		this.datePayment = datePayment;
		this.doctor_ID = doctor_ID;
		this.secretaries_ID = secretaries_ID;
		this.pateint_id = pateint_id;
	}

	public Payment(int pateint_id, int secretaries_ID, int doctor_ID, String datePayment, double cost) {
		super();
		this.cost = cost;
		this.datePayment = datePayment;
		this.doctor_ID = doctor_ID;
		this.secretaries_ID = secretaries_ID;
		this.pateint_id = pateint_id;
	}

	public int getPayment_ID() {
		return payment_ID;
	}

	public void setPayment_ID(int payment_ID) {
		this.payment_ID = payment_ID;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
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

	public int getPateint_id() {
		return pateint_id;
	}

	public void setPateint_id(int pateint_id) {
		this.pateint_id = pateint_id;
	}

	@Override
	public String toString() {
		return "Payment [payment_ID=" + payment_ID + ", cost=" + cost + ", datePayment=" + datePayment + ", doctor_ID="
				+ doctor_ID + ", secretaries_ID=" + secretaries_ID + ", pateint_id=" + pateint_id + "]";
	}

}
