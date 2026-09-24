public abstract class User {
	private static int totalUsers;
	private static int nextUserId;

	private String userId;
	private String name;
	private String contactInfo;

	public User() {
		this.userId = generateUniqueId();
		totalUsers++;
	}

	public User(String name, String contactInfo) {
		this.userId = generateUniqueId();
		this.name = name;
		this.contactInfo = contactInfo;
		totalUsers++;
	}

	public User(User other) {
		this.userId = other.userId;
		this.name = other.name;
		this.contactInfo = other.contactInfo;
		totalUsers++;
	}

	public static int getTotalUsers() {
		return totalUsers;
	}

	private static String generateUniqueId() {
		return String.valueOf(++nextUserId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public abstract void displayDashboard();

	public abstract boolean canBorrowBooks();
}
