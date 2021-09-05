package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering has been done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");

			System.out.println("Enter Username ");
			String username1 = scanner.next();
			System.out.println("Enter Password ");
			String password1 = scanner.next();

			// String query = "select * from user where username=? & password=? ";
			PreparedStatement pst = con.prepareStatement("select * from user where username=? and password=? ");
			// Statement statement = con.createStatement();
			System.out.println("3. Statement has been created");
			pst.setString(1, username1);
			pst.setString(2, password1);
			ResultSet rs = pst.executeQuery();
			System.out.println("4.Query Executed");
			System.out.println("5.Processing the result");

			if (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getLong(4)
						+ " " + rs.getString(5) + " " + rs.getString(6));
			} else {
				System.out.println("Wrong Credentials");
			}

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
