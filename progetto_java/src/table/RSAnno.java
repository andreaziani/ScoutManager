package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class RSAnno {

	private String codiceRS;
	private String codiceIscritto;
	private int anno;
	private DBConnection con = new DBConnectionImpl();
	
	public RSAnno(String codiceRS, String codiceIscritto, int anno) {
		super();
		this.codiceRS = codiceRS;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public int iscrizioneRS() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RS_ANNO(codiceRS, codiceIscritto, anno) VALUES(?, ?, ?)");
			st.setString(1, codiceRS);
			st.setString(2, codiceIscritto);
			st.setInt(3, anno);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
	
}
