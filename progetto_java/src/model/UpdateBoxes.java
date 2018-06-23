package view.responsabilenazionale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;

public class UpdateBoxes {
	public static List<String> updateEventiNazionali(DBConnection con) {
		List<String> eventi = new ArrayList<>();
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_NAZIONALE");
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					eventi.add(rs.getString(1));
				}
			} else {
				eventi.add("<Nessun Codice Evento memorizzato>");
			}
			st.close();
		} catch (SQLException e) {
			eventi.add("<Nessun Codice Evento memorizzato>");
		}
		return eventi;
	}
}
