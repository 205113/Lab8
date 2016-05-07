package it.polito.tdp.grafoTrasporti;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
	private String url;

	public Connessione(String url) {
		this.url = url;
	}
	
	public Connection connetti(){
		try {
			Connection cn=DriverManager.getConnection(this.url);
			return cn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}