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
	public void run() { //***exceptions
		
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
				double hourlyRate = Double.parseDouble(st.nextToken());
				Profile profile=new Profile(name, depCode, date);
				Parttime parttime=new Parttime(profile, hourlyRate); //**idk if employee or parttime
				if(!(depCode.equals("CS") || depCode.equals("ECE") || depCode.equals("IT"))) {
					System.out.println("'" + depCode + "'" + " is not a valid department code.");
				}
				else if(!parttime.getProfile().getDateHired().isValid()) {
					System.out.println(date + " is not a valid date!");
				}
				else {
					if(company.add(parttime)) {
						System.out.println("Employee added.");
					}
					else {
						System.out.println("Employee already in the list.");
					}
				} 		
			} 
			else if(command.equals("AF")) { //full-time employee w annual salary
				String name = st.nextToken();
				String depCode = st.nextToken();
				String date = st.nextToken();
				double annualSalary = Double.parseDouble(st.nextToken());
				Fulltime fulltime=new Fulltime(new Profile(name, depCode, date), annualSalary);
				if(!(depCode.equals("CS") || depCode.equals("ECE") || depCode.equals("IT"))) {
					System.out.println("'" + depCode + "'" + " is not a valid department code.");
				}
				else if(!fulltime.getProfile().getDateHired().isValid()) {
					System.out.println(date + " is not a valid date!");
				}
				else {
					if(company.add(fulltime)) {
						System.out.println("Employee added.");
					}
					else {
						System.out.println("Employee already in the list.");
					}
				} 		
			} 
			else if(command.equals("AM")) { //full-time employee w diff roles
				String name = st.nextToken();
				String depCode = st.nextToken();
				String date = st.nextToken();
				double annualSalary = Double.parseDouble(st.nextToken());
				int intCode = Integer.parseInt(st.nextToken());
				int MANAGER_CODE=1;
				int DEPARTMENT_HEAD_CODE=2;
				int DIRECTOR_CODE=3;
				Management management=new Management(new Profile(name, depCode, date), annualSalary, "");
				if(intCode==MANAGER_CODE) {
					management.setRole("Manager");
				}
				else if(intCode==DEPARTMENT_HEAD_CODE) {
					management.setRole("Department Head");
				}
				else if(intCode==DIRECTOR_CODE) {
					management.setRole("Director");
				}
				else {
					System.out.println("Invalid management code.");
				}
				if(!(depCode.equals("CS") || depCode.equals("ECE") || depCode.equals("IT"))) {
					System.out.println("'" + depCode + "'" + " is not a valid department code.");
				}
				else if(!management.getProfile().getDateHired().isValid()) { 
					System.out.println(date + " is not a valid date!");
				}
				else {
					if(company.add(management)) {
						System.out.println("Employee added.");
					}
					else {
						System.out.println("Employee already in the list.");
					}
				} 		
			} 
			else if(command.equals("R")) { //remove employee
				String name=st.nextToken();
				String depCode=st.nextToken();
				String date=st.nextToken();
				Employee employee=new Employee(new Profile(name, depCode, date));
				if(company.remove(employee)) {
					System.out.println("Employee removed.");
				}
				else {
					System.out.println("Employee does not exist.");
				}
			} 
			else if(command.equals("C")) { //calculate payments
				company.processPayments());
				System.out.println("Calculation of employee payments is done.");
			}  
			else if(command.equals("S")) { //set hours for employee
				String name=st.nextToken();
				String depCode=st.nextToken();
				String date=st.nextToken();
				double hours=Double.parseDouble(st.nextToken());
				Parttime parttime=new Parttime(new Profile(name, depCode, date), 0);
				parttime.setHours(hours);
				if(hours<0) {
					System.out.println("Working hours cannot be negative.");
				}
				else if(hours>100) {
					System.out.println("Invalid Hours: over 100.");
				}
				else {
					if(company.setHours(parttime)) {
						System.out.println("Working hours set.");
					} //no print for if employee doesnt exist or isnt parttime
				}
			} 
			
			else if(command.equals("PA")) { //earnings for all employees
				company.print();
				
			} 
			else if(command.equals("PD")) { //earnings grouped by department
				company.printByDepartment();
			} 
			else if(command.equals("PH")) { //earnings by date hired
				company.printByDate();
			} 
			else {
				System.out.println("Command '" + command + "' is not supported!");
			}
			line = scanner.nextLine();	
		 }
		System.out.println("Payroll Processing completed."); //quit
		scanner.close();		
	}
}
