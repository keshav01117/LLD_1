public class Member extends User {
	private static final int MAX_BORROW_LIMIT = 5;
	private int borrowedBooksCount;

	public Member() {
		super();
	}

	public Member(String name, String contactInfo) {
		super(name, contactInfo);
	}

	public Member(String name, String contactInfo, int borrowedBooksCount) {
		super(name, contactInfo);
		this.borrowedBooksCount = borrowedBooksCount;
	}

	public Member(Member other) {
		super(other);
		this.borrowedBooksCount = other.borrowedBooksCount;
	}

	@Override
	public void displayDashboard() {
		System.out.println("Member Dashboard");
		System.out.println("Books Borrowed: " + borrowedBooksCount);
	}

	@Override
	public boolean canBorrowBooks() {
		return borrowedBooksCount < MAX_BORROW_LIMIT;
	}

	public int getBorrowedBooksCount() {
		return borrowedBooksCount;
	}

	public void setBorrowedBooksCount(int borrowedBooksCount) {
		this.borrowedBooksCount = borrowedBooksCount;
	}
}