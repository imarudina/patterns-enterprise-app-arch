package net.marudina.learning.table_gateway;

public class PersonDTO {
	
	private final int id;
	private String lastName;
	private String firstName;
	private int age;

	public PersonDTO(final int id) {
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

}
