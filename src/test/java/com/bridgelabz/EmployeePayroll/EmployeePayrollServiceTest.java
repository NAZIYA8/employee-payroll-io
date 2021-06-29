/**
 * ****************************************************************************
 * Purpose: This class is implemented to test when given employees are written to 
 * 			file is matching with employee entries.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 29-06-2021
 * ****************************************************************************
 */

package com.bridgelabz.EmployeePayroll;

import org.junit.Assert;
import org.junit.Test;
import model.EmployeePayrollData;
import service.EmployeePayrollService;
import java.util.Arrays;

public class EmployeePayrollServiceTest {

	@Test
	public void given3Employee_whenWrittenToFile_shouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
				new EmployeePayrollData(2, "Bill Gates", 200000.0),
				new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}
