package application.app;


public class Application {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	DBConnection con = new DBConnectionImpl();
    	new LoginWindow(con);
    }
}
