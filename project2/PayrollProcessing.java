package project2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
The PayrollProcessing class is used to run all the commands in the company. Based on 
the input commands, the PayrollProcessing class uses the company methods as needed 
to add, remove, calculate payments, set working hours, and print earning statements 
from the employee list. This class also handles exceptions from the user input.
@author mayeesha, rebecca
*/
public class PayrollProcessing {
	
	//..
	private Company company; 
	/**
	Method to run the Company so that the company can add, 
	remove, calculate payments, set working hours, as well 
	as display earning statements from the list of employees 
	by order of date hired or the employees' department.
	 */
	public void run() {
		
		System.out.println("Payroll Processing starts.");
		Scanner scanner=new Scanner(System.in);
		String line=scanner.nextLine();
		company = new Company();
		//try {
		while(!line.equals("Q")) {
			StringTokenizer st=new StringTokenizer(line," ",false);
			String command=st.nextToken(); 
		
			if(command.equals("AP")) { //part-time employee w hourly pay rate
			String name = st.nextToken();
			String depCode = st.nextToken();
			String date = st.nextToken();
			Date datePublished = new Date(date);
			Employee employee = new Employee(name, depCode, datePublished);
			String moneyEarned = st.nextToken();
			if((depCode.equals("CS")) || (depCode.equals("ECE")) || (depCode.equals("IT"))) {
			    //call add method here and also check if employee already exists or not
				if(company.add(employee)) {
					System.out.println("Employee added.");
				} else {
					System.out.println("Employee already in the list.");
				}
			} else {
				System.out.println("'" + depCode + "' is not a valid department code.");
			}
			
			} else if(command.equals("AF")) { //full-time employee w annual salary
				
			} else if(command.equals("AM")) { //full-time employee w diff roles
				
			} else if(command.equals("R")) { //remove employee
				
			} else if(command.equals("C")) { //calculate payments
				
			} else if(command.equals("S")) { //set hours for employee
				
			} else if(command.equals("PA")) { //earnings for all employees
				int NUM_EMPLOYEE = company.getnumEmployee();
				if(NUM_EMPLOYEE > 0) {
				System.out.println("--Printing earning statements for all employees--");
				company.print();
				} else {
					System.out.println("Employee database is empty");
				}	
				
			} else if(command.equals("PH")) { //earnings by date hired
				
			} else if(command.equals("PD")) { //earnings grouped by department
				
			} else {
				System.out.println("Command '" + command + "' is not supported!");
			}
			line = scanner.nextLine();	
		 }
		System.out.println("Payroll Processing completed."); //quit
		scanner.close();
		//} catch (Exception e) {
			//  System.out.println("Exception error! Please recheck input!");
		//	}
		
		
	}
}
