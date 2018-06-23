package view.responsabileparrocchia;

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
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_RS where codiceEvento = ? and codiceParrocchia = ?");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			rs += st.executeUpdate();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_EG where codiceEvento = ? and codiceParrocchia = ?");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			rs += st.executeUpdate();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_LC where codiceEvento = ? and codiceParrocchia = ?");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			rs += st.executeUpdate();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}
}
