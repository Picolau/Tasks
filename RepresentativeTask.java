public class RepresentativeTask extends Brainy {
	private Calendar creationDate;

	private String name; // required
	private String description; // optional

	public Task(String name, String description) {
		this.creationDate = Calendar.getInstance();
		this.name = name;
		this.description = description;
	}

	public Calendar getCreationDate() {
		return this.creationDate;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}