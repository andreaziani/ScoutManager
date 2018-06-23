package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResponsabilitàEventoParrocchiaLC {
	
	private String codiceEvento;
	private String codiceParrocchia;
	private String codiceResponsabile;
	private DBConnection con = new DBConnectionImpl();
	
	public ResponsabilitàEventoParrocchiaLC(String codiceEvento, String codiceParrocchia, String codiceResponsabile) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceParrocchia = codiceParrocchia;
		this.codiceResponsabile = codiceResponsabile;
	}

	public int responsabilità_E_P_LC() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into Responsabilità_E_P_LC(codiceEvento, codiceParrocchia, codiceResponsabile) VALUES(?, ?, ?)");
			st.setString(1, codiceEvento);
			st.setString(2, codiceParrocchia);
			st.setString(3, codiceResponsabile);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}

}
