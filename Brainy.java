public abstract class Brainy {
	private ArrayList<Brainy> brainies;
	private Brainy mother;

	public Brainy(Brainy mother) {
		brainies = new ArrayList<>();
		mother = new Brainy ();
	}

	public void giveBirth(Brainy son) {
		if (this.isRepresentative()) {
			brainies.add(son);
		}
	}

	public abstract void paint(Graphics g);

	public abstract boolean isRepresentative();
}