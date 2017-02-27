package rajj.lang;

public class WhileCommand extends IRajjCommand {

	@Override
	public void execute(String[] args) {
		int line1 = 1;
		if (!RAJJ.global.containsKey(args[0])) {
			while (Boolean.parseBoolean(args[0])) {
				while (!RAJJ.program.get(line + line1).getName().equals("}")) {
					RAJJ.program.get(line + line1).line = line + line1;
					RAJJ.program.get(line + line1).execute(RAJJ.args.get(line + line1));
					line += 1;
				}
				line = 1;
			}
		} else {
			while (Boolean.parseBoolean((String) RAJJ.global.get(args[0]))) {
				while (!RAJJ.program.get(line + line1).getName().equals("}")) {
					RAJJ.program.get(line + line1).line = line + line1;
					RAJJ.program.get(line + line1).execute(RAJJ.args.get(line + line1));
					line += 1;
				}
				line = 1;
			}
		}
	}

	@Override
	public String getName() {
		return "while";
	}

}
