package house;
/*
 * program to find Simple Interest and Compound Interest 
 */

import java.util.*;

/*
 * interface Interest 
 * it provides abstraction to calculateInterest
 */
interface Interest{
	void calculateInterest(double principal,double timeperiod,double rateofinterest);
}
/*
 * interface PrintData
 * it provides abstraction to print Data
 */
interface PrintData{
	void printData();
}
class ReadData{
	double getData(){
		//clear Scanner object
		Scanner sc = new Scanner(System.in);
		double value = sc.nextDouble();
		return value;// returns the read double value
	}
}
class SimpleInterest implements Interest,PrintData{
	
	private double finalInterest = 0.0;
	/*
	 * method to calculate simple interest
	 * it takes principal timeperiod,rateofinterest as paramaters.
	 * 
	 */
	public void calculateInterest(double principal,double timeperiod,double rateofinterest)
	{
		finalInterest = (principal*timeperiod*rateofinterest)/100;
		/*
		 * SI = (p*T*R)/100
		 * 
		 */
	}
	/*
	 * prints the calculated simple interest on the screen
	 */
	public void printData(){
		System.out.format("Simple Interest :%.3f\n",finalInterest);
	}
}
class CompoundInterest implements Interest,PrintData{
	private double finalInterest =0.0;
	/*
	 * method to calculate compound interest
	 * it takes principal time period,rateofinterest as parameters.
	 * 
	 */
	public void calculateInterest(double p,double t,double r)
	{
		finalInterest = p*Math.pow((1+r/100),t) - p;
	}
	
	/*
	 * prints the calculated compound interest on the screen
	 */
	public void printData(){
		System.out.format("Compound Interest :%.3f\n",finalInterest);
	}
}
//Driver class
public class SimpleAndCompoundInterest {

	public static void main(String[] args) {
		// create ReadData object
		ReadData rd = new ReadData();
		System.out.format("Enter the Principal Amount : ");
		//Reading the Principal Amount
		double principal = rd.getData();
		//Reading the Tenure 
		System.out.format("\nEnter the Time period(in Years : ");
		double timePeriod = rd.getData();
		
		System.out.format("\nEnter the Rate Of Interest : ");
		//Reading the Rate Of Interest 
		double rate = rd.getData();
		
		SimpleInterest si = new SimpleInterest();
		//Get SimpleInterest
		si.calculateInterest(principal,timePeriod,rate);
		si.printData();
		
		CompoundInterest ci = new CompoundInterest();
		//Get CompoundInterest
		ci.calculateInterest(principal,timePeriod,rate);
		ci.printData();

	}

}
