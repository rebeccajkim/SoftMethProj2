package project2;

import java.text.DecimalFormat;

public class RunProject2 {
	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat("###,000.00"); 
		double d=333.277;
		System.out.println(df.format(d));
		//new PayrollProcessing().run();
	}
}