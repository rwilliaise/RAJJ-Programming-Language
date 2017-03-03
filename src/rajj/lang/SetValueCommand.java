package rajj.lang;

public class SetValueCommand extends IRajjCommand {

	@Override
	public void execute(String[] args) {
		if (args.length <= 1) {
			throw new IllegalArgumentException();
		}
		if (!args[0].equals("add")) {
			if (!args[1].equals("to"))
				throw new IllegalArgumentException();
			if (!RAJJ.global.containsKey(args[2])) {
				RAJJ.global.put(args[0], args[2]);
			} else {
				RAJJ.global.put(args[0], RAJJ.global.get(args[2]));
			}
		} else {
			if (!RAJJ.global.containsKey(args[2]) && !RAJJ.global.containsKey(args[3])) {
				RAJJ.global.put(args[1], Integer.parseInt(args[2]) + Integer.parseInt(args[3]));
			} else {
				if (!RAJJ.global.containsKey(args[2]) && RAJJ.global.containsKey(args[3])) {
					RAJJ.global.put(args[1],
							Integer.parseInt(args[2]) + Integer.parseInt((String) RAJJ.global.get(args[3])));
				}
				if (RAJJ.global.containsKey(args[2]) && !RAJJ.global.containsKey(args[3])) {
					RAJJ.global.put(args[1],
							Integer.parseInt((String) RAJJ.global.get(args[2])) + Integer.parseInt(args[3]));
				}
				if (RAJJ.global.containsKey(args[2]) && RAJJ.global.containsKey(args[3])) {
					RAJJ.global.put(args[1], Integer.parseInt((String) RAJJ.global.get(args[2]))
							+ Integer.parseInt((String) RAJJ.global.get(args[3])));
				}
			}
		}
	}

	@Override
	public String getName() {
		return "setvalue";
	}

}
