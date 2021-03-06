import java.io.*;
import java.util.*;

public class Main {

  public static void quickSort(int[] arr, int left, int right) {

    if(left > right) return;

    int pivot = arr[right];
    int pivotIdx = partition(arr, pivot, left, right);
    
    quickSort(arr, left, pivotIdx-1);
    quickSort(arr, pivotIdx+1, right);
    
  }
  
  
  public static int partition(int[] arr, int pivot, int left, int right){
      
      System.out.println("pivot -> " + pivot);
      
      int greaterThan = left, unexploredFirst = left;
      
      while(unexploredFirst <= right){
          
          int val = arr[unexploredFirst];
          
          if(val <= pivot){
              swap(arr, unexploredFirst, greaterThan);
              greaterThan++;
          }
          
          unexploredFirst++;
          
      }
      
      System.out.println("pivot index -> " + (greaterThan-1));
      return (greaterThan-1);
      
  }


  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    quickSort(arr, 0, arr.length - 1);
    print(arr);
  }

}
