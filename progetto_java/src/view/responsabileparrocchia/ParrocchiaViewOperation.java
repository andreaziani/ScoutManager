package view.responsabileparrocchia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.DBConnection;
import model.DBConnectionImpl;

public class ParrocchiaViewOperation {
	static DBConnection con = new DBConnectionImpl();
	
	static public String eventoDiParrocchiaPerData(String data) {
		String row = "Parrocchia \t tipo \t località \t descrizione \t dataFine \t Codice evento\n";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date parsed = sdf.parse(data);
			Date datesql = new java.sql.Date(parsed.getTime());
			PreparedStatement st = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceParrocchia, tipo, località, descrizione, dataFine, codiceEvento FROM E_P_TUTTI WHERE dataInizio = ?");
			st.setDate(1, datesql);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st.close();
			PreparedStatement st2 = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceParrocchia, tipo, località, descrizione, dataFine, codiceEvento FROM E_P_RS WHERE dataInizio = ?");
			st2.setDate(1, datesql);
			rs = st2.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st2.close();

			PreparedStatement st3 = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceParrocchia, tipo, località, descrizione, dataFine, codiceEvento FROM E_P_EG WHERE dataInizio = ?");
			st3.setDate(1, datesql);
			rs = st3.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					row += rs.getString(i) + "\t";
				}
				row += "\n";
			}
			st3.close();

			PreparedStatement st4 = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceParrocchia, tipo, località, descrizione, dataFine, codiceEvento FROM E_P_LC WHERE dataInizio = ?");
			st4.setDate(1, datesql);
			rs = st4.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
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
	
	static public String iscrittiEvento(String codiceEvento, String codiceParrocchia) {
		String iscritto = "Codice iscritto \n";
		try {
			PreparedStatement st = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceIscritto FROM REGISTRAZIONE_E_P_TUTTI where codiceEvento = ? and codiceParrocchia = ?");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					iscritto += rs.getString(i) + "\t";
				}
				iscritto += "\n";
			}
			st.close();
			PreparedStatement st2 = con.getMsSQLConnection()
					.prepareStatement("select codiceIscritto from REGISTRAZIONE_E_P_RS where codiceEvento = ? and codiceParrocchia = ?");
			st2.setString(1, codiceEvento);
			st2.setString(2, codiceParrocchia);
			rs = st2.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					
					iscritto += rs.getString(i) + "\t";
					
				}
				iscritto += "\n";
			}
			st2.close();
			PreparedStatement st3 = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceIscritto FROM REGISTRAZIONE_E_P_EG where codiceEvento = ? and codiceParrocchia = ?");
			st3.setString(1, codiceEvento);
			st3.setString(2, codiceParrocchia);
			rs = st3.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					iscritto += rs.getString(i) + "\t";
				}
				iscritto += "\n";
			}
			st3.close();
			PreparedStatement st4 = con.getMsSQLConnection()
					.prepareStatement("SELECT codiceIscritto FROM REGISTRAZIONE_E_P_LC where codiceEvento = ? and codiceParrocchia = ?");
			st4.setString(1, codiceEvento);
			st4.setString(2, codiceParrocchia);
			rs = st4.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					iscritto += rs.getString(i) + "\t";
				}
				iscritto += "\n";
			}
			st4.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return iscritto;
	}
	
	static public String iscrittiBranca(String branca, String codiceParrocchia, int anno) {
		String iscritto = "Codice iscritto \n";
		ResultSetMetaData rsMetaData;
		ResultSet rs;
		if(branca.equals("CC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection()
						.prepareStatement("select codiceIscritto" + 
								" from CC_ANNO, Contiene_CC" + 
								" where Contiene_CC.codiceCC = CC_ANNO.codiceCC" + 
								" and Contiene_CC.codiceParrocchia = ?" + 
								" and anno = ?");
				st.setString(1, codiceParrocchia);
				st.setInt(2, anno);
				rs = st.executeQuery();
				rsMetaData = rs.getMetaData();
				while (rs.next()) {
					for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
						iscritto += rs.getString(i) + "\t";
					}
					iscritto += "\n";
				}
				st.close();
			}
			catch (SQLException e1) {
				return " ";
			}
		}
		else if(branca.equals("RS")) {
			try {
			PreparedStatement st2 = con.getMsSQLConnection()
					.prepareStatement("select codiceIscritto" + 
							" from RS_ANNO, Contiene_RS" + 
							" where Contiene_RS.codiceRS = RS_ANNO.codiceRS" + 
							" and Contiene_RS.codiceParrocchia = ?" + 
							" and anno = ?");
			st2.setString(1, codiceParrocchia);
			st2.setInt(2, anno);
			rs = st2.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					iscritto += rs.getString(i) + "\t";
				}
				iscritto += "\n";
			}
			st2.close();
		}
		catch (SQLException e1) {
			return " ";
		}
	}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st3 = con.getMsSQLConnection()
						.prepareStatement("select codiceIscritto" + 
								" from EG_ANNO, Contiene_EG" + 
								" where Contiene_EG.codiceEG = EG_ANNO.codiceEG" + 
								" and Contiene_EG.codiceParrocchia = ?" + 
								" and anno = ?");
				st3.setString(1, codiceParrocchia);
				st3.setInt(2, anno);
				rs = st3.executeQuery();
				rsMetaData = rs.getMetaData();
				while (rs.next()) {
					for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
						iscritto += rs.getString(i) + "\t";
					}
					iscritto += "\n";
				}
				st3.close();
			}
			catch (SQLException e1) {
				return " ";
			}
		}

		else if(branca.equals("LC")) {
			try {
			PreparedStatement st4 = con.getMsSQLConnection()
					.prepareStatement("select codiceIscritto" + 
							" from LC_ANNO, Contiene_LC" + 
							" where Contiene_LC.codiceLC = LC_ANNO.codiceLC" + 
							" and Contiene_LC.codiceParrocchia = ?" + 
							" and anno = ?");
			st4.setString(1, codiceParrocchia);
			st4.setInt(2, anno);
			rs = st4.executeQuery();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					iscritto += rs.getString(i) + "\t";
				}
				iscritto += "\n";
			}
			st4.close();
		} catch (SQLException e1) {
			return " ";
		}
	}
		return iscritto;
	}
}
