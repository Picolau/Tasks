import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class MainTask {
	public static void main(String[] args) throws Exception {
		BrainyManager brainyManager = new BrainyManager();
		TimePair tp = new TimePair(DateUnity.MINUTE, 0);
		Task task = brainyManager.mountTask("Teste1", "Teste", "", "", true, tp);
		brainyManager.add(task);

		System.out.println(brainyManager.toString());
	}
}