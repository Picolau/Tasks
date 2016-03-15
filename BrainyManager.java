public class BrainyManager {
	public static final Brainy root = new Brainy("root");
	private TaskManager taskManager;
	private Brainy currentMother;

	public BrainyManager() {
		TimePair defaultNotificationDatePair = new TimePair(DateUnity.MINUTE, 1);
		TimePair defaultRepeatIntervalPair = new TimePair(DateUnity.MINUTE, 1);
		taskManager = new TaskManager(defaultNotificationDatePair, true, defaultRepeatIntervalPair);

		currentMother = root;
	}

	public void add(Brainy brainy) {
		currentMother.giveBirth(brainy);
		if (!brainy.isRepresentative()){
			Task taskFromBrainy = (Task) brainy;
			taskManager.add(taskFromBrainy);
		}
	}

	public void remove(Brainy brainy) {
		currentMother.setFree(brainy);
		if (!brainy.isRepresentative()){
			Task taskFromBrainy = (Task) brainy;
			taskManager.remove(taskFromBrainy);
		}
	}

	public void setCurrentMother(Brainy brainy) {
		if (brainy.isRepresentative()){
			currentMother = brainy;
		}
	}

	public Task mountTask(String name, String description, String strCompletionDate, String strNotificationDate, 
								boolean repeatNotifications, TimePair repeatIntervalPair){
		return taskManager.mount(name, description, strCompletionDate, strNotificationDate,
								 repeatNotifications, repeatIntervalPair);
	}

	@Override
	public String toString() {
		return currentMother.toString();
	}
}