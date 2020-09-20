package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;
import org.junit.jupiter.api.Test;
import cmd.Command;

class CommandTest {
	
	@Test
	void ParseCommandTest() {
		
		String command = null;
		assertNull(Command.ParseCommand(command));
		
		command = new String();
		assertNull(Command.ParseCommand(command));
		
		command = new String("     ");
		assertNull(Command.ParseCommand(command));
		
		command = new String("help");
		String[] parsedCommand =  Command.ParseCommand(command);
		assertEquals(1, parsedCommand.length );
		assertEquals(command, parsedCommand[0]);
		
		command = new String("rename temp\\lib");
		parsedCommand =  Command.ParseCommand(command);
		assertEquals(2, parsedCommand.length );
		assertEquals("rename", parsedCommand[0]);
		assertEquals("temp\\lib", parsedCommand[1]);
	}
	
	@Test
	void GetAbsoluthePathTest() throws IOException {
		
		String path = null;		
		assertNull(Command.GetAbsoluthePath(path));
		
		path = new String();
		assertNull(Command.GetAbsoluthePath(path));
		
		path = new String("     ");
		assertNull(Command.GetAbsoluthePath(path));
		
		path = new String("C:\\Users\\Ivana\\Desktop");
		String absPath = Command.GetAbsoluthePath(path);
		assertNotNull(absPath);
		assertEquals(path, absPath);
		
		String currentPath = System.getProperty("user.dir").toString();
		Path absolutePath = Paths.get(currentPath).toAbsolutePath();
		
		path = new String(".");
		absPath = Command.GetAbsoluthePath(path);
		assertNotNull(absPath);
		assertEquals(absolutePath.toString(), absPath);
		
		path = new String("..");
		absPath = Command.GetAbsoluthePath(path);
		assertNotNull(absPath);
		assertEquals(absolutePath.getParent().toString(), absPath);
		
		path = new String("temp");
		absPath = Command.GetAbsoluthePath(path);
		assertNotNull(absPath);
		assertEquals(absolutePath.resolve(path).toString(), absPath);
	}
	
}
