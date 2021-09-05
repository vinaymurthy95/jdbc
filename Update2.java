package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering is done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");
			System.out.println("enter your username");
			String username2 = sc.next();
			System.out.println("enter your password");
			String password2 = sc.next();
			Statement smt = con.createStatement();

			String query = "Select * from user where username='" + username2 + "' and password='" + password2 + "'";

			ResultSet rs = smt.executeQuery(query);

			if (rs.next()) {

				System.out.println("user id:" + rs.getInt(1));
				System.out.println("user Name:" + rs.getString(2));
				System.out.println("user password:" + rs.getString(3));
				System.out.println("user phonenumber:" + rs.getLong(4));
				System.out.println("user fullname:" + rs.getString(5));
				System.out.println("user address:" + rs.getString(6));

				System.out.println("Sure To update Above Record Yes/No?");
				String ch = sc.next();
				if (ch.equalsIgnoreCase("yes")) {
					// System.out.println("");
					System.out.println("update address");
					String address = sc.next();
                    //we can add field which we can update in user details
					query = "update  user set address='" + address + "' where username='" + username2 + "' and password='"+password2+"'";
					smt.executeUpdate(query);
					System.out.println("record updated");
				} else {
					System.out.println("Record Not Found...");
				}

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
