package cmd;

import java.io.IOException;

import com.google.java.contract.Ensures;

public class HelpCommand extends Command {

	@Override
	public void PerformCommand(String command) throws IOException {
		String[] parsedCommand = ParseCommand(command);
		
		if(parsedCommand == null || parsedCommand.length != 1)
			throw new IOException("Invalid number of arguments!");
		
		System.out.print(GetCommandDetails());
	}
	
	@Ensures({"result != null", "!result.isEmpty()", "!result.isBlank()"})
	public String GetCommandDetails()
	{
		StringBuilder manual = new StringBuilder();
		manual.append("CD      command help => cd .. (change to parent) ; cd folderPath"); manual.append(System.lineSeparator());		
		manual.append("COMPARE command help => compare folderPath folderPath"); manual.append(System.lineSeparator());
		manual.append("COPY    command help => copy source(filePath or folderPath) destination(folderPath)"); manual.append(System.lineSeparator());
		manual.append("CREATE  command help => create folderPath"); manual.append(System.lineSeparator());
		manual.append("DELETE  command help => delete folderPath ; delete filePath"); manual.append(System.lineSeparator());
		manual.append("DIR     command help => dir . (for current folder) ; dir folderPath"); manual.append(System.lineSeparator());
		manual.append("MOVE    command help => move source(filePath or folderPath) destination(folerPath)"); manual.append(System.lineSeparator());
		manual.append("RENAME  command help => rename folderPath newName"); manual.append(System.lineSeparator());
		return manual.toString();
	}
}
