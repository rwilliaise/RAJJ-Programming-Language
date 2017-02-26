package rajj.lang;

public class PrintCommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		if (!RAJJ.global.containsKey(args[0])) {
			String out = "";
			for (String arg : args) {
				out += arg + " ";
			}
			System.out.println(out);
		} else {
			System.out.println(RAJJ.global.get(args[0]));
		}
	}

	@Override
	public String getName() {
		return "print";
	}

}
