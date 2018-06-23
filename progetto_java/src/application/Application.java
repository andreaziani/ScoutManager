package application;

import model.DBConnection;
import model.DBConnectionImpl;
import view.LoginWindow;

public class Application {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	DBConnection con = new DBConnectionImpl();
    	new LoginWindow(con);
    }
}
