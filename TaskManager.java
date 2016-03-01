import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class TaskManager {
	private class TaskListener implements Runnable {
		@Override
		public void run () {
			while (true){
				Calendar now = Calendar.getInstance();
				for (Task task : tasks){
					if (task.isReminder()){
						if (task.getNextNotificationDate().compareTo(now) <= 0) {
							System.out.println("Tarefa a comprir: " + task.toString());
							task.updateNextNotificationDate();
						}
					}
				}
				try {
					Thread.sleep(30000);
				} catch (Exception e){
					System.err.println("Deu ruim no sleep da Thread");
				}
			}
		}
	}

	private ArrayList<Task> tasks;
	private TimePair defaultNotificationDatePair;
	private boolean defaultRepeatNotifications;
	private TimePair defaultRepeatIntervalPair;

	public TaskManager(TimePair defaultNotificationDatePair, boolean defaultRepeatNotifications, TimePair defaultRepeatIntervalPair) {
		this.tasks = new ArrayList<>();
		this.defaultNotificationDatePair = defaultNotificationDatePair;
		this.defaultRepeatNotifications = defaultRepeatNotifications;
		this.defaultRepeatIntervalPair = defaultRepeatIntervalPair;
		
		TaskListener taskListener = new TaskListener();
		new Thread(taskListener).start();
	}

	public void addTask(String name, String description, String strCompletionDate, String strNotificationDate, 
						boolean repeatNotifications, TimePair repeatIntervalPair) {
		Calendar completionDate = getCalendarFrom(strCompletionDate);
		Calendar notificationDate = getCalendarFrom(strNotificationDate);

		if (strCompletionDate.equals("")) { 
			if (!strNotificationDate.equals("")) {
				if (repeatNotifications) {
					if (repeatIntervalPair.getIncrementer() == 0){ 
						repeatIntervalPair = defaultRepeatIntervalPair;
					}
				}
			} else {
				notificationDate = Calendar.getInstance();
				switch (defaultNotificationDatePair.getDateUnity()) {
					case MINUTE : 
						notificationDate.add(Calendar.MINUTE, defaultNotificationDatePair.getIncrementer()); 
					break;
					case HOUR : 
						notificationDate.add(Calendar.HOUR_OF_DAY, defaultNotificationDatePair.getIncrementer()); 
					break;
					case DAY : 
						notificationDate.add(Calendar.DAY_OF_MONTH, defaultNotificationDatePair.getIncrementer()); 
					break;
					case MONTH : 
						notificationDate.add(Calendar.MONTH, defaultNotificationDatePair.getIncrementer()); 
					break;
					case YEAR : 
						notificationDate.add(Calendar.YEAR, defaultNotificationDatePair.getIncrementer()); 
					break;
				}
				repeatNotifications = defaultRepeatNotifications;
				repeatIntervalPair = defaultRepeatIntervalPair;
			}
		}
		Task t = new Task(name, description, completionDate, notificationDate, repeatNotifications, repeatIntervalPair);
		tasks.add(t);
	}

	@Override
	public String toString() {
		String toS = "";
		for (Task task : tasks) {
			toS += task.toString() + "\n" + "__________________________";
		}
		return toS;
	}

	private Calendar getCalendarFrom(String date) {
		if (date == "") {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.ROOT);
		try {
			cal.setTime(sdf.parse(date)); // Mar 14 16:02:37 2011
		} catch (Exception e){
			System.err.println("Deu ruim no parser de data!");
		}
		return cal;
	}
}
