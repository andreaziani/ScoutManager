package application.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ResponsabileEventoNazionale;
import model.ResponsabileParrocchia;

public class LoginControl {
	static private DBConnection con = new DBConnectionImpl();
	static public boolean checkParrID(String codiceResponsabile, String password) {
		boolean res;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("SELECT * FROM RESPONSABILE_P WHERE username = ? AND password = ?");
			st.setString(1, codiceResponsabile);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			res = rs.isBeforeFirst();
			st.close();
			return res;
		} catch (SQLException e) {
			return false;
		}
	}
	
	static public boolean checkNazID(String codiceResponsabile, String password) {
		boolean res;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("SELECT * FROM RESPONSABILE_E_N WHERE username = ? AND password = ?");
			st.setString(1, codiceResponsabile);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			res = rs.isBeforeFirst();
			st.close();
			return res;
		} catch (SQLException e) {
			return false;
		}
	}
	
	static public ResponsabileEventoNazionale getResponsabileNazionale(String username) {
		ResponsabileEventoNazionale resp = null;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("SELECT * FROM RESPONSABILE_E_N WHERE username = ? ");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				resp = new ResponsabileEventoNazionale(rs.getString(1), rs.getString(2) ,rs.getString(3) ,rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7), rs.getString(8) , rs.getString(9));
			}
			st.close();
			return resp;
		} catch (SQLException e) {
			return null;
		}
	}
	
	static public ResponsabileParrocchia getResponsabileParrocchia(String username) {
		ResponsabileParrocchia resp = null;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("SELECT * FROM RESPONSABILE_P WHERE username = ? ");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				resp = new ResponsabileParrocchia(rs.getString(1), rs.getString(2) ,rs.getString(3) ,rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7), rs.getString(8) , rs.getString(9));
			}
			st.close();
			return resp;
		} catch (SQLException e) {
			return null;
		}
	}
}
