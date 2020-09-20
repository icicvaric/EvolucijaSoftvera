package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.DirCommand;

class DirCommandTest {

	@Test
	void CanInstantiateDirCommand() {
		DirCommand dirCommand = new DirCommand();
		assertNotNull( dirCommand );
	}
	
	@Test
	void PerformCommandTest() {
		
	}
}
