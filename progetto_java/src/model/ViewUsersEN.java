package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ViewUsersEN {
    
    private static DBConnection con = new DBConnectionImpl();
    
    public static String iscrittiAdEvento(String codiceEvento) {
        PreparedStatement st;
        String row = "CodIscritto \t Nome \t Cognome \t dataNascita \t NumeroTelefono \n";
        try {
                st = con.getMsSQLConnection().prepareStatement(
                                "select I.codiceIscritto, I.nome, I.cognome, I.dataNascita, I.numeroTelefono from REGISTRAZIONE_E_N R join ISCRITTO I on (R.codiceIscritto = I.codiceIscritto) where R.codiceEvento = ? ");
                st.setString(1, codiceEvento);
                ResultSet rs = st.executeQuery();
                ResultSetMetaData rsm = st.getMetaData();
                while(rs.next()) {
                        for(int i = 1; i <= rsm.getColumnCount(); i++) {
                                row += rs.getString(i);
                                row += "\t";
                        }
                        row += "\n";
                }
        } catch (SQLException e) {
                return row;
        }
        return row;
        
}
    
}
