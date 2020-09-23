package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class HelperMethods {
	
	public static String fileName = "file.txt";
	public static Path absPath = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve("temp");
	public static Path fileAbsPath = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve(fileName);

	public static void CreateDirForTest() throws IOException
	{
		Files.createDirectory(absPath);
	}
	
	public static void DeleteDirForTest() throws IOException
	{
		Files.delete(absPath);
	}
	
	public static void CreateFileForTest() 
	{
		new File(fileAbsPath.toString());
	}
	
	public static void DeleteFileForTest()
	{
		new File(fileAbsPath.toString()).delete();
	}
	
	public static void CreateNonEmptyDirForTest() throws IOException
	{
		Files.createDirectory(absPath);
		new File( absPath.toString() + File.pathSeparator + fileName);
	}

}
