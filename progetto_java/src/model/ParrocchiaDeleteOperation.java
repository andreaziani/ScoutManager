package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class ParrocchiaDeleteOperation {
	
	public static int cancellaEvento(DBConnection con, String codiceEvento, String codiceParrocchia) {
		int rs = 0;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_TUTTI where codiceEvento = ? and codiceParrocchia = ?");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			rs += st.executeUpdate();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("delete from E_P_RS where codiceEvento = ? and codiceParrocchia = ?");
			st2.setString(1, codiceEvento);
			st2.setString(2, codiceParrocchia);
			rs += st2.executeUpdate();
			st2.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("delete from E_P_EG where codiceEvento = ? and codiceParrocchia = ?");
			st3.setString(1, codiceEvento);
			st3.setString(2, codiceParrocchia);
			rs += st3.executeUpdate();
			st3.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st4 = con.getMsSQLConnection().prepareStatement("delete from E_P_LC where codiceEvento = ? and codiceParrocchia = ?");
			st4.setString(1, codiceEvento);
			st4.setString(2, codiceParrocchia);
			rs += st4.executeUpdate();
			st4.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}
}
