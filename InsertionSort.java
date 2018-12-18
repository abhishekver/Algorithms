import java.util.*;
class InsertionSort     {
      public static void main(String args[])    {
            
            Scanner aa = new Scanner(System.in);
            int a[] = new int [10];
            int i;

            System.out.print("Enter");
            for(i=0; i<10; i++)     {
                  a[i] = aa.nextInt();
            }

            insertionSort(a,10);

            for(i=0; i<10; i++)     {
                  System.out.println(a[i]);
            }
            aa.close();
      }

      /*    Code method for Insertion Sort, sorts the array using insertion sort
            Return: null
            Parameters: int array, int size
            Access type: Call by reference
      */
      public static void insertionSort(int arr[], int n)   {
            int i, key, j;
            for(i=0; i<n; i++)      {
                  key = arr[i];
                  j=i-1;

                  while(j>=0 && arr[j]>key)     {
                        arr[j+1] = arr[j];
                        j=j-1;
                  }
                  arr[j+1] = key;
            }
      }
}