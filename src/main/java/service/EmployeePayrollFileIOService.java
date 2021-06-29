/**
 * ****************************************************************************
 * Purpose: This class is Employee Payroll File IO Service.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 29-06-2021
 * ****************************************************************************
 */

package service;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.EmployeePayrollData;

public class EmployeePayrollFileIOService {

	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	/**
	 * This method is used to write data
	 */
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to count the entries to ensure the operation worked
	 * 
	 * @return entries
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}
