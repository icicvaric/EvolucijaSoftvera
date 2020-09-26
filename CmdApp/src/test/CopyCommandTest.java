package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import cmd.CopyCommand;

class CopyCommandTest {

	@Test
	void CanInstantiateCopyCommand() {
		CopyCommand copyCommand = new CopyCommand();
		assertNotNull(copyCommand);
	}
	
	@Test
	void PerformCommandTest() throws IOException {
		CopyCommand copyCommand = new CopyCommand();
		
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("copy "));
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("copy folder1"));
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("copy folder1 folder2 folder3"));

		HelperMethods.CreateDirForTest();
		HelperMethods.CreateFileForTest();		
		copyCommand.PerformCommand("copy " + HelperMethods.fileName + " " + HelperMethods.folderName);				
		// check if file is still on old location
		assertTrue( Files.isReadable(HelperMethods.fileAbsPath));
		// check if file is on new location
		assertTrue( Files.isReadable(HelperMethods.absPath.resolve(HelperMethods.fileName)));
		
		// we cannot copy something to file
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("copy " + HelperMethods.folderName + " " + HelperMethods.fileName));	
		// we cannot copy folder that doesn't exist
		assertThrows(IOException.class, () -> copyCommand.PerformCommand("copy " + "FolderThatDoesntExist" + " " + HelperMethods.folderName));
		
		HelperMethods.CreateDirForTest(HelperMethods.absPath1);
		copyCommand.PerformCommand("copy " + HelperMethods.folderName1 + " " + HelperMethods.folderName);
		// check if folder is still on old location
		assertTrue( Files.isReadable(HelperMethods.absPath1));
		// check if folder is on new location
		assertTrue( Files.isReadable(HelperMethods.absPath.resolve(HelperMethods.folderName1)));			
		
		HelperMethods.DeleteNonEmptyDirForTest();
		HelperMethods.DeleteFileForTest();
	}
}
