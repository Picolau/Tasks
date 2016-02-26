import java.util.Calendar;

public class Task {
	private Calendar creationDate; // *
	private Calendar completionDate; // required
	private Calendar notificationDate; // required
	private boolean repeatNotifications; // required
	private long repeatInterval; // required in case repeatNotifications == true

	private String name; // required
	private String description; // optional

	public Task(String name, String description, Calendar completionDate, Calendar notificationDate, 
				boolean repeatNotifications, long repeatInterval) {
		this.creationDate = Calendar.getInstance();
		this.completionDate = completionDate;
		this.notificationDate = notificationDate;
		this.repeatNotifications = repeatNotifications;
		this.repeatInterval = repeatInterval;
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

	public boolean repeatNotifications () {
		return this.repeatNotifications;
	}

	public long getRepeatInterval() {
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

	public void setRepeatInterval(long repeatInterval) {
		this.repeatInterval = repeatInterval;
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

	public boolean isReminder() {
		return this.completionDate == null;
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