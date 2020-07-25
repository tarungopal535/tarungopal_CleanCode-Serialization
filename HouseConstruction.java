
package house;

/**
 * @author TARUN GOPAL
 *
 */
import java.util.*;
import java.io.IOException;

/*
 * Estimator class
 * which estimates the cost based on 
 * the chosen material and standard 
 * and for the given area of the land
 */
class Estimate{
	int material;
	double area;
	// default rates per square feet for different materials
	int []rate = new int[] {1200,1500,1800,2500};
	/* 1200 -->Standard material
	 * 1500 --->above standard
	 * 1800---->high standard
	 * 2500---->high standard with automation
	 */
	Estimate(int m,double a){
		material =m;
		area=a;
	}
	/*
	 * calculateCost method
	 * returns cost required for construction 
	 */
	double calculateCost() {
		return area*rate[material-1];
		
	}
}
public class HouseConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException
	{
		//importing Scanner class
		Scanner sc = new Scanner(System.in);
		
		//ask the client the type of material to be used for construction
		System.out.format("%s\n","Choose one from the given standards\n1.Standard material\n2.Above Standard material\n3.High Standard material\n");
		int material = sc.nextInt();
		
		System.out.format("Enter the area ofland(in sq feet : )");
		
		//Give the Area of the land
		double area = sc.nextDouble();
		
		if(material==3) {
			/*if chosen material is of high standard
			 * we again provide two choices for client
			 * -->client choice may be 
			 * fully automated house 
			 * or not automated house 
			 * 
			 */
			System.out.format("Do you want fully automated home?[y/n]");
			char choice = sc.next().charAt(0);
			if(choice=='Y'||choice=='y') {
				material = 4;
			}
			
		}
		//Estimate the cost for construction of house
		Estimate estimatecost = new Estimate(material,area);
		//get the cost from estimator 
		double cost = estimatecost.calculateCost();
		
		System.out.format("Your House Construction Estimation cost is :");
		//output the cost estimation to the client rounded up to 2 decimals
		System.out.format("%.2f\n", cost);

	}

}
