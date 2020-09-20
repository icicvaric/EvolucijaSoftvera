package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.HelpCommand;

class HelpCommandTest {

	@Test
	void CanInstantiateHelpCommand() {
		HelpCommand helpCommand = new HelpCommand();
		assertNotNull(helpCommand);
	}

	@Test
	void PerformCommandTest() {
		
	}
}
