package net.marudina.learning.row_gateway.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Demonstrated all CRUD DB operations using Row Data Gateway (Fowler, "Patterns
 * of Enterprise Application Architecture")
 *
 * This variant puts the finders inside the Row Data Gateway (i.e. Person)
 * itself
 */
public class App {
	public static void main(final String[] args) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:.\\db\\payroll;USER=payroll_user;ifexists=true")) {
			create(conn);

			read(conn);

			update(conn);

			delete(conn);
		}
	}

	private static void read(final Connection conn) throws SQLException {
		System.out.println("Read");

		System.out.println("Find by Id:1");
		Person p1 = Person.findById(conn, 1);
		System.out.println(p1);

		System.out.println();
	}

	private static void create(final Connection conn) throws SQLException {
		System.out.println("Create");

		System.out.println("Find by Id:2 - check no such record exists");
		Person p1 = Person.findById(conn, 2);
		System.out.println(p1);

		System.out.println("Create record Id:2");
		Person p2 = new Person(2);
		p2.setLastName("Doe");
		p2.setFirstName("John");
		p2.setAge(40);

		p2.insert(conn);

		System.out.println("Find newly created record Id:2");
		Person p3 = Person.findById(conn, 2);
		System.out.println(p3);

		System.out.println();
	}

	private static void update(final Connection conn) throws SQLException {
		System.out.println("Update");

		System.out.println("Update record Id:2 dependentsNr");
		Person p1 = Person.findById(conn, 2);
		p1.setAge(45);

		p1.update(conn);

		System.out.println("Find updated record Id:2");
		Person p2 = Person.findById(conn, 2);
		System.out.println(p2);

		System.out.println();
	}

	private static void delete(final Connection conn) throws SQLException {
		System.out.println("Delete");

		System.out.println("Delete record Id:2");
		Person p1 = Person.findById(conn, 2);
		p1.delete(conn);

		System.out.println("Find updated record Id:2 - should be null");
		Person p2 = Person.findById(conn, 2);
		System.out.println(p2);

		System.out.println();
	}
}
