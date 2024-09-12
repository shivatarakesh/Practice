package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteToDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		Statement statement=connection.createStatement();
		
		int result=statement.executeUpdate("insert into student(sid,studentname,phno,course) values(105,\"efg\", \"9854321678\", \"api\")");
		
		System.out.println(result);
		
		connection.close();

	}

}
