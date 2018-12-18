import java.util.*;
class MergeSort2  {

      public static void mergeSort2(int arr[], int l, int r)
      {
            if (l < r)
            {
                  int m = l+(r-l)/2;
                  mergeSort2(arr, l, m);
                  mergeSort2(arr, m+1, r);
                  merge(arr, l, m, r);
          }
      }

      public static void main(String args[])    {
            
            Scanner aa = new Scanner(System.in);
            int a[] = new int [10];
            int i;

            System.out.print("Enter");
            for(i=0; i<10; i++)     {
                  a[i] = aa.nextInt();
            }

            mergeSort2(a,0,9);

            System.out.println("Sorted array");
            for(i=0; i<10; i++)     {
                  System.out.print(a[i]+"\t");
            }
            aa.close();
      }

      
      public static void merge(int arr[], int l, int m, int r)
      {
      int i, j, k;
      int n1 = m - l + 1;
      int n2 =  r - m;
      
      int L[] = new int[n1];
      int R[] = new int[n2];
      
      for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
      for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
      
      /* Merge the temp arrays back into arr[l..r]*/
      i = 0; 
      j = 0; 
      k = l; 
      while (i < n1 && j < n2)
      {
            if (L[i] <= R[j])
            {
                  arr[k] = L[i++];
            }
            else
            {
                  arr[k] = R[j];
                  j++;
            }
            k++;
      }
      
      while (i < n1)
      {
            arr[k] = L[i];
            i++;
            k++;
      }
      
      while (j < n2)
      {
            arr[k] = R[j];
            j++;
            k++;
      }
}
}
