package rajj.lang;

public class RunCommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		RAJJ.process(args[0]);
	}

	@Override
	public String getName() {
		return "run";
	}

}
