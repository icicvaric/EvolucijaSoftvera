package cmd;

import java.nio.file.*;

public abstract class Command {

	public static String[] ParseCommand(String command) {
		
		if( command == null || command.isEmpty() || command.isBlank() )
			return null;
		
		String[] result = command.split(" ");
		
		return result;
	}

	public static String GetAbsoluthePath(String path) {
		
		if( path == null || path.isEmpty() || path.isBlank() )
			return null;
		
		//we already have absolute path
		if(path.contains(":\\"))
			return path;
		
		String currentPath = System.getProperty("user.dir").toString();
		Path absoluthPath = Paths.get(currentPath).toAbsolutePath();
		
		if(path.equals("."))
			return absoluthPath.toString();
		
		if(path.equals(".."))
			return absoluthPath.getParent().toString();
		
		return absoluthPath.resolve( path ).toString();
	}
	
	public abstract void PerformCommand(String command);

}
