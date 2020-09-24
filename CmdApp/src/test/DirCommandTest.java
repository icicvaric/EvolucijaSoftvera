package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
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
	void GetFileNamesTest() throws IOException
	{
		DirCommand dirCommand = new DirCommand();
		
		HelperMethods.CreateNonEmptyDirForTest();
		String fileNames = dirCommand.GetFileNamesTest("temp");
		assertEquals(HelperMethods.fileName + System.lineSeparator(), fileNames);
		HelperMethods.DeleteNonEmptyDirForTest();
		
		HelperMethods.CreateDirForTest();
		fileNames = dirCommand.GetFileNamesTest("temp");
		assertEquals("", fileNames);
		HelperMethods.DeleteDirForTest();
		
		HelperMethods.CreateFileForTest();
		fileNames = dirCommand.GetFileNamesTest(HelperMethods.fileName);
		assertEquals("", fileNames);
		HelperMethods.DeleteFileForTest();
	}
}
