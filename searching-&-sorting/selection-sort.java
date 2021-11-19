import java.io.*;
import java.util.*;

public class Main {

  public static void selectionSort(int[] arr) {
    
    for(int outer = 0; outer < arr.length-1; outer++){
        
        int min_index = outer;
        int min_value = arr[min_index];
        
        for(int inner = min_index+1; inner < arr.length; inner++){
            
            if(isSmaller(arr, inner, min_index)){
                min_index = inner;
            }
            
        }   
        
        swap(arr, outer, min_index);
        
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSort(arr);
    print(arr);
  }

}
