import java.util.Calendar;

public class Task {
	private Calendar creationDate; // *
	private Calendar completionDate; // required
	private Calendar notificationDate; // required
	private Calendar nextNotificationDate;
	private boolean repeatNotifications; // required
	private TimePair repeatInterval; // required in case repeatNotifications == true

	private String name; // required
	private String description; // optional

	public Task(String name, String description, Calendar completionDate, Calendar notificationDate, 
				boolean repeatNotifications, TimePair repeatInterval) {
		this.creationDate = Calendar.getInstance();
		this.completionDate = completionDate;
		this.notificationDate = notificationDate;
		this.repeatNotifications = repeatNotifications;
		this.repeatInterval = repeatInterval;
		this.name = name;
		this.description = description;

		this.nextNotificationDate = Calendar.getInstance();
		this.nextNotificationDate.set(Calendar.MINUTE, notificationDate.get(Calendar.MINUTE));
		this.nextNotificationDate.set(Calendar.HOUR_OF_DAY, notificationDate.get(Calendar.HOUR_OF_DAY));
		this.nextNotificationDate.set(Calendar.DAY_OF_MONTH, notificationDate.get(Calendar.DAY_OF_MONTH));
		this.nextNotificationDate.set(Calendar.MONTH, notificationDate.get(Calendar.MONTH));
		this.nextNotificationDate.set(Calendar.YEAR, notificationDate.get(Calendar.YEAR));
	}

	public Task(String name, String description) {
		this.creationDate = Calendar.getInstance();
		this.name = name;
		this.description = description;
	}

	public Calendar getCreationDate() {
		return this.creationDate;
	}

	public Calendar getCompletionDate() {
		return this.completionDate;
	}

	public Calendar getNotificationDate() {
		return this.notificationDate;
	}

	public Calendar getNextNotificationDate() {
		return this.nextNotificationDate;
	}

	public TimePair getRepeatInterval() {
		return this.repeatInterval;
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

	public void setRepeatInterval(TimePair newRepeatInterval) {
		switch (newRepeatInterval.getDateUnity()) {
			case MINUTE:
				nextNotificationDate.add(Calendar.MINUTE, newRepeatInterval.getIncrementer() - this.repeatInterval.getIncrementer());
			break;
			case HOUR:
				nextNotificationDate.add(Calendar.HOUR_OF_DAY, newRepeatInterval.getIncrementer() - this.repeatInterval.getIncrementer());
			break;
			case DAY:
				nextNotificationDate.add(Calendar.DAY_OF_MONTH, newRepeatInterval.getIncrementer() - this.repeatInterval.getIncrementer());
			break;
			case WEEK:
				nextNotificationDate.add(Calendar.DAY_OF_MONTH, 7*(newRepeatInterval.getIncrementer() - this.repeatInterval.getIncrementer()));
			break;
			case MONTH:
				nextNotificationDate.add(Calendar.MONTH, newRepeatInterval.getIncrementer() - this.repeatInterval.getIncrementer());
			break;
		}
		this.repeatInterval = newRepeatInterval;
	}

	public void setNotificationDate(Calendar notificationDate) {
		this.notificationDate = notificationDate;
	}

	public void setCompletionDate(Calendar completionDate) {
		this.completionDate = completionDate;
	}

	public void setRepeatNotifications(boolean repeatNotifications) {
		this.repeatNotifications = repeatNotifications;
	}

	public void updateNextNotificationDate() {
		switch (this.repeatInterval.getDateUnity()) {
			case MINUTE:
				nextNotificationDate.add(Calendar.MINUTE, this.repeatInterval.getIncrementer());
			break;
			case HOUR:
				nextNotificationDate.add(Calendar.HOUR_OF_DAY, this.repeatInterval.getIncrementer());
			break;
			case DAY:
				nextNotificationDate.add(Calendar.DAY_OF_MONTH, this.repeatInterval.getIncrementer());
			break;
			case WEEK:
				nextNotificationDate.add(Calendar.DAY_OF_MONTH, 7*(this.repeatInterval.getIncrementer()));
			break;
			case MONTH:
				nextNotificationDate.add(Calendar.MONTH, this.repeatInterval.getIncrementer());
			break;
		}
	}

	public boolean isReminder() {
		return this.repeatNotifications && nextNotificationDate.compareTo(completionDate) < 0;
	}

	@Override
	public String toString() {
		String toS = "";
		toS += "Creation date: " + dateToStr(this.creationDate) + "\n";
		toS += "Name: " + this.name + "\n";
		toS += "Description: " + this.description + "\n";
		if (this.completionDate != null) {
			toS += "Completion date: " + dateToStr(this.completionDate) + "\n";
		}
		if (this.notificationDate != null) {
			toS += "Notification date: " + dateToStr(this.notificationDate) + "\n";
		}
		toS += "Repeat notifications: " + this.repeatNotifications + "\n";
		toS += "Repeat interval: " + this.repeatInterval;
		return toS;
	}

	private String dateToStr(Calendar date) {
		return String.valueOf(date.get(Calendar.MONTH)) + "/" + String.valueOf(date.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(date.get(Calendar.YEAR)) + 
 		" " + String.valueOf(date.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(date.get(Calendar.MINUTE));
	}
}