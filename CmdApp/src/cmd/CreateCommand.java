package cmd;

import java.io.IOException;
import java.nio.file.*;

public class CreateCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {

		String[] parsedCommand = ParseCommand(command);
		
		if(parsedCommand == null || parsedCommand.length != 2)
			throw new IOException("Invalid number of arguments!");
		
		String absPath = GetAbsoluthePath(parsedCommand[1]);
		Path path = Paths.get(absPath);
		
		Files.createDirectory(path);
	}

}
