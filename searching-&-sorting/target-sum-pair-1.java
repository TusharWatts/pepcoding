/*
* 1. You are given an array(arr) of distinct integers and a target.
* 2. You have to print all the pairs having their sum equal to the target.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    
    int left = 0, right = arr.length - 1;
    
    Arrays.sort(arr);
    
    while(left < right){
        
        int leftVal = arr[left], rightVal = arr[right];
        
        if(leftVal + rightVal == target){
            System.out.println(leftVal + ", " + rightVal);
            left++; right--;
        }
        else if(leftVal + rightVal < target){
            left++;
        }
        else if(leftVal + rightVal > target){
            right--;
        }
        
    }

  }
  
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}
