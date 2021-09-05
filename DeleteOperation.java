package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering is done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");
			System.out.println("Enter Username ");
			String username1 = scanner.next();
			System.out.println("Enter Password ");
			String password1 = scanner.next();
			PreparedStatement pst = con.prepareStatement( "DELETE FROM User WHERE username=? and password=? ");
			 //Statement statement = con.createStatement();
			System.out.println("3. Statement has been created");
			//String query = "delete from user where username=? & password=? ";
			System.out.println("Set the values ");
			pst.setString(1, username1);
			pst.setString(2, password1);
			int rowsDeleted = pst.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			}else
			{
				System.out.println("NO recors found");
			}
			
			System.out.println("4.Query Executed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("6.Close the Connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
