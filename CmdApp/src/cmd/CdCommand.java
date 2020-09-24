package cmd;

import java.io.File;
import java.io.IOException;

public class CdCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		String[] parsedCommand = ParseCommand(command);
		
		if(parsedCommand == null || parsedCommand.length != 2)
			throw new IOException("Invalid number of arguments!");
		
		String absPath = GetAbsoluthePath(parsedCommand[1]);
		File fileToChange = new File(absPath);
		
		if(!fileToChange.exists())
			return;
		
		System.setProperty("user.dir", absPath);
	}

}
