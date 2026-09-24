public class NovelBook extends Book {
	public NovelBook() {
		super();
	}

	public NovelBook(String title) {
		super(title);
	}

	public NovelBook(NovelBook other) {
		super(other);
	}

	@Override
	public void displayBookDetails() {
		System.out.println("NovelBook: " + getTitle());
	}
}