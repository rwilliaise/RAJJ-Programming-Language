package rajj.lang;

public class PrintCommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		String out = "";
		for (String arg : args) {
			out += arg + " ";
		}
		System.out.println(out);
	}

	@Override
	public String getName() {
		return "print";
	}

}
