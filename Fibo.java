import java.lang.ref.Cleaner;
import java.util.*;

public class Fibo{
	public static int fibonacci(int x) {
			if (x == 0)
				return 0;
			if (x == 1)
				return 1;
			else {
				int f = fibonacci(x - 1) + fibonacci(x - 2);
				return f;
			}
		}
	public static void main(String[] args){
		Scanner aa = new Scanner(System.in);
		System.out.println("Enter the number of terms");
		int a = aa.nextInt(); 
		aa.close();

		int b = fibonacci(a);
		System.out.println("n'th term is: "+b);

	}
}