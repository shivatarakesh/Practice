package practice.DataDrivenTeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class ReadDataFromDataBaseTryCatchFinally {
	@Test
	public void unitTesting() throws SQLException {
		String ExpectedName = "fh";
		Boolean flag = false;
		Connection connection = null;
		try {
			// step1:register the database driver
			Driver dbdriver = new Driver();
			DriverManager.registerDriver(dbdriver);

			// step2: connect to database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");

			// step3:create sql statement
			Statement statement = connection.createStatement();

			// step4:execute select query and get result
			ResultSet result = statement.executeQuery("select * from student;");

			while (result.next()) {
				String ActualName = result.getString(2);
				if(ExpectedName.equals(ActualName)) {
					flag=true;
					System.out.println(ExpectedName+" is available==PASS");
				}
			}
			if(flag==false) {
				System.out.println(ExpectedName+" is available==FAIL");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("handle exception");
		} finally {

			// step5 :close the collection
			connection.close();
			System.out.println("===Connection is closed===");
		}

	}

}
