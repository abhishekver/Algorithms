import java.util.*;
class LongestIncreasingSeq	{

	static int max_ref;
	public static void main(String[] args) {
		Scanner aa= new Scanner(System.in);
		int n; 
		System.out.println("Enter the size of array");
		n = aa.nextInt();
		int arr[] = new int[n];
		int i;
		for(i=0; i<n; i++)	
			arr[i] = aa.nextInt();
		
		max_ref = 1;
		lis( arr, n);
		System.out.println("Longest length is: "+max_ref); 

		aa.close();
	} 
	
	static int lis(int arr[], int n) 	{ 

    	if (n == 1) 
        	return 1; 
    	int res, max_ending_here = 1;   
    
        for (int i = 1; i < n; i++) 
        { 
            res = lis(arr, i); 
            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here) 
                max_ending_here = res + 1; 
        } 
        if (max_ref < max_ending_here) 
			max_ref = max_ending_here; 
			
        return max_ending_here; 
	}
}