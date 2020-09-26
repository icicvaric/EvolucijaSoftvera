package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import cmd.CreateCommand;
import cmd.HelpCommand;

class HelpCommandTest {

	@Test
	void CanInstantiateHelpCommand() {
		HelpCommand helpCommand = new HelpCommand();
		assertNotNull(helpCommand);
	}

	@Test
	void PerformCommandTest() {
		HelpCommand helpCommand = new HelpCommand();
		
		assertThrows(IOException.class, () -> helpCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> helpCommand.PerformCommand("help file1"));
		assertDoesNotThrow(() -> helpCommand.PerformCommand("help"));
	}
	
	@Test
	void GetDetailsTest() {
		HelpCommand helpCommand = new HelpCommand();
		String commandDetails = helpCommand.GetCommandDetails().toLowerCase();
		assertTrue( commandDetails != null);
		assertFalse( commandDetails.isEmpty() );
		assertFalse( commandDetails.isBlank() );
		assertTrue( commandDetails.contains("cd") );
		assertTrue( commandDetails.contains("compare") );
		assertTrue( commandDetails.contains("copy") );
		assertTrue( commandDetails.contains("create") );
		assertTrue( commandDetails.contains("delete") );
		assertTrue( commandDetails.contains("dir") );
		assertTrue( commandDetails.contains("move") );
		assertTrue( commandDetails.contains("rename") );
	}
}
