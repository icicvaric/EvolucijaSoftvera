package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import cmd.CdCommand;

class CdCommandTest {

	@Test
	void CanInstantiateCdCommand() {
		CdCommand cdCommand = new CdCommand();
		assertNotNull(cdCommand);
	}
	
	@Test
	void PerformCommandTest() throws IOException {
		CdCommand cdCommand = new CdCommand();
		
		assertThrows(IOException.class, () -> cdCommand.PerformCommand("  "));
		assertThrows(IOException.class, () -> cdCommand.PerformCommand("cd"));
		assertThrows(IOException.class, () -> cdCommand.PerformCommand("cd folder1 folder2"));

		String userDir = System.getProperty("user.dir");
		cdCommand.PerformCommand("cd ..");
		assertEquals(Paths.get(userDir).getParent().toString(), System.getProperty("user.dir"));		
		System.setProperty("user.dir", userDir);
		
		HelperMethods.CreateDirForTest();
		cdCommand.PerformCommand("cd temp");
		assertEquals(Paths.get(userDir).resolve("temp").toString(), System.getProperty("user.dir"));
		System.setProperty("user.dir", userDir);
		HelperMethods.DeleteDirForTest();
		
		cdCommand.PerformCommand("cd unkonwn");
		assertEquals(userDir, System.getProperty("user.dir"));
	}

}
