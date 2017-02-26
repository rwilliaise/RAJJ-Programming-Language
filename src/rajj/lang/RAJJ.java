package rajj.lang;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class RAJJ {

	public static Hashtable<String, IRajScript> s = new Hashtable<>();
	public static Hashtable<String, Object> global = new Hashtable<>();
	public static boolean inIDE = true;

	public static void main(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		global.put("pi", Math.PI);
		global.put("maxuint64", Math.pow(2, 64) - 1);
		global.put("minuint64", -(Math.pow(2, 64) - 1));
		global.put("maxint32", Integer.MAX_VALUE);
		global.put("minint32", Integer.MIN_VALUE);
		global.put("maxint64", Math.pow(2, 63) - 1);
		global.put("minint64", -(Math.pow(2, 63) - 1));
		global.put("maxuint32", Math.pow(2, 32) - 1);
		global.put("minuint32", -(Math.pow(2, 32) - 1));
		register(new RunCommand());
		register(new ECommand());
		register(new PrintCommand());
		register(new SetValueCommand());
		if (inIDE)
			process(args[0]);
	}

	public static void raj(String[] string) {
		if (string[0].startsWith("#")) {
			return;
		}
		IRajScript script = s.get(string[0]);
		if (script != null) {
			script.execute(Arrays.copyOfRange(string, 1, string.length));
		} else {
			if (string[0].equals(""))
				return;
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
