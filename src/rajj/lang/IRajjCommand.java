package rajj.lang;

public interface IRajjCommand {

	public void execute(String[] args, int line);

	public String getName();
}
