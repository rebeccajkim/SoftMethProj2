package project2;

import java.text.DecimalFormat;

public class Parttime extends Employee {
	
	private double payment;
	private int hours;
	private double hourlyRate;
	
	public Parttime(String name, String department, String date, double hourlyRate) {
		super(name, department, date);
		payment=0;
		hours=0;
		this.hourlyRate=hourlyRate;
	}
	
	public void setHours(int hours) {
		this.hours=hours;
	}
	
	@Override 
	public void calculatePayment() { 
		int MAX_HOURS_PERIOD=80;
		int OVERTIME_RATE=1.5; //check in payrollprocessing or company that its not over 100 hours
		if(hours<=MAX_HOURS_PERIOD) {
			payment=payment+hours*hourlyRate;
		}
		else {
			payment=payment+MAX_HOURS_PERIOD*hourlyRate;
			payment=payment+OVERTIME_RATE*(hours-MAX_HOURS_PERIOD)*hourlyRate;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fulltime) {
			Parttime parttime=(Parttime) obj;
			return parttime.profile.getName().equals(this.profile.getName());
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,000.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::Payment" + df.format(payment) + "::PART TIME::Hourly Rate $" 
				+ df.format(hourlyRate) + "::Hours worked this period: " + hours;
	} 
}