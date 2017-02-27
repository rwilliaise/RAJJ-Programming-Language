package rajj.lang;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardCommand extends IRajjCommand {

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		String str = args[0];

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(str);
		clipboard.setContents(strSel, null);

		// stringSelection
	}

	@Override
	public String getName() {
		return "clipboard";
	}

}
