package day10;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
public class Content {
	public static void main(String args[]) throws Exception {
	      //Registering the Driver
	      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	      //Getting the connection
	      String mysqlUrl = "jdbc:mysql://localhost/capdb";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "rootroot");
	      System.out.println("Connection established......");
	      //Creating the Statement
	      Statement stmt = con.createStatement();
	      //Executing the statement
	      String createTable = "CREATE TABLE Content( "
	         + "ContentID INT, "
	         + "Caption VARCHAR(255), "
	         + "Data LONGBLOB)";
	      stmt.execute(createTable);
	      //Inserting values
	      String query = "INSERT INTO Content(ContentID, Caption, Data) VALUES (?, ?, ?)";
	      PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setInt(1,101);
	      pstmt.setString(2, "Java_library");
	      FileInputStream fin = new FileInputStream("E:\\images\\lily.jpg");
	      pstmt.setBinaryStream(3, fin);
	      pstmt.execute();

	      pstmt.setInt(1, 102);
	      pstmt.setString(2, "scripting Language");
	      fin = new FileInputStream("E:\\images\\coffee.jpg");
	      pstmt.setBinaryStream(3, fin);
	      pstmt.execute();
	      
	      pstmt.setInt(1, 103);
	      pstmt.setString(2, "NoSQL database");
	      fin = new FileInputStream("E:\\images\\cat.jpg");
	      pstmt.setBinaryStream(3, fin);
	      pstmt.execute();
	      System.out.println("Data inserted");
	      ResultSet rs = stmt.executeQuery("Select *from Content");
	      while(rs.next()) {
	         System.out.print("ContendId: "+rs.getInt("ContentId")+", ");
	         System.out.print("Caption: "+rs.getString("Caption")+", ");
	         System.out.print("Data: "+rs.getBlob("Data"));
	         System.out.println();
	      }
	      
	      System.out.println("Record inserted......");
	   }
}