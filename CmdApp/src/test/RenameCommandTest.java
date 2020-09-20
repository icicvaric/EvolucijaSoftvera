package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.RenameCommand;

class RenameCommandTest {

	@Test
	void CanInstantiateRenameCommand() {
		RenameCommand renameCommand = new RenameCommand();
		assertNotNull(renameCommand);
	}

	@Test
	void PerformCommandTest() {
		
	}
}
