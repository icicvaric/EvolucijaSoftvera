package cmd;

import java.io.File;
import java.io.IOException;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class DirCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		
		String[] parsedCommand = ParseCommand(command);
		
		if(parsedCommand == null || parsedCommand.length != 2)
			throw new IOException("Invalid number of arguments!");
		
		System.out.println(GetFileNamesTest(parsedCommand[1]));
	}
	
	@Requires({"name != null", "!name.isEmpty()", "!name.isBlank()"})
	@Ensures("result != null")
	public String GetFileNamesTest(String name)
	{
		String absPath = GetAbsoluthePath(name);		
		File directory = new File(absPath);
		
		if(!directory.isDirectory()) {
			System.out.println("Not a directory");
			return "";
		}
		
		StringBuilder listOfFiles = new StringBuilder();
		File[] listFiles = directory.listFiles();
		for(File file : listFiles){
			listOfFiles.append(file.getName());
			listOfFiles.append(System.lineSeparator());
		}
		
		return listOfFiles.toString();
	}

}
