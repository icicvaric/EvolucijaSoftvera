package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import cmd.DirCommand;

class DirCommandTest {

	@Test
	void CanInstantiateDirCommand() {
		DirCommand dirCommand = new DirCommand();
		assertNotNull( dirCommand );
	}
	
	@Test
	void PerformCommandTest() {
		DirCommand dirCommand = new DirCommand();
		
		assertThrows(IOException.class, () -> dirCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> dirCommand.PerformCommand("dir"));
		assertThrows(IOException.class, () -> dirCommand.PerformCommand("dir folder1 folder2"));
		
		assertDoesNotThrow( () -> dirCommand.PerformCommand("dir ."));
	}
	
	@Test
	void GetFileNamesTest()
	{
		DirCommand dirCommand = new DirCommand();
		
		HelperMethods.CreateNonEmptyDirForTest();
		String fileNames = dirCommand.GetFileNamesTest("dir temp");
		assertEquals(HelperMethods.fileName, fileNames);
		HelperMethods.DeleteDirForTest();
		
		HelperMethods.CreateDirForTest();
		fileNames = dirCommand.GetFileNamesTest("dir temp");
		assertEquals("", fileNames);
		HelperMethods.DeleteDirForTest();
		
		HelperMethods.CreateFileForTest();
		fileNames = dirCommand.GetFileNamesTest("dir " + HelperMethods.fileName);
		assertEquals("", fileNames);
		HelperMethods.DeleteFileForTest();
	}
}
