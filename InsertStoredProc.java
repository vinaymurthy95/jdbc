package com.jdbc.assignments;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertStoredProc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering has been done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");
			CallableStatement cst = con.prepareCall("{call emp.insert1(?,?,?)}");
			System.out.println("3. Statement has been created");

			cst.setInt(1, 45789645);
			cst.setString(2, "Bharath");
			cst.setInt(3, 2000);
			cst.execute();
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
