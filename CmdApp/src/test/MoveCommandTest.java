package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmd.Command;
import cmd.MoveCommand;

class MoveCommandTest {

	@Test
	void CanInstantiateMoveCommand() {
		MoveCommand moveCommand = new MoveCommand();
		assertNotNull( moveCommand );
	}

}
