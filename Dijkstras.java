import java.util.*;

public class Dijkstras	{

	private boolean unsettled[];
	private boolean settled[];
	private int numberofvertices;
	private int adjacencyMatrix[][];
	private int key[];
	public static final int INFINITE = 999;
	private int parent[];
	
	public Dijkstras(int numberofvertices)	{

		this.numberofvertices = numberofvertices;
		unsettled = new boolean[numberofvertices + 1];
		settled = new boolean[numberofvertices + 1];
		adjacencyMatrix = new int[numberofvertices + 1][numberofvertices + 1];
		key = new int[numberofvertices + 1];
		parent = new int[numberofvertices + 1];
	}

	public void dijkstrasAlgorithm(int [][] adjacencyMatrix)	{
		int evaluationVertex;
		for(int source = 1; source<=numberofvertices; source++)	{
			for(int destination = 1; destination<=numberofvertices; destination++)	{
				this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
			}
		}

		for(int index = 1; index < numberofvertices; index++)	{
			key[index] = INFINITE;
		}

		key[1] = 0;
		unsettled[1] = true;
		parent[1] = 1;
	}


	public void printMST()	{
		System.out.println("SOURCE  : DESTINATION = WEIGHT");
		for (int vertex = 2; vertex <= numberofvertices; vertex++)	{
			System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
		}
	}
	public static void main(String[] args) {
		int adjacency_matrix[][];
		int number_of_vertices;
		Scanner aa = new Scanner(System.in);
		
		try	{
			System.out.println("Enter the number of vertices");
			number_of_vertices = aa.nextInt();
			adjacency_matrix = new int[number_of_vertices+1][number_of_vertices+1];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 1; i <= number_of_vertices; i++)	{
				for (int j = 1; j <= number_of_vertices; j++)	{
					adjacency_matrix[i][j] = aa.nextInt();
					if (i == j)		{
						adjacency_matrix[i][j] = 0;
						continue;
					}
					if (adjacency_matrix[i][j] == 0)	{
						adjacency_matrix[i][j] = INFINITE;
					}
				}
			}
			aa.close();
	
			Dijkstras dik = new Dijkstras(number_of_vertices);
			dik.dijkstrasAlgorithm(adjacency_matrix);
			dik.printMST();
	

		}
		catch (InputMismatchException e)	{
			System.out.println("Input is in wrong format");
		}
	}
}