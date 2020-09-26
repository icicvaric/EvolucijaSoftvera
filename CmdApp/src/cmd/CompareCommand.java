package cmd;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class CompareCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		String[] parsedCommand = ParseCommand(command);
		
		if( parsedCommand == null || parsedCommand.length != 3)
			throw new IOException("Invalid number of arguments!");
		
		String absPath1 = GetAbsoluthePath(parsedCommand[1]);		
		String absPath2 = GetAbsoluthePath(parsedCommand[2]);	
		File directory1 = new File(absPath1);
		File directory2 = new File(absPath2);
		
		if(!directory1.isDirectory() || !directory2.isDirectory())
			throw new IOException("Both objects that need to be compared must be directories!");
		
		System.out.println( GetDifference(directory1, directory2) );
	}
	
	public String GetDifference( File directory1, File directory2 )
	{
		File[] listFiles1 = directory1.listFiles();
		File[] listFiles2 = directory2.listFiles();
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		for(File file : listFiles1){
			set1.add(file.getName());
		}
		
		for(File file : listFiles2){
			set2.add(file.getName());
		}
		
		StringBuilder result = new StringBuilder();
		
		for(String name: set2)
		{
			if(!set1.contains(name))
				result.append(name + System.lineSeparator());
		}
		
		set1.removeAll(set2);	
		
		for(String fileName : set1)
		{
			result.append(fileName + System.lineSeparator());
		}
		
		return result.toString();
	}

}
