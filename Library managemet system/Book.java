public abstract class Book implements Lendable {
	private String title;
	private boolean available = true;

	protected Book() {
	}

	protected Book(String title) {
		this.title = title;
	}

	protected Book(Book other) {
		this.title = other.title;
		this.available = other.available;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void lend() {
		if (!available) {
			throw new IllegalStateException("Book is already lent");
		}
		available = false;
	}

	@Override
	public void returnBook() {
		available = true;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	public abstract void displayBookDetails();
}