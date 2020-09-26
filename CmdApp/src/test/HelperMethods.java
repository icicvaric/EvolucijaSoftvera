package test;

import java.io.IOException;
import java.nio.file.*;

import org.apache.commons.io.FileUtils;

public class HelperMethods {
	
	public static String fileName = "file.txt";
	public static String folderName = "temp";
	public static String folderName1 = "temp1";
	public static Path absPath = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve(folderName);
	public static Path absPath1 = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve(folderName1);
	public static Path fileAbsPath = Paths.get(System.getProperty("user.dir").toString()).toAbsolutePath().resolve(fileName);

	public static void CreateDirForTest() throws IOException
	{
		Files.createDirectory(absPath);
	}
	
	public static void CreateDirForTest(Path path) throws IOException
	{
		Files.createDirectory(path);
	}
	
	public static void DeleteDirForTest() throws IOException
	{
		Files.delete(absPath);
	}
	
	public static void DeleteDirForTest(Path path) throws IOException
	{
		Files.delete(path);
	}
	
	public static void CreateFileForTest() throws IOException 
	{
		Files.createFile(fileAbsPath);
	}
	
	public static void DeleteFileForTest() throws IOException
	{
		Files.delete(fileAbsPath);
	}
	
	public static void CreateNonEmptyDirForTest() throws IOException
	{
		Files.createDirectory(absPath);
		Files.createFile(absPath.resolve(fileName));
	}
	
	public static void DeleteNonEmptyDirForTest() throws IOException
	{
		FileUtils.deleteDirectory(absPath.toFile());
	}

}
