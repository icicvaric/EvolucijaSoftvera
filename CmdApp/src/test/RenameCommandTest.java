package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import cmd.RenameCommand;

class RenameCommandTest {

	@Test
	void CanInstantiateRenameCommand() {
		RenameCommand renameCommand = new RenameCommand();
		assertNotNull(renameCommand);
	}

	@Test
	void PerformCommandTest() throws IOException {
		RenameCommand renameCommand = new RenameCommand();
		
		assertThrows(IOException.class, () -> renameCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> renameCommand.PerformCommand("rename"));
		assertThrows(IOException.class, () -> renameCommand.PerformCommand("rename folder1"));

		HelperMethods.CreateDirForTest();
		
		assertTrue(Files.isDirectory(HelperMethods.absPath));	
		renameCommand.PerformCommand("rename " + HelperMethods.folderName + " " + "temp1");
		assertFalse(Files.isDirectory(HelperMethods.absPath));
		assertTrue(Files.isDirectory(Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve("temp1")));
		renameCommand.PerformCommand("rename " + "temp1" + " " + HelperMethods.folderName);
		
		HelperMethods.DeleteDirForTest();
	}
}
