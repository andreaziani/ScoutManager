package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormazioneNazionale {
	
	private String codiceEvento;
	private String codiceAttività;
	private DBConnection con = new DBConnectionImpl();
	
	public FormazioneNazionale(String codiceEvento, String codiceAttività) {
		this.codiceEvento = codiceEvento;
		this.codiceAttività = codiceAttività;
	}
	
	public int execQuery() {
	    int rs;
            try {
                    PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                    "insert into Formazione_Nazionale(codiceEvento, codiceAttività) VALUES(?, ?)");
                    st.setString(1, codiceEvento);
                    st.setString(2, codiceAttività);
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

	public String getCodiceAttività() {
		return codiceAttività;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceAttività(String codiceAttività) {
		this.codiceAttività = codiceAttività;
	}	

}
