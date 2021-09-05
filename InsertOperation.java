package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		String password=null;
		long phone,length;
		Connection con = null;
		boolean valid =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering has been done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");
			System.out.println("Enter id");
			int id=scanner.nextInt();
			System.out.println("Enter Username ");
			String username=scanner.next();
			System.out.println("Enter Password ");
			do {
				password = scanner.next();

				if (password.length() < 8) {
					valid = false;
					System.out.println("Invalid Password,please enter valid password");
					continue;
				} else {
					valid = true;
				}
			} while (!valid);
			System.out.println("Enter Phonenumber");
			do {
				phone=scanner.nextLong();
				length=String.valueOf(phone).length();

				if (length < 10 ) {
					valid = false;
					System.out.println("Invalid Phone number,please enter valid phone number");
					continue;
				}if (length > 10 ) {
					valid = false;
					System.out.println("Invalid Phone number,please enter valid phone number");
					continue;
				} 
				else {
					valid = true;
				}
			} while (!valid);
			scanner.nextLine();
			System.out.println("Enter FullName ");
			String fullname=scanner.nextLine();
			System.out.println("Enter Address ");
			String address=scanner.nextLine();
			
			PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			System.out.println("3. Statement has been created");

			System.out.println("Setting the values... ");
			pst.setInt(1, id);
			pst.setString(2, username);
			pst.setString(3,password);
			pst.setLong(4, phone);
			pst.setString(5, fullname);
			pst.setString(6,address);
			pst.execute();
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
