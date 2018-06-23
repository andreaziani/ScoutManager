package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdminViewOperation {
	static DBConnection con = new DBConnectionImpl();

	static public String parrocchiaPerCittà(String città) {
		String row = "Codice \t Nome \t Via \t NumeroCivico \n";
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"SELECT P.*, R.città FROM PARROCCHIA P JOIN RESIDENZA R ON (P.codiceParrocchia = R.codiceParrocchia) WHERE R.città = ?");
			st.setString(1, città);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
		} catch (SQLException e1) {
			return " ";
		}
		return row;
	}

	static public String eventoParrocchiaPerResponsabile(String codiceResponsabile) {
		String row = "";
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("SELECT E.*, RP.codiceResponsabile "
					+ "FROM Responsabilità_E_P_TUTTI RP JOIN E_P_TUTTI E ON (E.codiceParrocchia = RP.codiceParrocchia) "
					+ "WHERE RP.codiceResponsabile = ? " + "");
			st.setString(1, codiceResponsabile);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
		} catch (SQLException e1) {
			return " ";
		}
		return row;
	}

	static public String eventoNazionalePerResponsabile(String codiceResponsabile) {
		String row = "";
		try {
			PreparedStatement st = con.getMsSQLConnection()
					.prepareStatement("SELECT E.*, RN.codiceResponsabile "
							+ "FROM Responsabilità_E_N RN JOIN E_NAZIONALE E ON (E.codiceEvento = RN.codiceEvento) "
							+ "WHERE RN.codiceResponsabile = ? ");
			st.setString(1, codiceResponsabile);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
		} catch (SQLException e1) {
			return " ";
		}
		return row;
	}

	static public String eventoDiParrocchiaPerData(String data) {
		String row = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date parsed = sdf.parse(data);
			Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection()
					.prepareStatement("SELECT * " + "FROM E_P_TUTTI" + "WHERE dataInizio = ? ");
			st.setDate(1, datesql);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
			PreparedStatement st2 = con.getMsSQLConnection()
					.prepareStatement("SELECT * " + "FROM E_P_LC" + "WHERE dataInizio = ? ");
			st2.setDate(1, datesql);
			rs = st2.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st2.close();

			PreparedStatement st3 = con.getMsSQLConnection()
					.prepareStatement("SELECT * " + "FROM E_P_RS" + "WHERE dataInizio = ? ");
			st3.setDate(1, datesql);
			rs = st3.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st3.close();

			PreparedStatement st4 = con.getMsSQLConnection()
					.prepareStatement("SELECT * " + "FROM E_P_EG" + "WHERE dataInizio = ? ");
			st4.setDate(1, datesql);
			rs = st4.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st4.close();
		} catch (SQLException | ParseException e1) {
			return " ";
		}
		return row;
	}

	static public String eventoNazionalePerData(String data) {
		String row = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date parsed = sdf.parse(data);
			Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection()
					.prepareStatement("SELECT * " + "FROM E_NAZIONALE" + "WHERE dataInizio = ? ");
			st.setDate(1, datesql);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
		} catch (SQLException | ParseException e1) {
			return " ";
		}
		return row;
	}
}
