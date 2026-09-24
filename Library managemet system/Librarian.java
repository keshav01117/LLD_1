public class Librarian extends User {
	private String employeeNumber;

	public Librarian() {
		super();
	}

	public Librarian(String name, String contactInfo, String employeeNumber) {
		super(name, contactInfo);
		this.employeeNumber = employeeNumber;
	}

	public Librarian(Librarian other) {
		super(other);
		this.employeeNumber = other.employeeNumber;
	}

	@Override
	public void displayDashboard() {
		System.out.println("Librarian Dashboard");
		System.out.println("Employee Number: " + employeeNumber);
	}

	@Override
	public boolean canBorrowBooks() {
		return true;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void addNewBook(Book book) {
		// Add the book to the library catalogue.
	}

	public void removeBook(Book book) {
		// Remove the book from the library catalogue.
	}
}