import java.io.*;
import java.util.*;

public class Main {

  public static void sort012(int[] arr){
    
      //[0,j) -> 0's region
      //[j, i) -> 1's region
      //[i,k] -> unexplored
      //[k+1,...) -> 2's region
      int j = 0, i = 0, k = arr.length-1;
      
      while(i <= k){
          
          int val = arr[i];
          
          if(val == 1){
              i++;
          }
          else if(val < 1){
              swap(arr, i, j);
              j++; i++;
          }else{
              swap(arr, i, k);
              k--;
          }
          
      }
    
  }
  

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}
