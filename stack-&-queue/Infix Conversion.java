import java.io.*;
import java.util.*;

public class Main{
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        convertToPostfix(exp);
        
     }
     
     /*
      * Convert infix to postfix
      * Incorrect approach (will work only for postfix and not prefix)
     */
    //  public static void convertToPostfix(String exp){
         
    //     Stack<Character> postfixStk = new Stack<>();
    //     Stack<Character> operatorStk = new Stack<>();
         
    //     for(char ch : exp.toCharArray()){
            
    //         //If space
    //         if(ch == ' ') continue;
            
    //         //If open bracket
    //         else if( ch == '(' ){
    //             operatorStk.push(ch);
    //         }
    //         //If closed bracket
    //         else if( ch == ')' ){
                
    //             //Pop and push all the operators to the final stack until an open bracket is encountered
    //             while(operatorStk.peek() != '('){
    //                 postfixStk.push( operatorStk.pop() );
    //             }
    //             operatorStk.pop();
                
    //         }
    //         //If operator
    //         else if( ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
                
    //             if(operatorStk.size() > 0 && operatorStk.peek() != '('){
    //                 postfixStk.push( operatorStk.pop() );
    //             }
    //             operatorStk.push(ch);
                
    //         }
    //         //else if operand
    //         else{
    //             postfixStk.push(ch);
    //         }
            
    //     }       
        
    //     //Remaining operators
    //     while( operatorStk.size() > 0 ){
    //         postfixStk.push( operatorStk.pop() );
    //     }
        
    //     System.out.println( Arrays.toString(postfixStk.toArray()) );
        
    //     Collections.reverse(postfixStk);
        
    //     System.out.println( Arrays.toString(postfixStk.toArray()) );
         
    //  }

    public static int getPrecedence(Character ch){
        
        if(ch == '+' || ch == '-') return 1;
        
        else if(ch == '*' || ch == '/') return 2;
        
        else return 0;
        
    }

    
    public static void convertToPostfix(String exp){
        
        Stack<Character> operatorStk = new Stack<>();
        Stack<String> postfixStk = new Stack<>();
        Stack<String> prefixStk = new Stack<>();
        
        for(char ch: exp.toCharArray()){
            
            //If space
            if(ch == ' ') continue;
            
            //If closed operator, perform operation till the corresponding open bracket is not encountered
            else if(ch == ')'){
                
                while(operatorStk.size() > 0 && operatorStk.peek() != '('){
                    char operator = operatorStk.pop();
                    performOp(prefixStk, postfixStk, operator);                    
                }
                
                operatorStk.pop();
                
            }
            //If operator
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                
                int chLevel = getPrecedence(ch);
                
                //Peform operation depeding on condition
                while( operatorStk.size() > 0 && operatorStk.peek() != '(' && getPrecedence(operatorStk.peek()) >= chLevel ){
                    
                    char operator = operatorStk.pop();
                    performOp(prefixStk, postfixStk, operator);
                    
                }
                
                //Push the operator
                operatorStk.push(ch);
                
            }
            
            //If open bracket
            else if(ch == '(') operatorStk.push(ch);
            
            //If operand
            else{
                postfixStk.push(ch + "");
                prefixStk.push(ch + "");
            } 
            
        }
         
        while(operatorStk.size() > 0){
            char operator = operatorStk.pop();
            performOp(prefixStk, postfixStk, operator);
        }
        
        System.out.println( postfixStk.pop() );    
        System.out.println( prefixStk.pop() );   
        
    }
    
    
    public static void performOp(Stack<String> prefix, Stack<String> postfix, char op){
        
        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        
        
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        
        
        prefix.push(op + prev1 + prev2);
        postfix.push(postv1 + postv2 + op);
    }
    
 
}
