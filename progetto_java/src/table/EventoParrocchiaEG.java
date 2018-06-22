package table;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.app.DBConnection;
import application.app.DBConnectionImpl;

public class EventoParrocchiaEG{
	
	private String codiceParrocchia;
	private String codiceEvento;
	private String tipo;
	private String dataInizio;
	private String dataFine;
	private String località;
	private String descrizione;
	private DBConnection con = new DBConnectionImpl();
	
	public EventoParrocchiaEG(String codiceParrocchia, String codiceEvento, String tipo, String dataInizio,
			String dataFine, String località, String descrizione) {
		super();
		this.codiceParrocchia = codiceParrocchia;
		this.codiceEvento = codiceEvento;
		this.tipo = tipo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.località = località;
		this.descrizione = descrizione;
	}

	public int inserimentoEvento() {
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement(
					"insert into E_P_EG(codiceParrocchia, codiceEvento, tipo, dataInizio, dataFine, località, descrizione) VALUES(?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, codiceParrocchia);
			st.setString(2, codiceEvento);
			st.setString(3, tipo);
			st.setString(4, dataInizio);
			st.setString(5, dataFine);
			st.setString(6, località);
			st.setString(7, descrizione);
			return st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
}
