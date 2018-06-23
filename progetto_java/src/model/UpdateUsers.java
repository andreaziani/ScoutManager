package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateUsers {
    public static List<String> updateIscritti(DBConnection con) {
        List<String> iscritti = new ArrayList<>();
        try {
                Statement st = con.getMsSQLConnection().createStatement();
                ResultSet rs = st.executeQuery("select codiceIscritto from ISCRITTO");
                if (rs.isBeforeFirst()) {
                        while (rs.next()) {
                                iscritti.add(rs.getString(1));
                        }
                } else {
                        iscritti.add("<Nessun iscritto memorizzato>");
                }
                st.close();
        } catch (SQLException e) {
                iscritti.add("<Nessun iscritto memorizzato>");
        }
        return iscritti;
}
}
