package application;

public class count {
private int counts;
private String city;
private int counts1;


public count(int counts, int counts1) {
	super();
	this.counts = counts;
	this.counts1 = counts1;
}

public int getCounts1() {
	return counts1;
}

public void setCounts1(int counts1) {
	this.counts1 = counts1;
}

public count( String city,int counts) {
	super();
	this.counts = counts;
	this.city = city;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public count(int counts) {
	super();
	this.counts = counts;
}

public int getCounts() {
	return counts;
}

public void setCounts(int counts) {
	this.counts = counts;
}

}
