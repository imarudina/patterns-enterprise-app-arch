package net.marudina.learning.row_gateway.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Person {
	private final int id;
	private String lastName;
	private String firstName;
	private int age;

	public Person(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person {\n");
		sb.append(" id: " + id + "\n");
		sb.append(" lastName: " + lastName + "\n");
		sb.append(" firstName: " + firstName + "\n");
		sb.append(" age: " + age + "\n");
		sb.append("}");

		return sb.toString();
	}

	public void update(final Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE PEOPLE SET LASTNAME=?,FIRSTNAME=?,AGE=? WHERE ID=?");

		ps.setString(1, lastName);
		ps.setString(2, firstName);
		ps.setInt(3, age);
		ps.setInt(4, id);

		ps.executeUpdate();
	}

	public void insert(final Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO PEOPLE(ID, LASTNAME, FIRSTNAME, AGE) VALUES(?, ?, ?,?)");

		ps.setInt(1, id);
		ps.setString(2, lastName);
		ps.setString(3, firstName);
		ps.setInt(4, age);

		ps.executeUpdate();
	}

	public void delete(final Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM PEOPLE WHERE ID=?");

		ps.setInt(1, id);

		ps.executeUpdate();
	}

}
