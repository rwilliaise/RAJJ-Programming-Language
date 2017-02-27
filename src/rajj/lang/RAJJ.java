package rajj.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class RAJJ {

	public static Hashtable<String, IRajjCommand> s = new Hashtable<>();
	public static Hashtable<String, IBaseMod> mods = new Hashtable<>();
	public static Hashtable<String, Object> global = new Hashtable<>();
	public static List<IRajjCommand> program = new ArrayList<>();
	public static boolean inIDE = true;

	private static boolean done = false;

	public static void main(String[] args) {
		if (args.length == 0 && inIDE) {
			throw new IllegalArgumentException();
		}
		for (String mod : mods.keySet()) {
			IBaseMod baseMod = mods.get(mod);
			baseMod.init();
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
		registerCommand(new RunCommand());
		registerCommand(new ECommand());
		registerCommand(new PrintCommand());
		registerCommand(new SetValueCommand());
		done = true;
		if (inIDE) {
			process("/rajj/testing/test.txt");
			inIDE = false;
		}
	}

	public static void raj(String[] string, int line) {
		if (string[0].startsWith("#")) {
			return;
		}
		IRajjCommand script = s.get(string[0]);
		if (script != null) {
			script.execute(Arrays.copyOfRange(string, 1, string.length), line);
			program.add(script);
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

	public static void registerCommand(IRajjCommand script) {
		s.put(script.getName(), script);
	}

	public static void registerMod(IBaseMod mod) {
		mods.put(mod.getName(), mod);
	}

	public static void process(String in) {
		if (!done) {
			return;
		}
		Scanner scanner = new Scanner(RAJJ.class.getResourceAsStream(in));
		int line = 0;
		while (scanner.hasNextLine()) {
			String i = scanner.nextLine();
			line++;
			raj(i.split(" "), line);
		}

	}

	// public static InputStream grabInput(String in) {
	// return RAJJ.class.getResourceAsStream(in);
	// }
}
