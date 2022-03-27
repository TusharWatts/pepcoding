import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String expr = scn.nextLine();

        Stack<Character> stk = new Stack<>();  
        boolean ifRedundantBrackets = false;
        
        for(char ch: expr.toCharArray()){

            if(ch == ')'){
                
                int countIndepContent = 0;
                
                while(stk.pop() != '('){
                    countIndepContent++;
                }
                
                if(countIndepContent == 0) ifRedundantBrackets = true;
                
            }else{
                
                stk.push(ch);
                
            }
            
        }
        
        System.out.println(ifRedundantBrackets);

    }
    

}
