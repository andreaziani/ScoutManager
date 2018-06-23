package model;

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
		System.out.println(codiceRS);
		System.out.println(codiceIscritto);
		System.out.println(anno);
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into RS_ANNO(codiceIscritto, anno, codiceRS) VALUES(?, ?, ?)");
			st.setString(1, codiceIscritto);
			st.setInt(2, anno);
			st.setString(3, codiceRS);
			
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
