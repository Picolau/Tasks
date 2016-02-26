public class TimePair {
	private DateUnity unity;
	private int incrementer;

	public TimePair(DateUnity unity, int incrementer) {
		this.unity = unity;
		this.incrementer = incrementer;
	}

	public int getIncrementer() {
		return this.incrementer;
	}

	public DateUnity getDateUnity() { 
		return this.unity;
	}

	public long getMillis() {
		long millis = 1000;

		switch (unity) {
			case MINUTE: 
				millis *= 60*this.incrementer;
			break;
			case HOUR: 
				millis *= 60*60*this.incrementer;
			break;
			case DAY: 
				millis *= 24*60*60*this.incrementer;
			break;
			case WEEK: 
				millis *= 7*24*60*60*this.incrementer;
			break;
		}

		return millis;
	}
}