package model;

import java.sql.PreparedStatement;
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
	
	public int execQuery() {
	    try {
                PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                "insert into E_NAZIONALE(codiceEvento, tipo, dataInizio, dataFine, località, descrizione) VALUES(?, ?, ?, ?, ?, ?)");
                st.setString(1, codiceEvento);
                st.setString(2, tipo);
                st.setDate(3, new java.sql.Date(dataInizio.getTime()));
                st.setDate(4, new java.sql.Date(dataFine.getTime()));
                st.setString(5, località);
                st.setString(6, descrizione);
                return st.executeUpdate();
        } catch (SQLException e) {
                return 0;
        }
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
