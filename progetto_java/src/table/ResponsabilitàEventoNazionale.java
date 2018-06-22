package table;

import java.sql.*;

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
	
	public String viewEvbyDateQuery(java.util.Date date) {
	    ResultSet rs;
	    String row = "";
	    
	    try {
                    PreparedStatement st = con.getMsSQLConnection().prepareStatement(
                                    "select * from E_NAZIONALE E JOIN Responsabilità_E_N RN ON (E.codiceEvento = RN.codiceEvento) " + 
                                    "WHERE dataInizio = ? and RN.codiceResponsabile = ?");
                    st.setDate(1, new java.sql.Date(date.getTime()));
                    st.setString(2, codiceResponasbile);
                    rs =  st.executeQuery();
                    
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    while (rs.next()) {
                            for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
                                    row += rs.getString(i) + "\t";
                            }
                            row += "\n";
                    }
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();   
                return "";
            }
            return row;
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
