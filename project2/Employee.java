package project2;

/**
The employee class holds all the main attributes of an employee. 
(add more after i understand more LOL)...
@author mayeesha, rebecca
*/
public class Employee {
	//not sure what other instance variables to add for an employee
	private Profile profile; 
	private double payment;

	public Employee(Profile profile) {
		this.profile=profile;
		payment=0;
	}
	
	public Profile getProfile() { //**idk but did this in book for date ig
		return profile;
	}
	
	public double getPayment() { //***********payment in employee or full/part wtff - and when add, is it employee or full/part
		return payment;
	}
	
	public void setPayment(double payment) {
		this.payment=payment;
	}
		
	/**
	This method calculates te payments for an employee, keeping 
	in mind the total hours they worked. (fix if im wrong later...)
	 */
	public void calculatePayment() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee=(Employee) obj;
			return employee.profile.equals(this.profile);
		}
		return false;
	}
	
	@Override  
	public String toString() { 
		return profile.toString();
	} 
}