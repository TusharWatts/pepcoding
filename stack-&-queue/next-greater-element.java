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
    int k = Integer.parseInt(br.readLine());

    int[] result = calculateMaxSlidingWindow(a, k);
    
    for(int elem: result){
        System.out.println(elem);
    }
    
}
 
 /*
 * O(n^2) approach (brute force)
 */
//  public static int[] calculateMaxSlidingWindow(int[] arr, int window_size){
     
//      int[] result = new int[arr.length-window_size+1];
     
//      for(int outer = 0; outer <= arr.length-window_size; outer++){
         
//          int max = arr[outer];
//          for(int inner = outer+1; inner < outer+window_size; inner++){
//              max = Math.max(max, arr[inner]);
//          }
         
//          result[outer] = max;
         
//      }
     
//      return result;
     
     
//  }
 
 /*
 * Find next greater element to the right of each elements of the array
 */
 public static int[] getNgeR(int[] arr){
     
     int[] ngeR = new int[arr.length];
     Stack<Integer> stk = new Stack<>();
     
     for(int i = arr.length-1; i >= 0; i--){
         
         int val = arr[i];
         
         while(stk.isEmpty() == false && arr[stk.peek()] < val){
             stk.pop();
         }
         
         ngeR[i] = stk.isEmpty() ? -1 : stk.peek();
         stk.push(i);
         
     }
     
     return ngeR; 
     
 }
 
 
 /*
 * O(n) approach using stacks
 */
 public static int[] calculateMaxSlidingWindow(int[] arr, int window_size){
     
     //Get next greater element to the right (for each elements of the array)
     int[] ngeR = getNgeR(arr);
     
     int[] result = new int[arr.length - window_size+1];
     
     int prevWinMaxIdx = 0;
     for(int outer = 0; outer < arr.length - window_size+1; outer++){
         
         int currIdx = prevWinMaxIdx;
         
         //If prev window max doesn't lie in the current window, start from the first element of the window
         if(currIdx < outer) currIdx = outer;
         
         //Jump to n.g.e (right) till it lies in the current window
         int ngeRIdx = ngeR[currIdx];
         while( ngeRIdx > outer && ngeRIdx < outer + window_size ){
             currIdx = ngeRIdx;             
             ngeRIdx = ngeR[ngeRIdx];
         }
         
         prevWinMaxIdx = currIdx;
         result[outer] = arr[currIdx];
         
     }
     
     return result;
     
 }
 
}
