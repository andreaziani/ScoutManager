package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class Acquisizione {
	
	private String nome;
	private String areaCompetenza;
	private String codiceIscritto;
	private DBConnection con = new DBConnectionImpl();
	
	public Acquisizione(String nome, String areaCompetenza, String codiceIscritto) {
		super();
		this.nome = nome;
		this.areaCompetenza = areaCompetenza;
		this.codiceIscritto = codiceIscritto;
	}

	public int acquisizione() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into acquisizione(codiceIscritto, nomeCompetenza, areaCompetenza) VALUES(?, ?, ?)");
			st.setString(1, codiceIscritto);
			st.setString(2, nome);
			st.setString(3, areaCompetenza);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}

}
