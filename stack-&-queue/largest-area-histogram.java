import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int max = calculateLargestArea(a);
    System.out.println(max);

 }
 
//  public static int calculateLargestArea(int[] arr){
     
//      int max = -1;
//      int arrLen = arr.length;
     
//      for(int currPtr = 0; currPtr < arrLen; currPtr++){
         
//          int currVal = arr[currPtr];
//          int stkLeft = 0; int stkRight = 0;
         
//          for(int leftPtr = currPtr-1; leftPtr >= 0; leftPtr--){
             
//              int leftVal = arr[leftPtr];
             
//              if(leftVal >= currVal) stkLeft++;
//              else break;
             
//          }
         
//          for(int rightPtr = currPtr+1; rightPtr < arrLen; rightPtr++){
             
//              int rightVal = arr[rightPtr];
             
//              if(rightVal >= currVal) stkRight++;
//              else break;
             
//          }
         
//          int calVal = (1 + stkLeft + stkRight) * currVal;
//          max = calVal > max ? calVal : max;
         
//      }
     
//      return max;
     
//  }

    public static int calculateLargestArea(int[] arr){
        
        int max = 0;
        int arrLen = arr.length;
        
        int[] nseL = getNseL(arr);
        int[] nseR = getNseR(arr);
         
        for(int currPtr = 0; currPtr < arrLen; currPtr++){
            
            int nseLIdx = nseL[currPtr], nseRIdx = nseR[currPtr];
            int area = (nseRIdx - nseLIdx - 1) * arr[currPtr];
            max = Math.max(max, area);
            
        }        
        
        return max;
        
    }
    
    public static int[] getNseL(int[] arr){

        int arrLen = arr.length;
        int[] nseL = new int[arrLen];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < arrLen; i++){
            
            int val = arr[i];
            
            while(stk.isEmpty() == false && arr[stk.peek()] >= val){
                stk.pop();
            }
            
            nseL[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
            
        }
        
        return nseL;
        
    }
 
 
    public static int[] getNseR(int[] arr){
        
        int arrLen = arr.length;
        int[] nseR = new int[arrLen];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = arrLen-1; i >= 0; i--){
            
            int val = arr[i];
            
            while(stk.isEmpty() == false && arr[stk.peek()] >= val){
                stk.pop();
            }
            
            nseR[i] = stk.isEmpty() ? arrLen : stk.peek();
            stk.push(i);
            
        }
        
        return nseR;
        
    }
 
}
