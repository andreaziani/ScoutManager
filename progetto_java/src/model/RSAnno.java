package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		int rs;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RS_ANNO(codiceIscritto, anno, codiceRS) VALUES(?, ?, ?)");
			st.setString(1, codiceIscritto);
			st.setInt(2, anno);
			st.setString(3, codiceRS);
			rs = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			return 0;
		}
		return rs;
	}
	
}
