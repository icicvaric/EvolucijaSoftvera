package test;

import java.io.IOException;
import java.nio.file.*;

public class HelperMethods {
	
	private static Path absPath = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve("temp");
	
	public static void CreateDirForTest() throws IOException
	{
		Files.createDirectory(absPath);
	}
	
	public static void DeleteDirForTest() throws IOException
	{
		Files.delete(absPath);
	}

}
