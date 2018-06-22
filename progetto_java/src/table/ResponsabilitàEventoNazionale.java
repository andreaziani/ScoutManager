package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class ResponsabilitàEventoNazionale {
	
	private String codiceEvento;
	private String codiceResponasbile;
	private DBConnection con = new DBConnectionImpl();
	
	public ResponsabilitàEventoNazionale(String codiceEvento, String codiceResponasbile) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceResponasbile = codiceResponasbile;
	}
	
	public int execQuery() {
	    int rs;
            try {
                    PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                    "insert into Responsabilità_E_N(codiceEvento, codiceResponsabile) VALUES(?, ?)");
                    st.setString(1, codiceEvento);
                    st.setString(2, codiceResponasbile);
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

	public String getCodiceResponasbile() {
		return codiceResponasbile;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public void setCodiceResponasbile(String codiceResponasbile) {
		this.codiceResponasbile = codiceResponasbile;
	}
	
}
