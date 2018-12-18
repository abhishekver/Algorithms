import java.util.*;
class HeapExtract {

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
            aa.close();

            System.out.println("Heap Extract");
            heapExtract(a,n);
      }  

      public static void heapExtract(int a[], int n)  {
            int i,j;
            int heapSize = n;
            for (i = n / 2 - 1; i >= 0; i--)
                  HeapSort.heapify(a, n, i);

            if(n<1)     {
                  System.out.println("Underflow");
                  return;
            }

            for (i=heapSize-1; i>=0; i--)    {
                  int temp = a[0];
                  a[0] = a[i];
                  a[i] = temp;
                  heapSize--;
                  HeapSort.heapify(a, heapSize, 0);

                  System.out.println("\n\nExtracted element: "+temp);
                  System.out.print("Remaining heap: ");

                   for(j=heapSize-1; j>=0; j--) 
                        System.out.print(a[j]+" "); 
            }
      }
}