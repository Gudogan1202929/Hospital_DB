package application;

import java.sql.Connection;

public class DataBaseConnection {

	private String dbUsername = "root"; // mysql user name
	private DBConn connection;
	private String dbPassword = "root1234"; // mysql password
	private String URL = "127.0.0.1"; // location of db server
	private String port = "3306"; // constant
	private String dbName = "projectHospital"; // most likely will not change

	public DataBaseConnection(String dbUsername, String dbPassword, String URL, String port, String dbName) {
		this.connection = new DBConn(URL, port, dbName, dbUsername, dbPassword);
	}

	public DataBaseConnection() {
		dbUsername = "root";
		dbPassword = "root2002";
		URL = "127.0.0.1";
		port = "3306";
		dbName = "HospitalDataBase";
		this.connection = new DBConn(URL, port, dbName, dbUsername, dbPassword);
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public DBConn getCon() {
		return connection;
	}

	public DBConn getConnection() {
		return connection;
	}
}
