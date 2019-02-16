package net.marudina.learning.table_gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonGateway {
	
	public PersonDTO findById(final Connection conn, final int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT ID, LASTNAME, FIRSTNAME, AGE FROM PEOPLE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		PersonDTO p = null;
		if (rs.next()) {
			p = new PersonDTO(rs.getInt(1));
			p.setLastName(rs.getString(2));
			p.setFirstName(rs.getString(3));
			p.setAge(rs.getInt(4));
		}

		assert (rs.next() == false);

		return p;
	}

	public void update(final Connection conn, final PersonDTO p) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE PEOPLE SET LASTNAME=?,FIRSTNAME=?,AGE=? WHERE ID=?");

		ps.setString(1, p.getLastName());
		ps.setString(2, p.getFirstName());
		ps.setInt(3, p.getAge());
		ps.setInt(4, p.getId());

		ps.executeUpdate();
	}

	public void insert(final Connection conn, final PersonDTO p) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO PEOPLE(ID, LASTNAME, FIRSTNAME, AGE) VALUES(?, ?, ?,?)");

		ps.setInt(1, p.getId());
		ps.setString(2, p.getLastName());
		ps.setString(3, p.getFirstName());
		ps.setInt(4, p.getAge());

		ps.executeUpdate();
	}

	public void delete(final Connection conn, final PersonDTO p) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM PEOPLE WHERE ID=?");

		ps.setInt(1, p.getId());

		ps.executeUpdate();
	}
}
