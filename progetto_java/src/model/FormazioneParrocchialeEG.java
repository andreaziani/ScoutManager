package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormazioneParrocchialeEG {
	
	private String codiceEvento;
	private String codiceAttività;
	private String codiceParrocchia;
	private DBConnection con = new DBConnectionImpl();
	
	public FormazioneParrocchialeEG(String codiceEvento, String codiceAttività, String codiceParrocchia) {
		super();
		this.codiceEvento = codiceEvento;
		this.codiceAttività = codiceAttività;
		this.codiceParrocchia = codiceParrocchia;
	}

	public int assegnamentoAttivitàFormativaEG() {
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into Formazione_Parrocchiale_EG(codiceEvento, codiceAttività, codiceParrocchia) VALUES(?, ?, ?)");
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
