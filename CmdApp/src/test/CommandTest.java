package test;

import static org.junit.jupiter.api.Assertions.*;

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
	void GetAbsoluthePathTest() {
		
		assertNull(Command.GetAbsoluthePath(null));
	}

}
