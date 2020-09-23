package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import cmd.*;

class DeleteCommandTest {

	@Test
	void CanInstantiateDeleteCommand() {
		DeleteCommand deleteCommand = new DeleteCommand();
		assertNotNull(deleteCommand);
	}
	
	@Test
	void PerformCommandTest() throws IOException {
		DeleteCommand deleteCommand = new DeleteCommand();
		
		assertThrows(IOException.class, () -> deleteCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> deleteCommand.PerformCommand("delete"));
		assertThrows(IOException.class, () -> deleteCommand.PerformCommand("delete folder1 folder2"));

		HelperMethods.CreateDirForTest();		
		assertTrue(Files.exists( HelperMethods.absPath));
		deleteCommand.PerformCommand("delete " + HelperMethods.absPath);
		assertFalse(Files.exists( HelperMethods.absPath));
		
		HelperMethods.CreateFileForTest();		
		assertTrue(Files.exists( HelperMethods.fileAbsPath));
		deleteCommand.PerformCommand("delete " + HelperMethods.fileAbsPath);
		assertFalse(Files.exists( HelperMethods.fileAbsPath));
		
		HelperMethods.CreateNonEmptyDirForTest();		
		assertTrue(Files.exists( HelperMethods.fileAbsPath));
		assertTrue(Files.exists( HelperMethods.fileAbsPath.resolve(HelperMethods.fileName) ) );
		deleteCommand.PerformCommand("delete " + HelperMethods.fileAbsPath);
		assertFalse(Files.exists( HelperMethods.fileAbsPath));
	}
}
