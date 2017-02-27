package rajj.lang;

public class DollarCommand extends IRajjCommand {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		// try {
		// new
		// File(Files.createDirectories(Paths.get(RAJJ.currentOpenFile)).toString()
		// + "/" + args[0]);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// System.
	}

	@Override
	public String getName() {
		return "$";
	}

}
