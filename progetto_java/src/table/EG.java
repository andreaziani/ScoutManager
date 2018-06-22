package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class EG {

	private String codiceEG;
	private DBConnection con = new DBConnectionImpl();

	public EG(String codiceEG) {
		super();
		this.codiceEG = codiceEG;
	}

	public int inserisciEG() {
		PreparedStatement st;
		int result;
		try {
			st = con.getMsSQLConnection().prepareStatement("insert into EG(codiceEG) VALUES(?) ");
			st.setString(1, this.codiceEG);
			result = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}

	public String getCodiceEG() {
		return codiceEG;
	}

	public void setCodiceEG(String codiceEG) {
		this.codiceEG = codiceEG;
	}

}
