import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vrinda Class to set up connection to Database
 */
public class ConnectionToDB {
	private static final String databaseName = "storefront";
	private static final String username = "root";
	private static final String password = "root";
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String mysqlURL = host + databaseName;
	private static final String connectionClass = "com.mysql.cj.jdbc.Driver";

	/**
	 * @return established connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
        //object of connection class initialized as null
		Connection connection = null;
		try {
			Class.forName(connectionClass);
			connection = DriverManager.getConnection(mysqlURL, username,password);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException("Database or Credentials are wrong");
		}
		return connection;
	}
}
