package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class Parrocchia {
		
	private String codiceParrocchia;
	private String nome;
	private String indirizzo;
	private String numeroCivico;
	private DBConnection con = new DBConnectionImpl();
	
	public Parrocchia(String codiceParrocchia, String nome, String indirizzo, String numeroCivico) {
		this.codiceParrocchia = codiceParrocchia;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroCivico = numeroCivico;
	}

	public int inserisciParrocchia() {
		int result;
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into PARROCCHIA(codiceParrocchia, nome, Ind_via, Ind_numCivico) VALUES(?, ?, ?, ?) ");
			st.setString(1, this.codiceParrocchia);
			st.setString(2, this.nome);
			st.setString(3, this.indirizzo);
			st.setInt(4, Integer.parseInt(this.numeroCivico));
			result = st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}
	
	public String getCodiceParrocchia() {
		return this.codiceParrocchia;
	}

	public String getNome() {
		return this.nome;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getNumeroCivico() {
		return this.numeroCivico;
	}
	
	public void setCodiceParrocchia(String codiceParrocchia) {
		this.codiceParrocchia = codiceParrocchia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
		
}
