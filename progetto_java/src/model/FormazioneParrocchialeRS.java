package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class FormazioneParrocchialeRS {

	private String codiceEvento;
	private String codiceAttività;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public FormazioneParrocchialeRS(String codiceEvento, String codiceAttività, String codiceParrocchia) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttività = codiceAttività;
		this.codiceParrocchia = codiceParrocchia;
	}

	public int assegnamentoAttivitàFormativaRS() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into Formazione_Parrocchiale_RS(codiceEvento, codiceAttività, codiceParrocchia) VALUES(?, ?, ?)");
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
