package practice.DataDrivenTeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDataToDAtaBaseNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// step1:register the database driver
				Driver dbdriver=new Driver();
				DriverManager.registerDriver(dbdriver);
				
				//step2: connect to database
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
				
				//step3:create sql statement
				Statement statement =connection.createStatement();
				
				//step4:execute non select query and get result
				int result=statement.executeUpdate("insert into student(sid,studentname,phno,course) values(106,\"fgh\", \"9854321678\", \"sel\")");
				
				System.out.println(result);
				//step5 :close the collection
				connection.close();


	}

}
