package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.CreateCommand;

class CreateCommandTest {

	@Test
	void CanInstantiateCreateCommand() {
		CreateCommand createCommand = new CreateCommand();
		assertNotNull(createCommand);
	}
	
	@Test
	void PerformCommandTest() {
		
	}
}
