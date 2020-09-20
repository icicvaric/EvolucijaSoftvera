package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.CdCommand;

class CdCommandTest {

	@Test
	void CanInstantiateCdCommand() {
		CdCommand cdCommand = new CdCommand();
		assertNotNull(cdCommand);
	}
	
	@Test
	void PerformCommandTest() {
		
	}

}
