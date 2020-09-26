package cmd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		String[] parsedCommand = ParseCommand(command);
		
		if( parsedCommand == null || parsedCommand.length != 3)
			throw new IOException("Invalid number of arguments!");;
		
		String sourcePath = GetAbsoluthePath(parsedCommand[1]);
		String destPath = GetAbsoluthePath(parsedCommand[2]);
		
		File sourceFile = new File(sourcePath);
		File destFile = new File(destPath);
		
		if(!sourceFile.exists())
			throw new IOException("Source doesn't exist!");
		if (!destFile.exists())
			throw new IOException("Destination doesn't exist!");
		
		if(!destFile.isDirectory())
			throw new IOException("Destination must be a directory!");
		
		if(sourceFile.isDirectory())
		{
			FileUtils.copyDirectoryToDirectory(sourceFile, destFile);
		}
		else
		{
			FileUtils.copyFileToDirectory(sourceFile, destFile);
		}
	}

}
