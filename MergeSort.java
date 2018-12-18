import java.util.*;
class MergeSort     {
      public static void main(String args[])    {
            
            Scanner aa = new Scanner(System.in);
            int a[] = new int [10];
            int i;

            System.out.print("Enter");
            for(i=0; i<10; i++)     {
                  a[i] = aa.nextInt();
            }

            a = mergeSort(a,10);
            System.out.println("Sorted array");
            for(i=0; i<10; i++)     {
                  System.out.print(a[i]+"\t");
            }
            aa.close();
      }

      /*    Code for Merge Sort
            Takes an array of n size, divides it in two sub arrays
            Sorts them using Insertion Sort
            returns sorted array
            access type: Call by value
      */

      public static int[] mergeSort(int a[], int n)     {
            int ns = n/2;
            int a1[] = new int[ns];
            int a2[] = new int[ns];
            int i;


            for(i=0; i< ns; i++)      {
                  a1[i] = a[i];
                  a2[i] = a[(ns)+i];
            }

            InsertionSort.insertionSort(a1,5);
            InsertionSort.insertionSort(a2,5);
            a = merge(a1, ns, a2, ns);
            return a;
      }


      /*    Code for Merging
            Takes two sorted arrays: a1 of size m, and a2 of size n
            return type: integer array :- Returns the merged sorted array
      */
      public static int[] merge(int a1[], int m, int a2[], int n)      {
            int a[] = new int[m+n];
            int k=0, m1=0, n1=0;
            
            while(m1<m && n1<n)   {
                  if(a1[m1] < a2[n1])     {
                        a[k] = a1[m1];
                        k++;
                        m1++;
                  }          
                  else       {
                        a[k] = a2[n1];
                        k++;
                        n1++;
                  }          
            }
            while(m1 < m)    {
                  a[k++] = a1[m1++];
            }
            while(n1 < n)    {
                  a[k++] = a2[n1++];
            }
            return a;
      }
}