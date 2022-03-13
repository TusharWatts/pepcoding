import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        //Using recursion (without memoization or tabulation)
        //System.out.println( countClimbStairs(0, n) );
        
        //Using recursion (With memoization)
        // int[] dpTable = new int[n+1];
        // Arrays.fill(dpTable, -1);
        // System.out.println( countClimbStairs(0, n, dpTable) );
        //Using Tabulation
        System.out.println( countClimbStairs(n) );
        
    }
    
    //Using Recursion (without memoization or tabulation)
    // public static int countClimbStairs(int src, int n){
        
    //     //base case
    //     if(src > n) return 0;
    //     else if(src == n) return 1;
        
    //     int path_n1 = countClimbStairs(src+1, n);
    //     int path_n2 = countClimbStairs(src+2, n);
    //     int path_n3 = countClimbStairs(src+3, n);
        
    //     return path_n1 + path_n2 + path_n3;
        
    // }
    
    //Using recursion (memoization)
    // public static int countClimbStairs(int src, int n, int[] dp_table){
        
    //     //base case
    //     if(src > n) return 0;
    //     else if(src == n) return 1;
        
    //     if(dp_table[src] != -1) return dp_table[src];
        
    //     int path_n1 = countClimbStairs(src+1, n, dp_table);
    //     int path_n2 = countClimbStairs(src+2, n, dp_table);
    //     int path_n3 = countClimbStairs(src+3, n, dp_table);
        
    //     dp_table[src] = path_n1 + path_n2 + path_n3;
    //     return dp_table[src];
        
    // }    
    
    //Using Tabulation
    public static int countClimbStairs(int n){
        
        int[] dpTable = new int[n+1];
        dpTable[n] = 1;
        
        for(int i = n; i >= 0; i--){
            
            if(dpTable[i] == 0){
                    
                int path_n1 = (i+1 > n) ? 0 : dpTable[i+1];
                int path_n2 = (i+2 > n) ? 0 : dpTable[i+2];
                int path_n3 = (i+3 > n) ? 0 : dpTable[i+3]; 
                
                dpTable[i] = path_n1 + path_n2 + path_n3;
                
            }
            
        }
        
        return dpTable[0];
        
    }
    

}
