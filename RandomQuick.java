import java.util.*;
class RandomQuick       {
      public static void main(String[] args)    {
            Scanner aa = new Scanner(System.in);
            System.out.println("Enter size");
            int n=aa.nextInt();

            int a[] = new int [n];
            int i;

            System.out.print("Enter");
            for(i=0; i<n; i++)     {
                  a[i] = aa.nextInt();
            }

            long startTime = System.nanoTime();
            randomQuickSort(a,0,n-1);

            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);

            System.out.println("Sorted array");
            for(i=0; i<n; i++)     {
                  System.out.print(a[i]+"\t");
            }
            aa.close();
      }

      public static void randomQuickSort(int a[], int p, int r)      {
            if(p<r)     {
                  int q = randoPartition(a,p,r);
                  randomQuickSort(a, p, q-1);
                  randomQuickSort(a, q+1, r);
            }
      }

      public static int randoPartition(int a[], int p, int r)     {
            Random rand = new Random();
            int i, temp;
            i = rand.nextInt(r-p)+p;
            temp = a[i];
            a[i] = a[r];
            a[r] = temp;
            return QuickSort.partition(a, p, r);
      }
}