import java.text.DecimalFormat;
import java.util.*;
public class AdamBash
{
	public static void main(String[] args)
	{
		System.out.println("ADAM BASHFORTH METHOD");
		Scanner sc=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.####");
		System.out.println("Enter the no of terms: ");
		int n=sc.nextInt();
		int i=0;
		double lower,upper,h;
		double result;
		double xvalue[]=new double[n];
		double yvalue[]=new double[n];
		double function[]=new double[n+1];
		double search;
		System.out.println("Enter the lower bound of x: ");
		lower=sc.nextDouble();
		System.out.println("Enter the upper bound of x: ");
		upper=sc.nextDouble();
		System.out.println("Enter the value of h: ");
		h=sc.nextDouble();
		System.out.println("Enter the value of x for which you want to find y: ");
		search=sc.nextDouble();
		xvalue[i]=lower;
		for(int j=1;j<n;j++)
		{
			xvalue[j]=(xvalue[j-1]+h); 		 //used to calculate the range of x values
		}
		System.out.println("Enter the values of y: ");
		for(int j=0;j<n;j++)
		{
			yvalue[j]=sc.nextDouble();	        //used to accept y values		
		}
		sc.nextLine();                                 //used to accept endline character after number input
		System.out.println("Enter the equation: ");
		String eqn=sc.nextLine();   	              //used to accept string
		Convert c=new Convert(eqn);		     //used to convert infix expression to postfix
		//System.out.println(c.doTrans());
		Evaluate e=new Evaluate();		    //used to evaluate the postfix expression
		for(int j=0;j<n;j++)
		{
			function[j]=e.calculate(c.doTrans(),xvalue[j],yvalue[j]); //used to calculate y' values
		}
		System.out.println("y' values for the given equation "+eqn);
		for(int j=0;j<n;j++)
			System.out.println(df.format(function[j]));
		//ADAM BASHFORTH METHOD FORMULA 
		result=yvalue[3]+((h/24)*((55*function[3])-(59*function[2])+(37*function[1])-(9*function[0])));
		System.out.println("y4p: "+df.format(result));
		function[4]=e.calculate(c.doTrans(),search,result);
		System.out.println("y4': "+df.format(function[4]));
		result=yvalue[3]+((h/24)*((9*function[4])+(19*function[3])-(5*function[2])-(1*function[1])));
		System.out.println("y4c: "+df.format(result));
		
	}
		
}
