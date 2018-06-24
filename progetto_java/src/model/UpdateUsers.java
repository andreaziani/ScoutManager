package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UpdateUsers {
	public static List<String> updateIscritti(DBConnection con, int anno) {
		Set<String> iscritti = new HashSet<>();
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"select I.codiceIscritto from ISCRITTO I JOIN EG_ANNO E ON (E.codiceIscritto = I.codiceIscritto) where E.anno = ?");
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				iscritti.add(rs.getString(1));
			}
			st.close();
			PreparedStatement st2 = con.getMsSQLConnection().prepareStatement(
					"select I.codiceIscritto from ISCRITTO I JOIN RS_ANNO E ON (E.codiceIscritto = I.codiceIscritto) where E.anno = ?");
			st2.setInt(1, anno);
			rs = st2.executeQuery();
			while (rs.next()) {
				iscritti.add(rs.getString(1));
			}
			st2.close();
		} catch (SQLException e) {
			iscritti.add("<Nessun iscritto memorizzato>");
		}
		return iscritti.stream().collect(Collectors.toList());
	}
	
	public static int getYearFromEvent(DBConnection con, String codEvento) {
		int anno = 0;
		PreparedStatement st;
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"select year(dataInizio) from E_NAZIONALE where codiceEvento = ?");
			st.setString(1, codEvento);;
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				anno = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			return anno;
		}
		return anno;
	}
}
