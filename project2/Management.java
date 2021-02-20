package project2;

import java.text.DecimalFormat;

public class Management extends Fulltime {
	
	private String role;
	private double additionalComp;
	
	public Management(String name, String department, String date, double annualSalary, String role) {
		super(name, department, date, annualSalary);
		this.role=role;
		if(role.equals("Manager")) {
			additionalComp=192.31;
		}
		else if(role.equals("Department Head")) {
			additionalComp=365.38;
		}
		else { //Director
			additionalComp=461.54;
		}
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	
	@Override 
	public void calculatePayment() { 
		super.calculatePayment();
		payment=payment+additionalComp;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Management) {
			Management management=(Management) obj;
			return management.profile.equals(this.profile);
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,000.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::" + role + " Compensation $" 
				+ df.format(additionalComp); 
	} 
}