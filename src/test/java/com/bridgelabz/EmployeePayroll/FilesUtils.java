/**
 * ****************************************************************************
 * Purpose: This class is files utility class.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 29-06-2021
 * ****************************************************************************
 */

package com.bridgelabz.EmployeePayroll;

import java.io.File;

public class FilesUtils {

	/**
	 * This method is used to delete contents of files
	 * 
	 * @param contentsToDelete
	 * @return
	 */
	public static boolean deleteFiles(File contentsToDelete) {
		File[] allContents = contentsToDelete.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteFiles(file);
			}
		}
		return contentsToDelete.delete();
	}
}
