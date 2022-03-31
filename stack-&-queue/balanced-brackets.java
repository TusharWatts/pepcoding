import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String expr = scn.nextLine();
        
        Stack<Character> stk = new Stack<>();
        
        for(char ch: expr.toCharArray()){
            
            //Check if character is bracket or not
            if(isBracket(ch)){ 
                
                if( isBracketOpening(ch) ){
                
                    stk.push(ch);
                
                }
                else if(!stk.isEmpty() && isBracketsCorrect(stk, ch)){
                
                    stk.pop();
                
                }else{
                    
                    stk.push(ch);
                    
                }
                
            }
            
        }
        
        System.out.println(stk.isEmpty());

    }
    
    public static boolean isBracket(char ch){
        return (ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']');
    }

    public static boolean isBracketOpening(char ch){
        return (ch == '(' || ch == '{' || ch == '[');
    }    
    
    public static boolean isBracketsCorrect(Stack<Character> brackets, char ch){
        
        if(brackets.isEmpty() == true) return false;
        
        if(ch == ')') return brackets.peek() == '(';
        
        else if(ch == '}') return brackets.peek() == '{';
        
        else if(ch == ']') return brackets.peek() == '[';
        
        return false;
        
    }

}
