package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EventoNazionale{

	private String codiceEvento;
	private String tipo;
	private java.util.Date dataInizio;
	private java.util.Date dataFine;
	private String località;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public EventoNazionale(String codiceEvento, String tipo, java.util.Date dataInizio, java.util.Date dataFine, String località,
			String descrizione) {
		this.codiceEvento = codiceEvento;
		this.tipo = tipo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.località = località;
		this.descrizione = descrizione;
	}
	public String iscrittiAdEvento(String codiceEvento) {
		PreparedStatement st;
		String row = "CodIscritto \t Nome \t Cognome \t dataNascita \t NumeroTelefono \n";
		try {
			st = con.getMsSQLConnection().prepareStatement(
					"select I.codiceIscritto, I.nome, I.cognome, I.dataNascita, I.numeroTelefono from REGISTRAZIONE_E_N R join ISCRITTO I on (R.codiceIscritto = I.codiceIscritto) where R.codiceEvento = ? ");
			st.setString(1, codiceEvento);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsm = st.getMetaData();
			while(rs.next()) {
				for(int i = 1; i <= rsm.getColumnCount(); i++) {
					row += rs.getString(i);
				}
				row += "\n";
			}
		} catch (SQLException e) {
			return row;
		}
		return row;
		
	}
	public int execQuery() {
	    int result;
	    try {
                PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                "insert into E_NAZIONALE(codiceEvento, tipo, dataInizio, dataFine, località, descrizione) VALUES(?, ?, ?, ?, ?, ?)");
                st.setString(1, codiceEvento);
                st.setString(2, tipo);
                st.setDate(3, new java.sql.Date(dataInizio.getTime()));
                st.setDate(4, new java.sql.Date(dataFine.getTime()));
                st.setString(5, località);
                st.setString(6, descrizione);
                result = st.executeUpdate();
                st.close();
        } catch (SQLException e) {
        		e.printStackTrace();
                return 0;
        }
	    return result;
	}
	
	public int updateQuery() {
	    int result;
            try {
                PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                "update E_NAZIONALE SET tipo = ? , dataInizio = ?, dataFine = ?, località = ?, descrizione = ? WHERE codiceEvento = ?");
                st.setString(1, tipo);
                st.setDate(2, new java.sql.Date(dataInizio.getTime()));
                st.setDate(3, new java.sql.Date(dataFine.getTime()));
                st.setString(4, località);
                st.setString(5, descrizione);
                st.setString(6, codiceEvento);
                result = st.executeUpdate();
                st.close();
        } catch (SQLException e) {
                return 0;
        }
            return result;
	}

	public String getCodiceEvento() {
		return this.codiceEvento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public java.util.Date getDataInizio() {
		return this.dataInizio;
	}

	public java.util.Date getDataFine() {
		return this.dataFine;
	}

	public String getLocalita() {
		return this.località;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDataInizio(java.util.Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(java.util.Date dataFine) {
		this.dataFine = dataFine;
	}

	public void setLocalita(String località) {
		this.località= località;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
