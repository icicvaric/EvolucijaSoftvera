package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import cmd.CompareCommand;

class CompareCommandTest {

	@Test
	void CanInstantiateCompareCommand() {
		CompareCommand compareCommand = new CompareCommand();
		assertNotNull(compareCommand);
	}
	
	@Test
	void PerformCommandTest() throws IOException {
		CompareCommand compareCommand = new CompareCommand();
		
		assertThrows(IOException.class, () -> compareCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> compareCommand.PerformCommand("compare "));
		assertThrows(IOException.class, () -> compareCommand.PerformCommand("compare folder1"));
		assertThrows(IOException.class, () -> compareCommand.PerformCommand("compare folder1 folder2 folder3"));

		HelperMethods.CreateNonEmptyDirForTest();
		
		HelperMethods.CreateFileForTest();	
		// we cannot compare folder and file, only 2 folders can  be compared
		assertThrows(IOException.class, () ->compareCommand.PerformCommand("compare " + HelperMethods.fileName + " " + HelperMethods.folderName));	
		assertThrows(IOException.class, () ->compareCommand.PerformCommand("compare " + HelperMethods.folderName + " " + HelperMethods.fileName));			
		HelperMethods.DeleteFileForTest();
		
		HelperMethods.CreateDirForTest(HelperMethods.absPath1);
		
		String difference = compareCommand.GetDifference(new File(HelperMethods.absPath.toString()), new File(HelperMethods.absPath1.toString())).trim();
		assertTrue(difference != null);
		assertTrue(!difference.isEmpty());
		assertTrue(!difference.isBlank());
		assertEquals(HelperMethods.fileName, difference);
	
		HelperMethods.DeleteNonEmptyDirForTest();
		HelperMethods.DeleteDirForTest(HelperMethods.absPath1);
	}

}
