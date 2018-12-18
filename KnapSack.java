import java.util.*;
class KnapSack    {
      public static void main(String[] args)     {
            
            int weight[] = {10, 20, 30};
            int price[] ={60, 100, 120};
            String names[] = {"Item1", "Item2", "Item3"};
            int max=50;
            
            int ppw[] = new int[3];
            for(int  i=0; i<3; i++) {
                  ppw[i] = weight[i] / price[i];
            }
            sort(weight, names, ppw, 3);
            knap(weight, names, ppw, 3, max);
      }
      
      public static void sort(int wt[], String s[], int ppw[], int l)     {
            int i, temp, j;
            String s2;

            for(i=0; i<l-1; i++)      {
                  for(j=0; j<l-i-1; j++)  {
                        if(ppw[j]>ppw[j+1])     {
                              temp = ppw[j];
                              ppw[j] = ppw[j+1];
                              ppw[j+1] = temp;

                              s2 = s[j];
                              s[j] = s[j+1];
                              s[j+1] = s2;

                              temp = wt[j];
                              wt[j] = wt[j+1];
                              wt[j+1] = temp;
                        }
                  }
            }
      }

      public static void knap(int weight[], String names[], int ppw[], int l, int max)     {
            int i=l-1;
            int am=0;
            int x, rem;
            while(am<max && i>=0)     {
                  rem = max-am;
                  if(weight[i]<rem) {
                        x = weight[i];
                        am += x;
                        System.out.println(x+" units of "+ names[i]);
                        i--;
                  }             
                  else  {
                        am += rem;
                        x = rem;
                        System.out.println(x+" units of "+ names[i]);
                        i--;
                  }     
            }
      }
}