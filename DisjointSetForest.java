import java.util.*;
class DisjointSetForest	{

	int[] rank, parent; 
	int n; 
	
	//Constructor
    	public DisjointSetForest(int n) { 
		rank = new int[n]; 
		parent = new int[n]; 
		this.n = n; 
		makeSet(); 
	}
	public static void main(String[] args)	{
		
		DisjointSetForest ob = new DisjointSetForest(6);
		int i, j;
		int a[][] = {
			{0, 1, 1, 1, 0, 0},
			{1, 0, 0, 0, 0, 0},
			{1, 0, 0, 1, 1, 0},
			{1, 0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}
		};

		for(i =0; i<6; i++)	{
			for(j=0; j<6; j++)	{
				if(a[i][j] == 1)	{
					int iroot = ob.find(i);
					int jroot = ob.find(j);
					if(iroot!=jroot)
						ob.union(i,j);
				}
			}
		}
	} 
  
    	// Creates n sets with single item in each 
	void makeSet() 
	{ 
		for (int i=0; i<n; i++)
			parent[i] = i; 
	} 

	//Find the parent of x, call recursively until parent is found
	int find(int x) 	{ 
		if (parent[x]!=x) 	{ 
			parent[x] = find(parent[x]); 
		} 
		return parent[x]; 
	} 

	//Finds the union of the sets that contains x and the set that contains y
	void union(int x, int y)	{ 
		int xRoot = find(x), yRoot = find(y); 
		if (xRoot == yRoot) 
		    	return; 
	
		if (rank[xRoot] < rank[yRoot]) 
			parent[xRoot] = yRoot; 
	
		else if (rank[yRoot] < rank[xRoot]) 
			parent[yRoot] = xRoot; 
	
		else 	{ 
			parent[yRoot] = xRoot; 
			rank[xRoot] = rank[xRoot] + 1; 
		} 
	} 
}