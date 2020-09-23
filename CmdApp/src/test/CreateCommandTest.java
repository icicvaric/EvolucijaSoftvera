package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import cmd.CreateCommand;


class CreateCommandTest {

	@Test
	void CanInstantiateCreateCommand() {
		CreateCommand createCommand = new CreateCommand();
		assertNotNull(createCommand);
	}
	
	@Test
	void PerformCommandTest() throws IOException {
		CreateCommand createCommand = new CreateCommand();
		
		assertThrows(IOException.class, () -> createCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> createCommand.PerformCommand("create"));
		assertThrows(IOException.class, () -> createCommand.PerformCommand("create folder1 folder2"));
		assertThrows(IOException.class, () -> createCommand.PerformCommand("create document.txt"));
		
		createCommand.PerformCommand("create " + HelperMethods.absPath);
		assertTrue(Files.isDirectory(HelperMethods.absPath));
		
		HelperMethods.DeleteDirForTest();
	}
}
