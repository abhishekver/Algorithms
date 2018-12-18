import java.util.*;
class HeapSort   {
      public static void main(String [] args)   {
            Scanner aa = new Scanner(System.in);
            System.out.println("Enter size");

            int n = aa.nextInt();
            int a[] = new int [n];
            int i;

            System.out.println("Enter the numbers");
            for(i=0; i<n; i++)     {
                  a[i] = aa.nextInt();
            }
            
            long startTime = System.nanoTime();
            heapSort(a,n);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);

            System.out.println("Sorted array");
            for(i=0; i<n; i++)     {
                  System.out.print(a[i]+"\t");
            }
            aa.close();
      }

      /* Function for heap sort 
         Arguments : integer array, size of the array */

      public static void heapSort(int arr[], int n)
      {
            // Building heap for the given array
            for (int i = n / 2 - 1; i >= 0; i--)
                  heapify(arr, n, i);
 
            // One by one extract an element from heap
            for (int i=n-1; i>=0; i--)
            {
                  // Move current root to end
                  int temp = arr[0];
                  arr[0] = arr[i];
                  arr[i] = temp;
                  // call max heapify on the reduced heap
                  heapify(arr, i, 0);
            }
      }
 
      /* Algorithm to heapify a subtree rooted with node i
         an index in arr[] is the given array, n is the size of heap  */

      public static void heapify(int arr[], int n, int i)
      {
            int largest = i;  // Initialize largest as root
            int l = 2*i + 1;  // left = 2*i + 1
            int r = 2*i + 2;  // right = 2*i + 2
      
            if (l < n && arr[l] > arr[largest])
                  largest = l;      

            if (r < n && arr[r] > arr[largest])
                  largest = r;

            if (largest != i)
            {
                  int swap = arr[i];
                  arr[i] = arr[largest];
                  arr[largest] = swap;
                  heapify(arr, n, largest);
            }
      }
}