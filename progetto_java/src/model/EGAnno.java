package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EGAnno {
	
	private String codiceEG;
	private String codiceIscritto;
	private int anno;
	private DBConnection con = new DBConnectionImpl();
	
	public EGAnno(String codiceEG, String codiceIscritto, int anno) {
		super();
		this.codiceEG = codiceEG;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public int iscrizioneEG() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into EG_ANNO(codiceEG, codiceIscritto, anno) VALUES(?, ?, ?)");
			st.setString(1, codiceEG);
			st.setString(2, codiceIscritto);
			st.setInt(3, anno);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}

}
