package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmd.Command;
import cmd.DirCommand;

class DirCommandTest {

	@Test
	void CanInstantiateDirCommand() {
		DirCommand dirCommand = new DirCommand();
		assertNotNull( dirCommand );
	}
}
