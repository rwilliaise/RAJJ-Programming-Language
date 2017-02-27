package rajj.lang;

public abstract class IRajjCommand {

	public int line;

	public abstract void execute(String[] args);

	public abstract String getName();
}
