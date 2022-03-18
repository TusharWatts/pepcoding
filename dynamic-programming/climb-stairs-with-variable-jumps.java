import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int jumpsArr[] = new int[n];
        for(int i = 0; i < n; i++){
            jumpsArr[i] = scn.nextInt();
        }
        
        //int ans = countStairJumpsMem(0, n, jumpsArr);
        //int ans = countStairJumps(0, n, jumpsArr);
        int ans = countStairJumpsTab(n, jumpsArr);
        System.out.println(ans);
        
    }
    
    
    public static int countStairJumps(int src, int n, int[] jumps_arr){
        
        //-ve base case
        if(src > n) return 0;
        //+ve base case
        else if(src == n) return 1;
        
        int ans = 0;
        
        for(int i = 1; i <= jumps_arr[src]; i++ ){
            ans += countStairJumps(src+i, n, jumps_arr);   
        }
        
        return ans;
        
    }
    
    
    public static int countStairJumpsMem(int src, int n, int[] jumps_arr){
        
        //-ve base case
        if(src > n) return 0;
        //+ve base case
        else if(src == n) return 1;
        
        int ans = 0;
        int[] dpTable = new int[n+1];
        Arrays.fill(dpTable, -1);
        
        for(int i = 1; i <= jumps_arr[src]; i++ ){
            
            if(dpTable[i] == -1){
                dpTable[i] = countStairJumps(src+i, n, jumps_arr);
            }
            
            ans += dpTable[i];
            
        }
        
        return ans;
        
    }    
    
    
    public static int countStairJumpsTab(int n, int[] jumps_arr){
        
        int[] dpTable = new int[n+1];
        dpTable[n] = 1;
        //Arrays.fill(dpTable, -1);
        
        for(int i = n-1; i >= 0; i--){
            
            int ans = 0;
            for(int jump = 1; jump <= jumps_arr[i]; jump++){
                ans += (i + jump > n) ? 0 : dpTable[i+jump];
            }                
                
            dpTable[i] = ans;
            
        }
     
        return dpTable[0];   
        
    }

}
