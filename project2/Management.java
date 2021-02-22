package project2;

import java.text.DecimalFormat;

public class Management extends Fulltime {
	
	private String role;
	private double additionalComp;
	
	public Management(Profile profile, double annualSalary, String role) {
		super(profile, annualSalary);
		this.role=role;
		if(role.equals("Manager")) {
			additionalComp=192.31; //5,000/26
		}
		else if(role.equals("Department Head")) {
			additionalComp=365.38; //9,500/26
		}
		else { //Director
			additionalComp=461.54; //12,000/26
		}
	}
	
	@Override 
	public void calculatePayment() { 
		super.calculatePayment();
		setPayment(getPayment()+additionalComp);
	} 
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Management) {
			Management management=(Management) obj;
			return management.getProfile().equals(this.getProfile());
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,##0.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::" + role + " Compensation $" 
				+ df.format(additionalComp); 
	} 
}