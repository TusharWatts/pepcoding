import java.io.*;
import java.util.*;

class StackOutofBound extends Exception {
    
  int index;

  StackOutofBound(int idx) {
    index = idx;
  }
  
  public String toString() {
    return ("Stack out of bound exception at : " + index) ;
  }
  
}


public class Main {

  public static class CustomStack {

    protected int[] data;
    protected int top;

    public CustomStack(int cap) {
      data = new int[cap];
      top = -1;
    }

    int size() {
      // write ur code here
      return top + 1;
    }

    void display() {

      // write ur code here
      for (int i = top; i >= 0 ; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();

    }

    void push(int val) {

      // write ur code here
      if (top == data.length - 1)
        System.out.println("Stack overflow");
      else
        data[++top] = val;

    }

    int pop() throws StackOutofBound{

      // write ur code here
      if (top >= 0) {
        int val = data[top];
        top--;
        return val;
      } else {
        throw new StackOutofBound(top);
      }

    }

    int top() throws StackOutofBound{

      if (top >= 0 && top <= data.length - 1) {
        return data[top];
      }
      else {
        throw new StackOutofBound(top);
      }

    }

  }

  public static class DynamicStack extends CustomStack {

    DynamicStack(int cap) {
      super(cap);
    }

    void push(int val) {

      if (top == data.length - 1) {
        extendArray();
        data[++top] = val;
      }

      data[++top] = val;
    }

    void extendArray() {

      int temp[] = new int[data.length];

      for (int i = 0; i < data.length; i++) {
        temp[i] = data[i];
      }

      data = new int[data.length * 2];

      for (int i = 0; i < temp.length; i++) {
        data[i] = temp[i];
      }

    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    DynamicStack dt = new DynamicStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        dt.push(val);
      } else if (str.startsWith("pop")) {
        int val = dt.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = dt.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(dt.size());
      } else if (str.startsWith("display")) {
        dt.display();
      }
      str = br.readLine();
    }
  }


}
