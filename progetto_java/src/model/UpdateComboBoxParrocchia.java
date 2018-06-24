package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.DBConnection;

public class UpdateComboBoxParrocchia {
	
	private static String anno = "2018";
	private static List<String> branca = new ArrayList<>(Arrays.asList("LC", "EG", "RS", "CC"));
	private static List<String> tipoEvento = new ArrayList<>(Arrays.asList("LC", "EG", "RS", "Tutti"));
	private static List<String> eventoLudica = new ArrayList<>(Arrays.asList("LC", "EG", "Tutti"));
	private static List<String> eventoFormativa = new ArrayList<>(Arrays.asList("EG", "RS"));
	private static List<String> nomeCompetenza = new ArrayList<>();

	
	public static String anno(){
		return anno;
	}
	
	public static List<String> branche(){
		return branca;
	}
	
	public static List<String> tipoEventi(){
		return tipoEvento;
	}
	
	public static List<String> tipoEventiL(){
		return eventoLudica;
	}
	
	public static List<String> tipoEventiF(){
		return eventoFormativa;
	}
	
	public static List<String> codiceIscritto(DBConnection con, String branca, int anno) {
		Set<String> codiceIscritto = new HashSet<>();
		ResultSet rs;
		if(branca.equals("LC")) {
			try {
				PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceIscritto from ISCRITTO where codiceIscritto not in (select codiceIscritto from LC_ANNO "
						+ "where LC_ANNO.anno = ?)");
				st2.setInt(1, anno);
				rs = st2.executeQuery();
				while (rs.next()) {
					codiceIscritto.add(rs.getString(1));
				}
				st2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto from ISCRITTO where codiceIscritto not in (select codiceIscritto from EG_ANNO "
						+ "where EG_ANNO.anno = ?)");
				st.setInt(1, anno);
				rs = st.executeQuery();
				while (rs.next()) {
					codiceIscritto.add(rs.getString(1));
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("select codiceIscritto from ISCRITTO where codiceIscritto not in (select codiceIscritto from RS_ANNO "
						+ "where RS_ANNO.anno = ?)");
				st3.setInt(1, anno);
				rs = st3.executeQuery();
				while (rs.next()) {
					codiceIscritto.add(rs.getString(1));
				}
				st3.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(branca.equals("CC")) {
			try {
				PreparedStatement st4 = con.getMsSQLConnection().prepareStatement("select codiceIscritto from ISCRITTO where codiceIscritto not in (select codiceIscritto from CC_ANNO "
						+ "where CC_ANNO.anno = ?)");
				st4.setInt(1, anno);
				rs = st4.executeQuery();
				while (rs.next()) {
					codiceIscritto.add(rs.getString(1));
				}
				st4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codiceIscritto.stream().collect(Collectors.toList());
	}
	
	public static List<String> iscrittoBranca(DBConnection con, String codiceParrocchia){
		Set<String> iscrittoBranca = new HashSet<>();
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from LC_ANNO, Contiene_LC " + 
						"where codiceParrocchia = ? " + 
						"and LC_ANNO.codiceLC = Contiene_LC.codiceLC");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
			try {
				PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from EG_ANNO, Contiene_EG " + 
						"where codiceParrocchia = ? " + 
						"and EG_ANNO.codiceEG = Contiene_EG.codiceEG");
				st1.setString(1, codiceParrocchia);
				ResultSet rs = st1.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
				st1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				
				PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from RS_ANNO, Contiene_RS " + 
						"where codiceParrocchia = ? " + 
						"and RS_ANNO.codiceRS = Contiene_RS.codiceRS");
				st2.setString(1, codiceParrocchia);
				ResultSet rs = st2.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
				st2.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from CC_ANNO, Contiene_CC " + 
						"where codiceParrocchia = ? " + 
						"and CC_ANNO.codiceCC = Contiene_CC.codiceCC");
				st3.setString(1, codiceParrocchia);
				ResultSet rs = st3.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
				st3.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		return iscrittoBranca.stream().collect(Collectors.toList());
	}
	
	public static List<String> attivitàFormativa(DBConnection con) {
		Set<String> attivitàFormativa = new HashSet<>();
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_FORMATIVA");
			while (rs.next()) {
				attivitàFormativa.add(rs.getString(1));
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attivitàFormativa.stream().collect(Collectors.toList());
	}
	public static List<String> attivitàLudica(DBConnection con){
		Set<String> attivitàLudica = new HashSet<>();
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_LUDICA");
			while (rs.next()) {
				attivitàLudica.add(rs.getString(1));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attivitàLudica.stream().collect(Collectors.toList());
	}
	
	public static List<String> codiceEventoRegistrazione(DBConnection con, String branca, String codiceParrocchia){
		Set<String> codiceEventoRegistrazione = new HashSet<>();
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st1.setString(1, codiceParrocchia);
				ResultSet rs = st1.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
				st1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
				st2.setString(1, codiceParrocchia);
				ResultSet rs = st2.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
				st2.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
				st3.setString(1, codiceParrocchia);
				ResultSet rs = st3.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
				st3.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoRegistrazione.stream().collect(Collectors.toList());
	}
	
	public static List<String> codiceIscrittoRegistrazione(DBConnection con, String branca, String codiceEvento, String codiceParrocchia){
		Set<String> codiceIscrittoRegistrazione = new HashSet<>();
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from LC_ANNO, Contiene_LC" + 
						" where LC_ANNO.codiceLC = Contiene_LC.codiceLC" + 
						" and Contiene_LC.codiceParrocchia = ?" + 
						" and LC_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_LC, E_P_LC" +
						" where REGISTRAZIONE_E_P_LC.codiceEvento = E_P_LC.codiceEvento" +
						" and E_P_LC.codiceEvento = ?)");
				st.setString(1, codiceParrocchia);
				st.setString(2, codiceEvento);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from EG_ANNO, Contiene_EG" + 
						" where EG_ANNO.codiceEG = Contiene_EG.codiceEG" + 
						" and Contiene_EG.codiceParrocchia = ?" + 
						" and EG_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_EG, E_P_EG" +
						" where REGISTRAZIONE_E_P_EG.codiceEvento = E_P_EG.codiceEvento" +
						" and E_P_EG.codiceEvento = ?)");
				st1.setString(1, codiceParrocchia);
				st1.setString(2, codiceEvento);
				ResultSet rs = st1.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				
				PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from RS_ANNO, Contiene_RS" + 
						" where RS_ANNO.codiceRS = Contiene_RS.codiceRS" + 
						" and Contiene_RS.codiceParrocchia = ?" + 
						" and RS_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_RS, E_P_RS" +
						" where REGISTRAZIONE_E_P_RS.codiceEvento = E_P_RS.codiceEvento" +
						" and E_P_RS.codiceEvento = ?)");
				st2.setString(1, codiceParrocchia);
				st2.setString(2, codiceEvento);
				ResultSet rs = st2.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st2.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from LC_ANNO, Contiene_LC" + 
						" where LC_ANNO.codiceLC = Contiene_LC.codiceLC" + 
						" and Contiene_LC.codiceParrocchia = ?" + 
						" and LC_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_LC, E_P_LC" +
						" where REGISTRAZIONE_E_P_LC.codiceEvento = E_P_LC.codiceEvento" +
						" and E_P_LC.codiceEvento = ?)");
				st3.setString(1, codiceParrocchia);
				st3.setString(2, codiceEvento);
				ResultSet rs = st3.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st3.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st4 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from EG_ANNO, Contiene_EG" + 
						" where EG_ANNO.codiceEG = Contiene_EG.codiceEG" + 
						" and Contiene_EG.codiceParrocchia = ?" + 
						" and EG_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_EG, E_P_EG" +
						" where REGISTRAZIONE_E_P_EG.codiceEvento = E_P_EG.codiceEvento" +
						" and E_P_EG.codiceEvento = ?)");
				st4.setString(1, codiceParrocchia);
				st4.setString(2, codiceEvento);
				ResultSet rs = st4.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st4.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st5 = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from RS_ANNO, Contiene_RS" + 
						" where RS_ANNO.codiceRS = Contiene_RS.codiceRS" + 
						" and Contiene_RS.codiceParrocchia = ?" + 
						" and RS_ANNO.codiceIscritto not in (select codiceIscritto" + 
						" from REGISTRAZIONE_E_P_RS, E_P_RS" +
						" where REGISTRAZIONE_E_P_RS.codiceEvento = E_P_RS.codiceEvento" +
						" and E_P_RS.codiceEvento = ?)");
				st5.setString(1, codiceParrocchia);
				st5.setString(2, codiceEvento);
				ResultSet rs = st5.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
				st5.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceIscrittoRegistrazione.stream().collect(Collectors.toList());
	}
	
	public static List<String> eventoAttivitàLudica(DBConnection con, String branca, String codiceParrocchia) {
		Set<String> codiceEventoAttL = new HashSet<>();
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));
					
				}
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st1.setString(1, codiceParrocchia);
				ResultSet rs = st1.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));
				}
				st1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
				st2.setString(1, codiceParrocchia);
				ResultSet rs = st2.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));		
				}
				st2.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoAttL.stream().collect(Collectors.toList());
	}
	
	public static List<String> eventoAttivitàFormativa(DBConnection con, String branca, String codiceParrocchia) {
		Set<String> codiceEventoAttF = new HashSet<>();
		if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttF.add(rs.getString(1));
				}
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
				st1.setString(1, codiceParrocchia);
				ResultSet rs = st1.executeQuery();
				while (rs.next()) {
					codiceEventoAttF.add(rs.getString(1));		
				}
				st1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoAttF.stream().collect(Collectors.toList());
	}
	
	public static List<String> nomeCompetenza(DBConnection con){
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select nomeCompetenza from COMPETENZE");
			while (rs.next()) {
				nomeCompetenza.add(rs.getString(1));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeCompetenza;
	}
	
	public static List<String> areaCompetenza(DBConnection con, String nomeComp){
		Set<String> areaCompetenza = new HashSet<>();
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select areaCompetenza from COMPETENZE where nomeCompetenza = ?");
			st.setString(1, nomeComp);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				areaCompetenza.add(rs.getString(1));
			}
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return areaCompetenza.stream().collect(Collectors.toList());
	}
	
	public static List<String> codiceEvento(DBConnection con, String codiceParrocchia){
		Set<String> codiceEvento = new HashSet<>();
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st1 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
			st1.setString(1, codiceParrocchia);
			ResultSet rs = st1.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
			st1.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st2 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
			st2.setString(1, codiceParrocchia);
			ResultSet rs = st2.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
			st2.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st3 = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
			st3.setString(1, codiceParrocchia);
			ResultSet rs = st3.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
			st3.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return codiceEvento.stream().collect(Collectors.toList());
	}
}
