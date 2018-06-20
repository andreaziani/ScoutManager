package application.app;

import java.sql.Connection;
/**
 * Interface used for establish connection with data base.
 *
 */
public interface DBConnection {
	/**
	 * Get a new connection with the data base.
	 * @return a connection with database.
	 */
	Connection getMsSQLConnection();
}
