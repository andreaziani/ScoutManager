package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrazioneEventoNazionale {
	
	private String codiceEvento;
	private String codiceIscritto;
	private String codiceRegistrazione;
	private DBConnection con;
	
	public RegistrazioneEventoNazionale(String codiceEvento, String codiceIscritto, String codiceRegistrazione) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceIscritto = codiceIscritto;
		this.codiceRegistrazione = codiceRegistrazione;
		con = new DBConnectionImpl();
	}
	
	public int execQuery() {
	    int rs;
            try {
                    PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                    "insert into REGISTRAZIONE_E_N(codiceEvento, codiceRegistrazione, codiceIscritto) VALUES(?, ?, ?)");
                    st.setString(1, codiceEvento);
                    st.setString(2, codiceRegistrazione);
                    st.setString(3, codiceIscritto);
                    rs =  st.executeUpdate();
                    st.close();
            } catch (SQLException e) {
                    return 0;
            }
            return rs;
	}

	public String getCodiceEvento() {
		return codiceEvento;
	}

	public String getCodiceIscritto() {
		return codiceIscritto;
	}

	public String getCodiceRegistrazione() {
		return codiceRegistrazione;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceIscritto(String codiceIscritto) {
		this.codiceIscritto = codiceIscritto;
	}

	public void setCodiceRegistrazione(String codiceRegistrazione) {
		this.codiceRegistrazione = codiceRegistrazione;
	}	
 
}
