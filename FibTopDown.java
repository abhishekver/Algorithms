import java.util.*;

public class FibTopDown{

	public static int fibTopDown(int n, int [] fib) {
		if(n==0) 
			return 0;
		if(n==1) 
			return 1;
		
		if(fib[n]!=0)	{
			return fib[n];
		}
		else	{
			fib[n] = fibTopDown(n-1, fib) + fibTopDown(n-2, fib);
			return fib[n];
		}
	}
	public static void main(String[] args){
		Scanner aa = new Scanner(System.in);
		System.out.println("Enter the number of terms");
		int n = aa.nextInt();
		aa.close(); 

		int [] fib = new int[n+1];
		System.out.println("n'th term is:"+fibTopDown(n, fib));
	}
}