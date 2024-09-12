package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains reusable methods to read/write data in database
 */
public class Databaseutility {
	Connection connection;
	Statement statement;

	/**
	 * This method initializes database
	 * 
	 * @param url
	 * @param user
	 * @param pwd
	 */
	public void databaseInIt(String url, String user, String pwd) {
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads data from database column wise
	 * 
	 * @param query
	 * @param colName
	 * @return
	 */
	public List<Object> readFromDatabase(String query, String colName) {
		ResultSet result = null;

		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Object> list = new ArrayList<Object>();

		try {
			while (result.next()) {
				list.add(result.getObject(colName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	/**
	 * This method is used to modify database
	 * 
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query) {
		int result = 0;
		try {
			return statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
