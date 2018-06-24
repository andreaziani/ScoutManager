package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.ResponsabileParrocchia;

public class QueryParrocchia {
	
	private static String codiceParrocchia;
	private static String codiceLC;
	private static String codiceEG;
	private static String codiceRS;
	private static String codiceCC;
	
	public static String calculateCodiceParrocchia(DBConnection con, ResponsabileParrocchia resp) {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceParrocchia from Responsabilità_parrocchia where codiceResponsabile = ?");
			st.setString(1, resp.getCodiceResponsabile());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceParrocchia = rs.getString(1);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceParrocchia;
	}
	
	public static String calculateCodiceLC(DBConnection con) {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceLC from Contiene_LC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceLC = rs.getString(1);
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceLC;
	}
	
	public static String calculateCodiceEG(DBConnection con) {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEG from Contiene_EG where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEG = rs.getString(1);
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceEG;
	}
	
	public static String calculateCodiceRS(DBConnection con) {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceRS from Contiene_RS where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceRS = rs.getString(1);
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceRS;
	}
	
	public static String calculateCodiceCC(DBConnection con) {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceCC from Contiene_CC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceCC = rs.getString(1);
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceCC;
	}
	
	public static int calculateYear(DBConnection con, String codiceIscritto) {
		int anno = 2030;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select year(dataNascita) from Iscritto where codiceIscritto = ?");
			st.setString(1, codiceIscritto);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				anno = Integer.parseInt(rs.getString(1));
				
			}
			st.close();
		} catch (SQLException e) {
			return anno;
		}
		return anno;
	}

}
