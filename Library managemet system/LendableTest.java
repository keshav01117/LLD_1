public class LendableTest {
	private static class DummyLendable implements Lendable {
		private boolean available = true;

		@Override
		public void lend() {
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
	}

	public static void main(String[] args) {
		DummyLendable dummy = new DummyLendable();
		check(dummy.isAvailable(), "Dummy lendable should start available");
		dummy.lend();
		check(!dummy.isAvailable(), "Lending should make the dummy unavailable");
		dummy.returnBook();
		check(dummy.isAvailable(), "Returning should make the dummy available");

		TextBook defaultBook = new TextBook();
		TextBook titledBook = new TextBook("Java Fundamentals");
		TextBook copiedBook = new TextBook(titledBook);
		check(defaultBook.getTitle() == null, "Default constructor should leave title unset");
		check("Java Fundamentals".equals(copiedBook.getTitle()),
				"Copy constructor should copy the title");

		Book lendableBook = titledBook;
		lendableBook.lend();
		check(!lendableBook.isAvailable(), "Book should support the Lendable contract");
		lendableBook.returnBook();
		check(lendableBook.isAvailable(), "Book should be returnable");

		System.out.println("All Lendable and Book tests passed.");
	}

	private static void check(boolean condition, String message) {
		if (!condition) {
			throw new AssertionError(message);
		}
	}
}