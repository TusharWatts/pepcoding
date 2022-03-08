import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] dpTable = new int[n+1];
    Arrays.fill(dpTable, -1);
    int ans = getFibonacci(n, dpTable);
    int ans = getFibonacci(n);
    System.out.println(ans);

  }
  
  //Recursive (Memoization) approach
  public static int getFibonacci(int n, int[] dp_table){
      
      //base case
      if(n == 0 || n == 1) return n;
      
      int fib_n1 = getFibonacci(n-1, dp_table);
      int fib_n2 = getFibonacci(n-2, dp_table);
      
      dp_table[n] = fib_n1 + fib_n2;
      
      return dp_table[n];
      
  }
  
  //Tabulation (Iteration) approach
  public static int getFibonacci(int n){
      
      int[] dp_table = new int[n+1];
      dp_table[0] = 0; dp_table[1] = 1;
      
      for(int i = 2; i <= n; i++){
          dp_table[i] = dp_table[i-1] + dp_table[i-2];
      }
      
      return dp_table[n];
      
  }

}
