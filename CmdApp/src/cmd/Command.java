package cmd;

public abstract class Command {

	public static String[] ParseCommand(String command) {
		
		if( command == null || command.isEmpty() || command.isBlank() )
			return null;
		
		String[] result = command.split(" ");
		
		return result;
	}

	public static String GetAbsoluthePath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
