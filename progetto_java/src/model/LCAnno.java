package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class LCAnno {

	private String codiceLC;
	private String codiceIscritto;
	private int anno;
	private DBConnection con = new DBConnectionImpl();
	
	public LCAnno(String codiceLC, String codiceIscritto, int anno) {
		super();
		this.codiceLC = codiceLC;
		this.codiceIscritto = codiceIscritto;
		this.anno = anno;
	}

	public int iscrizioneLC() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into LC_ANNO(codiceLC, codiceIscritto, anno) VALUES(?, ?, ?)");
			st.setString(1, codiceLC);
			st.setString(2, codiceIscritto);
			st.setInt(3, anno);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
	
}
