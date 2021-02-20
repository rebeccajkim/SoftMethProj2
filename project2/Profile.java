package project2;

public class Profile {
	
	private String name;//employee's name in the form "lastname, firstname"
	private String department; //department code CS, ECE, IT
	private Date dateHired;
	
	public Profile(String name, String department, String date) {
		this.name=name;
		this.department=department;
		dateHired=new Date(date);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	/**
	Getter method for date hired of the employee so it can be used in other 
	classes
	@return date hired
	*/
	public Date getDateHired() {
		return dateHired;
	}
	
	/**
	Setter method for the name of the employee so the value can be set 
	in other  classes
	@param employee name
	*/
	public void setName(String name) {
		this.name=name;
	}
	/**
	Setter method for the department code so that the value can be set
	in other classes
	@param department code
	*/
	public void setDepartment(String department) {
		this.department=department;
	}
	/**
	Setter method for the date an employee joined so the value can be set
	in other classes
	@param date when employee joined
	*/
	public void setDate(Date dateHired) {
		this.dateHired=dateHired;
	}
	
	@Override
	public String toString() {
		return name + "::" + department + "::" + dateHired.getMonth() + "/" + dateHired.getDay() + "/" + dateHired.getYear();
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Profile) {
			Profile profile=(Profile) obj;
			if(profile.name.equals(this.name) && profile.department.equals(this.department) && profile.dateHired.getYear()==this.dateHired.getYear()
					&& profile.dateHired.getMonth()==this.dateHired.getMonth() && profile.dateHired.getDay()==this.dateHired.getDay()) {
				return true;
			}
			return false;
		}
		return false;
	}
}