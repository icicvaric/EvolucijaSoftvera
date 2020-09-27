package cmd;

import java.nio.file.*;

import com.google.java.contract.*;

public abstract class Command {

	@Requires({"command != null", "command.isEmpty() == false", "command.isBlank() == false"})
	@Ensures({"result != null", "result.length > 0"})
	public static String[] ParseCommand(String command) {
		
		if( command == null || command.isEmpty() || command.isBlank() )
			return null;
		
		String[] result = command.split(" ");
		
		return result;
	}

	@Requires({"path != null", "path.isEmpty() == false", "path.isBlank() == false"})
	@Ensures("result != null")
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
	
	@Requires({"command != null", "command.isEmpty() == false", "command.isBlank() == false"}) // this will be applied to all inherited classes, so there is no need to write this in them too
	public abstract void PerformCommand(String command) throws Exception;

}
