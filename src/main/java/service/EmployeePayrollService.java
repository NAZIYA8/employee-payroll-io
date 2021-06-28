/**
 * ****************************************************************************
 * Purpose: This class is implemented to read and write the employee payroll data 
 * 			to a file.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 29-06-2021
 * ****************************************************************************
 */

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.EmployeePayrollData;

public class EmployeePayrollService {
	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * This is the main method of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
	}

	/**
	 * This method is used to read the Employee payroll data.
	 * 
	 * @param consoleInputReader reads input from console
	 */
	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee id");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee name");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee salary");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	/**
	 * This method is used to write the employee payroll data to console
	 */
	private void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
	}
}
