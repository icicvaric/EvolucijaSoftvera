package cmd;

import java.util.*;

public class Main {

	public static Map<String, Command> commandMap = new HashMap<String, Command>();

	public static void main(String[] args) {		

	}
	
	public static void initCommandMap()
	{	
		commandMap.put("cd", new CdCommand());
		commandMap.put("compare", new CompareCommand());
		commandMap.put("copy", new CopyCommand());
		commandMap.put("create", new CreateCommand());
		commandMap.put("delete", new DeleteCommand());
		commandMap.put("help", new HelpCommand());
		commandMap.put("dir", new DirCommand());
		commandMap.put("move", new MoveCommand());
		commandMap.put("rename", new RenameCommand());
	}

}
