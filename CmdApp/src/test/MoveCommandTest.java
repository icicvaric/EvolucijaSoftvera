package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import cmd.MoveCommand;

class MoveCommandTest {

	@Test
	void CanInstantiateMoveCommand() {
		MoveCommand moveCommand = new MoveCommand();
		assertNotNull( moveCommand );
	}

	@Test
	void PerformCommandTest() throws IOException {
		MoveCommand moveCommand = new MoveCommand();
		
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move "));
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move folder1"));
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move folder1 folder2 folder3"));

		HelperMethods.CreateDirForTest();
		HelperMethods.CreateFileForTest();		
		moveCommand.PerformCommand("move " + HelperMethods.fileName + " " + HelperMethods.folderName);				
		// check if file is deleted from old location
		assertFalse( Files.isReadable(HelperMethods.fileAbsPath));
		// check if file is on new location
		assertTrue( Files.isReadable(HelperMethods.absPath.resolve(HelperMethods.fileName)));
		
		// we cannot move something to file
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move " + HelperMethods.folderName + " " + HelperMethods.fileName));	
		// we cannot move folder that doesn't exist
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move " + "FolderThatDoesntExist" + " " + HelperMethods.folderName));
		// we cannot move current working directory
		assertThrows(IOException.class, () -> moveCommand.PerformCommand("move " + System.getProperty("user.dir") + " " + HelperMethods.folderName));
				
		HelperMethods.CreateDirForTest(HelperMethods.absPath1);
		moveCommand.PerformCommand("move " + HelperMethods.folderName1 + " " + HelperMethods.folderName);
		// check if folder is deleted from old location
		assertFalse( Files.isReadable(HelperMethods.absPath1));
		// check if folder is on new location
		assertTrue( Files.isReadable(HelperMethods.absPath.resolve(HelperMethods.folderName1)));			
		
		HelperMethods.DeleteNonEmptyDirForTest();
	}
}
