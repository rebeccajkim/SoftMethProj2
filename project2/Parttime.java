package project2;

import java.text.DecimalFormat;

public class Parttime extends Employee {

	private double hours;
	private double hourlyRate;
	
	public Parttime(Profile profile, double hourlyRate) {
		super(profile);
		hours=0;
		this.hourlyRate=hourlyRate;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setHours(double hours) {
		this.hours=hours;
	}
	
	@Override 
	public void calculatePayment() { 
		double MAX_HOURS_PERIOD=80;
		double OVERTIME_RATE=1.5; //check in payrollprocessing or company that its not over 100 hours
		if(hours<=MAX_HOURS_PERIOD) {
			setPayment(getPayment()+hours*hourlyRate);
		}
		else {
			setPayment(getPayment()+MAX_HOURS_PERIOD*hourlyRate);
			setPayment(getPayment()+OVERTIME_RATE*(hours-MAX_HOURS_PERIOD)*hourlyRate);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fulltime) {
			Parttime parttime=(Parttime) obj;
			return parttime.getProfile().equals(this.getProfile());
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,##0.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::Payment $" + df.format(getPayment()) + "::PART TIME::Hourly Rate $" 
				+ df.format(hourlyRate) + "::Hours worked this period: " + hours;
	} 
}