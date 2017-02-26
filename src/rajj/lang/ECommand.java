package rajj.lang;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ECommand implements IRajScript {

	@Override
	public void execute(String[] args) {
		String myString = "";
		StringSelection stringSelection = new StringSelection(myString);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		// stringSelection
	}

	@Override
	public String getName() {
		return "emptyClipboard";
	}

}
