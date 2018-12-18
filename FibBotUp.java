import java.util.Scanner;

public class FibBotUp	{
	public static int fibDP(int x) {
		int fib[] = new int[x + 1];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for (int i = 2; i < x + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[x];
	}
	public static void main(String[] args){
		Scanner aa = new Scanner(System.in);
		System.out.println("Enter the number of terms");
		int a = aa.nextInt();
		aa.close();
		System.out.println("n'th term is: "+fibDP(a));
	}
}