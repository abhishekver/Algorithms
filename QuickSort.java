import java.util.*;

class QuickSort   {
      public static void main(String [] args)   {
            Scanner aa = new Scanner(System.in);
            System.out.println("Enter size");
            int n=aa.nextInt();

            int a[] = new int [n];
            int i;

            System.out.print("Enter");
            for(i=0; i<10; i++)     {
                  a[i] = aa.nextInt();
            }

            long startTime = System.nanoTime();
            quickSort(a,0,n-1);

            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);

            System.out.println("Sorted array");
            for(i=0; i<10; i++)     {
                  System.out.print(a[i]+"\t");
            }
            aa.close();
      }

      public static void quickSort(int a[], int p, int r)    {
            if(p<r)     {
                  int q = partition(a, p, r);
                  quickSort(a, p, q-1);
                  quickSort(a, q+1, r);
            }
      }
      public static int partition(int a[], int p, int r)    {
            int x = a[r];
            int i = p-1;
            int j, temp;
            for(j=p; j<r; j++)      {
                  if(a[j]<=x)       {
                        i++;
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                  }
            }
            temp = a[i+1];
            a[i+1] = a[r];
            a[r] = temp;
            return i+1;
      }
}