package practice.DataDrivenTeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseSelectQuery {
	public static void main(String[] args) throws SQLException {
		// step1:register the database driver
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		
		//step2: connect to database
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//step3:create sql statement
		Statement statement =connection.createStatement();
		
		//step4:execute select query and get result
		ResultSet result=statement.executeQuery("select * from student;");
		
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		//step5 :close the collection
		connection.close();

	}


}
