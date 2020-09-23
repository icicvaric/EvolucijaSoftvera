package cmd;

import java.io.File;
import java.io.IOException;

public class RenameCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		String[] parsedCommand = ParseCommand(command);
		
		if( parsedCommand == null || parsedCommand.length != 3)
			throw new IOException("Invalid number of arguments!");
		
		String absPath = GetAbsoluthePath(parsedCommand[1]);
		File dir = new File(absPath);
		
		if (!dir.isDirectory()) {
			  System.err.println("There is no directory @ given path");
		} else {
			File newDir = new File(dir.getParent() + File.separator + parsedCommand[2]);
		    dir.renameTo(newDir);
		}
		
	}

}
