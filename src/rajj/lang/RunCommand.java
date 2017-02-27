package rajj.lang;

public class RunCommand extends IRajjCommand {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		if (!RAJJ.global.containsKey(args[0])) {
			RAJJ.process(args[0]);
		} else {
			RAJJ.process((String) RAJJ.global.get(args[0]));
		}
	}

	@Override
	public String getName() {
		return "run";
	}

}
