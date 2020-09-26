package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static Map<String, Command> commandMap = new HashMap<String, Command>();

	public static void main(String[] args) {	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		initCommandMap();
		
		while(true)
		{
			System.out.print(System.getProperty("user.dir") + "> ");
			try {
				String option = reader.readLine();
				ExecuteCommand(option);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch( Exception e )
			{
				System.out.println(e.getMessage());
			}
		}
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

	public static boolean IsInputValid(String option) {
		if(option == null || option.isBlank() || option.isEmpty())
			return false;
		
		String[] commands = option.split(" ");
		if( !commandMap.keySet().contains(commands[0]))
			return false;
		
		return true;
	}

	public static void ExecuteCommand(String option) throws Exception{
		
		if(option == null)
			throw new Exception("Input cannot be null");
		
		option = option.trim();
		if (IsInputValid(option))
		{
			commandMap.get(option.split(" ")[0]).PerformCommand(option);
		}
	}

}
