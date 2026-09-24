public class TextBook extends Book {
	public TextBook() {
		super();
	}

	public TextBook(String title) {
		super(title);
	}

	public TextBook(TextBook other) {
		super(other);
	}

	@Override
	public void displayBookDetails() {
		System.out.println("TextBook: " + getTitle());
	}
}