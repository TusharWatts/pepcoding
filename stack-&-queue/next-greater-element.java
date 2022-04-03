import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   
   int arrLen = arr.length;
   int[] nge = new int[arrLen];
   
   Stack<Integer> stk = new Stack<>();
   
   for(int i = arrLen-1; i >= 0; i--){
       
        int currVal = arr[i];
       
        //Pop smaller elements
        while(stk.size() > 0 && stk.peek() < currVal){
            stk.pop();
        }
        
        //Answer
        nge[i] = stk.isEmpty() ? -1 : stk.peek();
        
        stk.push(currVal);
       
   }
   
   return nge;
   
 }
