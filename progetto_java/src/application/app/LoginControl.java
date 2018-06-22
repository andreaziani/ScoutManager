package application.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
