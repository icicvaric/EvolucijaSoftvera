package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmd.DeleteCommand;

class DeleteCommandTest {

	@Test
	void CanInstantiateDeleteCommand() {
		DeleteCommand deleteCommand = new DeleteCommand();
		assertNotNull(deleteCommand);
	}

}
