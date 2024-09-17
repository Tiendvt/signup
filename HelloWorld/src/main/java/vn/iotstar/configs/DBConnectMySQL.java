package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
	private static String USERNAME = "root";


	 private static String PASSWORD = "Dovantientk1!";


	 private static String DRIVER = "com.mysql.cj.jdbc.Driver";


	 private static String URL = "jdbc:mysql://localhost:3306/laptrinhweb";

	 public static Connection getConnection() throws SQLException {


	 try {


	 Class.forName(DRIVER);


	 } catch (ClassNotFoundException e) {


	 e.printStackTrace();


	 }


	 return DriverManager.getConnection(URL, USERNAME, PASSWORD);


	 }



	 public static void main(String[] args) {


	 try {


	 new DBConnectMySQL();


	 System.out.println(DBConnectMySQL.getConnection());


	 }catch(Exception e) {


	 e.printStackTrace();
	 }
	 }


}
