package project2;

import java.text.DecimalFormat;

public class Fulltime extends Employee {
	
	protected double annualSalary;
	
	public Fulltime(Profile profile, double annualSalary) {
		super(profile);
		this.annualSalary=annualSalary;
	}
	
	@Override 
	public void calculatePayment() { 
		double PAY_PERIODS=26;
		setPayment(getPayment()+(annualSalary/PAY_PERIODS));
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fulltime) {
			Fulltime fulltime=(Fulltime) obj;
			return fulltime.getProfile().equals(this.getProfile());
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,##0.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::Payment $" + df.format(getPayment()) + "::FULL TIME::Annual Salary $" 
				+ df.format(annualSalary);
	} 
}