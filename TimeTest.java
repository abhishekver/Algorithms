import java.util.*;
class TimeTest    {
      public static void main(String args[])    {

            Random rand = new Random();
            Scanner aa = new Scanner(System.in);
            System.out.println("Enter test size");

            int n = aa.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int i;
            for(i=0; i<n; i++)      {
                  int rand_int = rand.nextInt(1000);
                  a[i] = rand_int;
                  b[i] = rand_int;
            }

            System.out.println("\nTotal test cases run = "+n);
            
            long startTime = System.nanoTime();
            HeapSort.heapSort(a,n);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Time for heap sort: "+totalTime+"ns");

            startTime = System.nanoTime();
            QuickSort.quickSort(b,0,n-1);
            endTime   = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Time for Quick Sort: "+totalTime+"ns \n");

            aa.close();
      }
}