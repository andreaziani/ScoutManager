package view.responsabileparrocchia;

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
	
	private static List<String> anno = new ArrayList<>(Arrays.asList("2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"));
	private static List<String> branca = new ArrayList<>(Arrays.asList("LC", "EG", "RS", "CC"));
	private static List<String> tipoEvento = new ArrayList<>(Arrays.asList("LC", "EG", "RS", "Tutti"));
	private static List<String> eventoLudica = new ArrayList<>(Arrays.asList("LC", "EG", "Tutti"));
	private static List<String> eventoFormativa = new ArrayList<>(Arrays.asList("EG", "RS"));
	private static List<String> iscrittoBranca = new ArrayList<>();
	private static List<String> attivitàFormativa = new ArrayList<>();
	private static List<String> attivitàLudica = new ArrayList<>();
	private static List<String> codiceEventoRegistrazione = new ArrayList<>();
	private static List<String> codiceIscrittoRegistrazione = new ArrayList<>();
	private static List<String> codiceEventoAttL = new ArrayList<>();
	private static List<String> codiceEventoAttF = new ArrayList<>();
	private static List<String> nomeCompetenza = new ArrayList<>();
	private static List<String> areaCompetenza = new ArrayList<>();
	private static List<String> codiceEvento = new ArrayList<>();
	private static Set<String> codiceIscritto = new HashSet<>();
	
	public static List<String> anno(){
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
		codiceIscritto.removeAll(codiceIscritto);
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
		iscrittoBranca.removeAll(iscrittoBranca);
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from EG_ANNO, Contiene_EG " + 
						"where codiceParrocchia = ? " + 
						"and EG_ANNO.codiceEG = Contiene_EG.codiceEG");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from RS_ANNO, Contiene_RS " + 
						"where codiceParrocchia = ? " + 
						"and RS_ANNO.codiceRS = Contiene_RS.codiceRS");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					iscrittoBranca.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		return iscrittoBranca;
	}
	
	public static List<String> attivitàFormativa(DBConnection con) {
		attivitàFormativa.removeAll(attivitàFormativa);
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_FORMATIVA");
			while (rs.next()) {
				attivitàFormativa.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attivitàFormativa;
	}
	public static List<String> attivitàLudica(DBConnection con){
		attivitàLudica.removeAll(attivitàLudica);
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_LUDICA");
			while (rs.next()) {
				attivitàLudica.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attivitàLudica;
	}
	
	public static List<String> codiceEventoRegistrazione(DBConnection con, String branca, String codiceParrocchia){
		codiceEventoRegistrazione.removeAll(codiceEventoRegistrazione);
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoRegistrazione;
	}
	
	public static List<String> codiceIscrittoRegistrazione(DBConnection con, String branca, String codiceParrocchia){
		codiceIscrittoRegistrazione.removeAll(codiceIscrittoRegistrazione);
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from LC_ANNO, Contiene_LC " + 
						"where codiceParrocchia = ? " + 
						"and LC_ANNO.codiceLC = Contiene_LC.codiceLC");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from EG_ANNO, Contiene_EG " + 
						"where codiceParrocchia = ? " + 
						"and EG_ANNO.codiceEG = Contiene_EG.codiceEG");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto" + 
						" from RS_ANNO, Contiene_RS " + 
						"where codiceParrocchia = ? " + 
						"and RS_ANNO.codiceRS = Contiene_RS.codiceRS");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto " + 
						"from LC_ANNO, Contiene_LC " + 
						"where LC_ANNO.codiceLC = Contiene_LC.codiceLC " + 
						"and Contiene_LC.codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto " + 
						"from EG_ANNO, Contiene_EG " + 
						"where EG_ANNO.codiceEG = Contiene_EG.codiceEG " + 
						"and Contiene_EG.codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceIscritto " + 
						"from RS_ANNO, Contiene_RS " + 
						"where RS_ANNO.codiceRS = Contiene_RS.codiceRS " + 
						"and Contiene_RS.codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceIscrittoRegistrazione.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceIscrittoRegistrazione;
	}
	
	public static List<String> eventoAttivitàLudica(DBConnection con, String branca, String codiceParrocchia) {
		codiceEventoAttL.removeAll(codiceEventoAttL);
		if(branca.equals("LC")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("Tutti")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttL.add(rs.getString(1));		
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoAttL;
	}
	
	public static List<String> eventoAttivitàFormativa(DBConnection con, String branca, String codiceParrocchia) {
		codiceEventoAttF.removeAll(codiceEventoAttF);
		if(branca.equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttF.add(rs.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(branca.equals("RS")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					codiceEventoAttF.add(rs.getString(1));		
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return codiceEventoAttF;
	}
	
	public static List<String> nomeCompetenza(DBConnection con){
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select nomeCompetenza from COMPETENZE");
			while (rs.next()) {
				nomeCompetenza.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeCompetenza;
	}
	
	public static List<String> areaCompetenza(DBConnection con, String nomeComp){
		areaCompetenza.removeAll(areaCompetenza);
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select areaCompetenza from COMPETENZE where nomeCompetenza = ?");
			st.setString(1, nomeComp);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				areaCompetenza.add(rs.getString(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return areaCompetenza;
	}
	
	public static List<String> codiceEvento(DBConnection con, String codiceParrocchia){
		codiceEvento.removeAll(codiceEvento);
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceEvento.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return codiceEvento;
	}
}
