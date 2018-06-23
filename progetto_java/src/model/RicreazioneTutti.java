package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RicreazioneTutti {
	
	private String codiceEvento;
	private String codiceParrocchia;
	private String codiceAttività;
	private DBConnection con = new DBConnectionImpl();
	
	public RicreazioneTutti(String codiceEvento, String codiceParrocchia, String codiceAttività) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceAttività = codiceAttività;
	}

	public int assegnamentoAttivitàRicreativaTutti() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into Ricreazione_Tutti(codiceEvento, codiceAttività, codiceParrocchia) VALUES(?, ?, ?)");
			st.setString(1, codiceEvento);
			st.setString(2, codiceAttività);
			st.setString(3, codiceParrocchia);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}
	
}
