package it.polito.tdp.grafoTrasporti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelTrasportiDAO {
	public List<Fermata> fermate() {
		// Restituisce tutte le fermate
		List<Fermata> fermate= new ArrayList<Fermata>();
		Connessione c= new Connessione("jdbc:mysql://localhost/metroparis?user=root");
		Connection conn= c.connetti();
		String sql="";
		try {
				sql="SELECT * FROM fermata";
				PreparedStatement s= conn.prepareStatement(sql);
				ResultSet rs= s.executeQuery();
				while(rs.next()){
					Fermata f=new Fermata(rs.getInt("id_fermata"),rs.getString("nome"),rs.getDouble("coordx"),rs.getDouble("coordy"));
					fermate.add(f);
				}
				
			conn.close();
			rs.close();
			return fermate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
		
		}
	
	public List<Linea> linee() {
		// Restituisce tutte le linee
		List<Linea> linee= new ArrayList<Linea>();
		Connessione c= new Connessione("jdbc:mysql://localhost/metroparis?user=root");
		Connection conn= c.connetti();
		String sql="";
		try {
				sql="SELECT * FROM linea";
				PreparedStatement s= conn.prepareStatement(sql);
				ResultSet rs= s.executeQuery();
				while(rs.next()){
					Linea l=new Linea(rs.getInt("id_linea"),rs.getString("nome"),rs.getDouble("velocita"),rs.getDouble("intervallo"),rs.getString("colore"));
					linee.add(l);
				}
				
			conn.close();
			rs.close();
			return linee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
		}
	
	public boolean collegate(Fermata f1,Fermata f2,Linea l) {
		// Controlla se f1 e f2 collegate da qualche linea
		Connessione c= new Connessione("jdbc:mysql://localhost/metroparis?user=root");
		Connection conn= c.connetti();
		String sql="";
		boolean collegate=false;
		try {
				sql="SELECT * FROM connessione WHERE id_linea= ? AND id_stazP= ? AND id_stazA= ?";
				PreparedStatement s= conn.prepareStatement(sql);
				s.setInt(1, l.getId());
				s.setInt(2, f1.getId());
				s.setInt(3, f2.getId());
				ResultSet rs= s.executeQuery();
				if(rs.next()){
					collegate=true;
				}
				
			conn.close();
			rs.close();
			return collegate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collegate;
		}
}
