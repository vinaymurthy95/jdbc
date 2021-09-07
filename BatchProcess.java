package com.jdbc.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and Registering has been done..!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?user=root&password=root");
			System.out.println("2. Connection has been Established");

			con.setAutoCommit(false);

			Statement stmt = con.createStatement();
			stmt.addBatch("insert into user1 values(55678456,'abhi',40000)");
			stmt.addBatch("insert into user1 values(654756191,'umesh',50000)");

			stmt.executeBatch();

			con.commit();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
