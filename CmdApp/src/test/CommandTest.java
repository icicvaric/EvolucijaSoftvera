package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmd.Command;

class CommandTest {

	@Test
	void CanInstantiateCommand() {
		Command command = new Command();
		assertNotNull(command);
	}

}
