/**
 * ****************************************************************************
 * Purpose: This class is implemented for JUnit Test cases for files API
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 29-06-2021
 * ****************************************************************************
 */

package com.bridgelabz.EmployeePayroll;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {

	private static String HOME = "F:\\IOstream";
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		// Check file exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		// Delete File and Check File Not Exist
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath)) {
			FilesUtils.deleteFiles(playPath.toFile());
		}
		Assert.assertTrue(Files.notExists(playPath));

		// Create Directory
		Files.createDirectory(playPath);

		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		// List Files, Directories as well as Files with Extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}

}
