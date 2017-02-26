package rajj.lang;

public class SetValueCommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		if (args.length <= 1) {
			throw new IllegalArgumentException();
		}
		RAJJ.global.put(args[0], args[1]);
	}

	@Override
	public String getName() {
		return "setvalue";
	}

}
