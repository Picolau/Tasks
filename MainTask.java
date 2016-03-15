import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class MainTask {
	public static void main(String[] args) throws Exception {
		BrainyManager brainyManager = new BrainyManager();
		TimePair tp = new TimePair(DateUnity.MINUTE, 0);
		Task t1 = brainyManager.mountTask("Task1", "Teste", "", "", true, tp);
		Brainy b1 = new Brainy("Brainy1");
		Task t2 = brainyManager.mountTask("Task2", "Teste", "", "", true, tp);
		Brainy b2 = new Brainy("Brainy2");
		Task t3 = brainyManager.mountTask("Task2", "Teste", "", "", true, tp);
		Brainy b3 = new Brainy("Brainy3");
		Task t4 = brainyManager.mountTask("Task4", "Teste", "", "", true, tp);
		Brainy b4 = new Brainy("Brainy4");

		brainyManager.add(t1);
		brainyManager.add(t2);
		brainyManager.add(t3);
		brainyManager.add(t4);
		brainyManager.add(b1);
		brainyManager.add(b2);
		brainyManager.add(b3);
		brainyManager.add(b4);

		System.out.println(brainyManager.toString());
	}
}