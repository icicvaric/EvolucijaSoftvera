package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmd.Command;

class CommandTest {
	
	@Test
	void ParseCommandTest() {
		
		assertNull(Command.ParseCommand(null));
	}
	
	@Test
	void GetAbsoluthePathTest() {
		
		assertNull(Command.GetAbsoluthePath(null));
	}

}
