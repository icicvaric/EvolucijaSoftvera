package cmd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DeleteCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		
		String[] parsedCommand = ParseCommand(command);
		
		if( parsedCommand == null || parsedCommand.length != 2)
			throw new IOException("Invalid number of arguments!");
		
		String absPath = GetAbsoluthePath(parsedCommand[1]);
		File fileToDelete = new File(absPath);
		
		if(!fileToDelete.exists())
			return;
		
		if(!fileToDelete.isDirectory() && !fileToDelete.isFile())
			return;
		
		//will be true if we are deleting file or empty directory
		if(!fileToDelete.delete())
		{
			FileUtils.deleteDirectory(fileToDelete);
		}
		
	}

}
