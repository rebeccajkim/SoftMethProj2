package project2;

import java.text.DecimalFormat;

public class Fulltime extends Employee {
	
	protected double annualSalary;
	
	public Fulltime(String name, String department, String date, double annualSalary) {
		super(name, department, date);
		this.annualSalary=annualSalary;
	}
	
	@Override 
	public void calculatePayment() { 
		double PAY_PERIODS=26;
		payment=payment+(annualSalary/PAY_PERIODS);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fulltime) {
			Fulltime fulltime=(Fulltime) obj;
			return fulltime.profile.equals(this.profile) {
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,000.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::Payment" + df.format(payment) + "::FULL TIME::Annual Salary $" 
				+ df.format(annualSalary);
	} 
}