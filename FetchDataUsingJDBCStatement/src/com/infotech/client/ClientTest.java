package com.infotech.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {
		// getEmployeeById();
		getAllEmployeesInfo();
	}

	private static void getAllEmployeesInfo() {

		try (Connection connection = DBUtil.getConnection(); Statement st = connection.createStatement();) {

			String SQL = "SELECT *FROM employee_table";
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");

				System.out.println(empId + "\t" + eName + "\t" + salary + "\t" + email + "\t" + bonus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getEmployeeById() {

		try (Connection connection = DBUtil.getConnection(); Statement st = connection.createStatement();) {

			String SQL = "SELECT *FROM employee_table WHERE employee_id=3";
			ResultSet rs = st.executeQuery(SQL);
			if (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");

				System.out.println(empId + "\t" + eName + "\t" + salary + "\t" + email + "\t" + bonus);

			} else {
				System.out.println("Employee doesn't exit with provided ID..");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
