import java.util.*;
class LongestCommonSub	{
	public static void main(String[] args) {
		Scanner aa = new Scanner(System.in);
		System.out.println("Enter two string");
		String str1, str2;
		str1 = aa.next();
		str2 = aa.next();	
		System.out.println("Length is: "+lcs(str1, str2));
		aa.close();
	}

	static int lcs( String str1, String str2) 	{ 
		
		int m = str1.length();
		int n = str2.length();
		char X[] = str1.toCharArray();
		char Y[] = str2.toCharArray();
		String b[][] = new String[m+1][n+1];
		int c[][] = new int[m+1][n+1];
		int i=0,j=0;

		for(i=0; i<m; i++)	{
			c[i][0] = 0;
		}
		for(i=0; i<n; i++)	{
			c[0][i] = 0;
		}	
		int max = 0;
		for(i=1; i<=m; i++)	{
			for(j=1; j<=n; j++)	{
				if(X[i-1] == Y[j-1])	{
					c[i][j] = c[i-1][j-1] + 1;
					if(c[i][j]>max)
						max = c[i][j];
					b[i][j] = "!";
				}
				else if(c[i-1][j] >= c[i][j-1])	{
					c[i][j] = c[i-1][j];
					b[i][j] = "^";
				}
				else	{
					c[i][j] = c[i][j-1];
					b[i][j] = "<";
				}
			}
		}
		printLCS(b, X, i-1, j-1);
		return max;
	} 

	public static void printLCS(String b[][], char[] X, int i, int j)	{
		if(i==0 || j==0)
			return;
		if(b[i][j].equals("!"))	{
			printLCS(b, X, i-1, j-1);
			System.out.print(X[i-1]);
		}
		else if(b[i][j].equals("^"))	{
			printLCS(b, X, i-1, j);
		}
		else	{
			printLCS(b, X, i-1, j);
		}
	}
}