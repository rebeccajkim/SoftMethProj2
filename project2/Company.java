package project2;

/**
The company class stores all the employees in an array-based list. These employees can 
be added, removed, checked out, have payments processed, and printed in a list.
@author mayeesha, rebecca
*/
public class Company {
	private Employee[] empList;
	private int numEmployee;
	
	/**
	Method used to help other methods find an employee in the employee list and 
	return the index of the employee in the employee list
	@param employee to find in the employee list
	@return index of employee in list, -1 if not found
	*/
	private int find(Employee employee) { 
		int count= 0;
		while(count<numEmployee) {
			if(empList[count].equals(empList)) {
				return count; //index in array not serial num
			}
			count++;
		}
		//return  count; //equals numEmployee
		return -1;
	}
	
	/**
	Helper method to grow the employee list capacity by 4 when the list is full
	*/
	private void grow() {
		int GROW_VAR = 4;
		Employee[] temp=new Employee[empList.length+GROW_VAR];
		for(int i=0; i<numEmployee; i++) {
			temp[i]=empList[i];
		}
		empList=temp;
	} 
	
	/**
	Method to add an employee to the employee list. Also, we grow the list capacity 
	when it's full and only add the employee if their profile is valid. 
	@param employee to be added
	*/
	public boolean add(Employee employee) { 
		if(employee.getDateHired().isValid()) {
			if(empList.length==numEmployee) { //list full
				grow();
			} 
			if(numEmployee==0) {
				empList[0] = employee; //all empty slots	
				return true;
			}
			else {
				int ptr=empList.length-1;
				while(empList[ptr]==null) { //first empty slot
					ptr--;
				}
				empList[ptr+1] = employee;
				
			}
			numEmployee++; //increase employee count
			return true;
		}
		return false;
	} 
	
	/**
	The method to remove an employee from the employee list. The employee is found using 
	the find method and the list maintains the current sequence of employee's after the 
	removal. If the employee is not in the company, the method returns false.
	@param employee to be removed
	@return true if successfully removed, false if employee not in company
	*/
	public boolean remove(Employee employee) { 
		int index = find(employee);
		if(index>-1) {
			for(int i=index; i<empList.length-1; i++) {
				empList[i] = empList[i+1];
			}
			if(numEmployee == empList.length) { //put a null space
				empList[empList.length-1] = null; 
			}
			numEmployee--;
			return true;
		}
		return false;
	}
	
	/**
	Method to set a part time employees working hours.
	@param part time employee's hours to be set
	*/
	public boolean setHours(Employee employee) {
		
	} 
	
	/**
	Method to process the payments for the employees in the company. This method is 
	to ensure that the employees receive their proper payments by processing them.
	(better description?) 
	*/
	public void processPayments() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	in the normal order from the employee list
	 */
	public void print() {
		if(numEmployee>0) {
			for(int i=0;i<numEmployee;i++) {
				System.out.println(empList[i].toString());
			}
		}
	} 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of their Department from the employee list
	 */
	public void printByDepartment() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of date from the employee list
	 */
	public void printByDate() { } 
	/**
	Getter method for numEmployee so it can be used in another classe
	@return numEmployee
	*/
	public int getnumEmployee() {
		return numEmployee;
	}
	
}