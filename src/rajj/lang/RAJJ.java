package rajj.lang;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class RAJJ {

	public static Hashtable<String, IRajScript> s = new Hashtable<>();
	public static Hashtable<String, Object> global = new Hashtable<>();

	public static void main(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		register(new RunCommand());
		register(new ECommand());
		register(new PrintCommand());
		process(args[0]);
	}

	public static void raj(String[] string) {
		IRajScript script = s.get(string[0]);
		if (script != null) {
			script.execute(Arrays.copyOfRange(string, 1, string.length));
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void register(IRajScript script) {
		s.put(script.getName(), script);
	}

	public static void process(String args) {
		Scanner scanner = new Scanner(RAJJ.class.getResourceAsStream(args));
		while (scanner.hasNextLine()) {
			String i = scanner.nextLine();
			raj(i.split(" "));
		}
	}
}
