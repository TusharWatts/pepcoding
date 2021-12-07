/*
* 1. You are given an array(arr) of integers.
* 2. You have to sort the given array in increasing order using count sort.
*/



import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   
    int arrLen = arr.length;
   
    int[] freq = new int[max-min+1];
    for(int val : arr){
        freq[val-min]++;
    }
    
    int[] prefixSum = new int[max-min+1];
    for(int i = 0; i < freq.length; i++){
        prefixSum[i] = (i == 0) ? freq[i] : (freq[i] + prefixSum[i-1]);
    }
    
    int ans[] = new int[arrLen];
    
    for(int i = arrLen - 1; i >= 0 ; i--){
        int newIndx = --prefixSum[arr[i] - min];
        ans[newIndx] = arr[i];
    }
    
    for(int i = 0; i < arrLen; i++){
        arr[i] = ans[i];
    }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
