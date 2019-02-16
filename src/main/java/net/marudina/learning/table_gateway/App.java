package net.marudina.learning.table_gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Demonstrated all CRUD DB operations using Row Data Gateway (Fowler, "Patterns
 * of Enterprise Application Architecture")
 *
 * This variant splits the finders from the Row Data Gateway (i.e. Person) and puts
 * them in a separate PersonFinder
 * 
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
		PersonGateway finder = new PersonGateway();
		PersonDTO p1 = finder.findById(conn, 1);
		System.out.println(p1);

		System.out.println();
	}

	private static void create(final Connection conn) throws SQLException {
		System.out.println("Create");

		System.out.println("Find by Id:2 - check no such record exists");
		PersonGateway finder = new PersonGateway();
		PersonDTO p1 = finder.findById(conn, 2);
		System.out.println(p1);

		System.out.println("Create record Id:2");
		PersonDTO p2 = new PersonDTO(2);
		p2.setLastName("Doe");
		p2.setFirstName("John");
		p2.setAge(40);

		finder.insert(conn, p2);

		System.out.println("Find newly created record Id:2");
		PersonDTO p3 = finder.findById(conn, 2);
		System.out.println(p3);

		System.out.println();
	}

	private static void update(final Connection conn) throws SQLException {
		System.out.println("Update");

		System.out.println("Update record Id:2 dependentsNr");
		PersonGateway finder = new PersonGateway();
		PersonDTO p1 = finder.findById(conn, 2);
		p1.setAge(45);

		finder.update(conn, p1);

		System.out.println("Find updated record Id:2");
		PersonDTO p2 = finder.findById(conn, 2);
		System.out.println(p2);

		System.out.println();
	}

	private static void delete(final Connection conn) throws SQLException {
		System.out.println("Delete");

		System.out.println("Delete record Id:2");
		PersonGateway finder = new PersonGateway();
		PersonDTO p1 = finder.findById(conn, 2);
		
		finder.delete(conn, p1);

		System.out.println("Find updated record Id:2 - should be null");
		PersonDTO p2 = finder.findById(conn, 2);
		System.out.println(p2);

		System.out.println();
	}
}
