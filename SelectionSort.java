import java.util.*;
class SelectionSort     {
      public static void main(String args[])    {
            
            Scanner aa = new Scanner(System.in);
            int a[] = new int [10];
            int i,j,min;

            System.out.print("Enter");
            for(i=0; i<10; i++)     {
                  a[i] = aa.nextInt();
            }

            for(i=0; i<10; i++)     {
                  min = i;
                  for(j= i; j<10; j++)    {
                        if(a[min] > a[j]) 
                              min=j;
                  }
                  int temp = a[i];
                  a[i] = a[min];
                  a[min] = temp;
            }

            for(i=0; i<10; i++)     {
                  System.out.println(a[i]);
            }
            aa.close();
      }
}