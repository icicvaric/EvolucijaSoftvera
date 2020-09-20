package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.CopyCommand;

class CopyCommandTest {

	@Test
	void CanInstantiateCopyCommand() {
		CopyCommand copyCommand = new CopyCommand();
		assertNotNull(copyCommand);
	}
	
	@Test
	void PerformCommandTest() {
		
	}

}
