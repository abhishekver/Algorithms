import java.util.*;
class MatrixChain	{

	static int ch = 65;
	public static void main(String[] args)	{
		
		Scanner aa = new Scanner (System.in);
		System.out.println("Enter number of dimensions");
		int n = aa.nextInt();
		int dims[] = new int[n];
		int i;
		System.out.println("Enter dimensions");
		for(i=0; i<n; i++)	{
			dims[i] = aa.nextInt();
		}

		aa.close();

		System.out.println("\nDimensions are: ");
		for(i=0; i<n-1; i++)	{
			System.out.println("\t"+dims[i] + "x" + dims[i+1]);
		}

		int min = MatrixChainMultiplication(dims, 0, dims.length-1 );
		System.out.println("\nMinimum cost is: "+min);

		MatrixChainOrder(dims, dims.length);

	}

	public static int MatrixChainMultiplication(int[] dims, int i, int j)	{
        if (j <= i + 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k <= j - 1; k++)	{
			
			// recurse for M[i+1]..M[k] to get a i x k matrix
            int cost = MatrixChainMultiplication(dims, i, k);

            // recurse for M[k+1]..M[j] to get a k x j matrix
            cost += MatrixChainMultiplication(dims, k, j);

            // cost to multiply two (i x k) and (k x j) matrix
            cost += dims[i] * dims[k] * dims[j];

            if (cost < min) {
                min = cost;
            }
        }
        return min;
    }

	public static void MatrixChainOrder(int p[], int n)	{
		int m[][] = new int[n][n]; 
		int bracket[][] = new int[n][n]; 
		
		for (int i=1; i<n; i++) 
			m[i][i] = 0; 
		
		for (int L=2; L<n; L++) 	{ 
			for (int i=1; i<n-L+1; i++) 
			{ 
				int j = i+L-1; 
				m[i][j] = Integer.MAX_VALUE; 
				for (int k=i; k<=j-1; k++) 	{ 
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; 
					if (q < m[i][j]) 	{ 
						m[i][j] = q;   
						bracket[i][j] = k; 
					} 
				} 
			} 
		}
		ch = 65; 
    	System.out.print("\nOptimal Parenthesization is : \t"); 
    	printParenthesis(1, n-1, n, bracket); 
    	System.out.println("Optimal Cost is : " + m[1][n-1]); 
	}
	
	public static void printParenthesis(int i, int j, int n, int bracket[][])		{
		if (i == j) 	{ 
			System.out.print((char)ch); 
			ch++;
			return; 
		} 
		System.out.print("("); 
		printParenthesis(i, bracket[i][j], n, bracket); 
		printParenthesis(bracket[i][j] + 1, j, n, bracket); 
		System.out.print(")"); 
	}
}