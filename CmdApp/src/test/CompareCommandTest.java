package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cmd.CompareCommand;

class CompareCommandTest {

	@Test
	void CanInstantiateCompareCommand() {
		CompareCommand compareCommand = new CompareCommand();
		assertNotNull(compareCommand);
	}
	
	@Test
	void PerformCommandTest() {
		
	}

}
