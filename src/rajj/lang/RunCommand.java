package rajj.lang;

public class RunCommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		if (!RAJJ.global.containsKey(args[0])) {
			RAJJ.process(args[0]);
		} else {
			RAJJ.process(RAJJ.global.get(args[0]).toString());
		}
	}

	@Override
	public String getName() {
		return "run";
	}

}
