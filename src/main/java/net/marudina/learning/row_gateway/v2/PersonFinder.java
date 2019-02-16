package net.marudina.learning.row_gateway.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonFinder {
	public Person findById(final Connection conn, final int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT ID, LASTNAME, FIRSTNAME, AGE FROM PEOPLE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Person p = null;
		if (rs.next()) {
			p = new Person(rs.getInt(1));
			p.setLastName(rs.getString(2));
			p.setFirstName(rs.getString(3));
			p.setAge(rs.getInt(4));
		}

		assert (rs.next() == false);

		return p;
	}
}
