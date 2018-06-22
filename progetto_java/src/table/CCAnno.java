package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class CCAnno {
	
	private String codiceCC;
	private String codiceIscritto;
	private int anno;
	private DBConnection con = new DBConnectionImpl();
	
	public CCAnno(String codiceCC, String codiceIscritto, int anno) {
		super();
		this.codiceCC = codiceCC;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public int iscrizioneCC() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into CC_ANNO(codiceCC, codiceIscritto, anno) VALUES(?, ?, ?)");
			st.setString(1, codiceCC);
			st.setString(2, codiceIscritto);
			st.setInt(3, anno);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}

}
