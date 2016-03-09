public abstract class Brainy {
	private Calendar creationDate;
	private String name;

	private ArrayList<Brainy> brainies;
	private Brainy mother;

	public Brainy(String name) {
		this.creationDate = Calendar.getInstance();
		brainies = new ArrayList<>();
		mother = null;

		this.name = name;
	}

	public void giveBirth(Brainy son) {
		if (this.isRepresentative()) {
			brainies.add(son);
		}
		son.mother = this;
	}

	public void free(Brainy son) {
		son.mother = null;
		this.brainies.remove(son);
	}

	public Calendar getCreationDate() {
		return this.creationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

	}

	public void paint(Graphics g){
		//TODO
	}

	public boolean isRepresentative() {
		return true;
	}
}