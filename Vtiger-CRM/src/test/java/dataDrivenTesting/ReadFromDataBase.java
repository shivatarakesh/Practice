package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;





public class ReadFromDataBase {

	public static void main(String[] args) throws SQLException {
		// step1:create driver instance
		Driver dbdriver=new Driver();
		
		//step2:register to jdbc driver
		DriverManager.registerDriver(dbdriver);
		
		//step3: establish jdbc connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//step4:create statement
		Statement statement =connection.createStatement();
		
		//step5:execute query to fetch data
		ResultSet result=statement.executeQuery("select * from student;");
		
		while(result.next()) {
			System.out.println(result.getInt("sid")+"\t"+result.getString("studentname")+"\t"+result.getString("phno")+"\t"+result.getString("course"));
			
		}
		//step6:close database
		connection.close();

	}

}
