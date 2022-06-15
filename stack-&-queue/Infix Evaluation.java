import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    int result = evaluateExpression(exp);
    System.out.println(result);
 }
 
    /*
    * Wrong solution
    */
//  public static int evaluateExpression(String exp){
     
//     boolean isSecondOperand = false, ifEvaluate = false, isBrackets = false;
    
//     Stack<Character> stkOperator = new Stack<>();
//     Stack<Integer> stkOperand = new Stack<>();
    
//     for(char ch: exp.toCharArray()){
        
//         //If operator
//         if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
//             stkOperator.push(ch);
//             ifEvaluate = true;
//         }
//         //If brackets ()
//         else if(ch == '('){
//             ifEvaluate = false;
//             isSecondOperand = false;    
//             isBrackets = true;
//             continue;
//         }
//         else if(ch == ')'){
//             ifEvaluate = true;
//             isSecondOperand = true;    
//             isBrackets = false;
//             continue;            
//         }
//         //If operand
//         else{
//             if(ifEvaluate) isSecondOperand = true;
//             stkOperand.push((int)(ch - '0'));
//         }
        
//         if(ifEvaluate && isSecondOperand && (stkOperator.peek() == '*' || stkOperator.peek() == '/' || isBrackets == true ) ){
            
//             int oper2 = stkOperand.pop();
//             int oper1 = stkOperand.pop();
//             int val = evaluateSubExpr(stkOperator.pop(), oper1, oper2 );
//             stkOperand.push(val);
            
//         }
        
//         if(ifEvaluate && isSecondOperand){
//             ifEvaluate = false;
//             isSecondOperand = false;              
//         }
        
//     }
    
//     Collections.reverse(stkOperand);
//     Collections.reverse(stkOperator);
     
//     while(stkOperand.size() > 1 && stkOperator.size() > 0){
        
//         int oper1 = stkOperand.pop();
//         int oper2 = stkOperand.pop();
//         int val = evaluateSubExpr(stkOperator.pop(), oper1, oper2 );
//         stkOperand.push(val);        
        
//     }
    
//     return stkOperand.pop();
     
//  }


public static int evaluateExpression(String exp){
    
    Stack<Integer> operandStk = new Stack<>();
    Stack<Character> operatorStk = new Stack<>();
    
     for(char ch: exp.toCharArray()){
         
        //If space
        if( ch == ' ' )
            continue;
        //If operand
        else if( (int)(ch - '0') >= 0 && (int)(ch - '0') <= 9 )
            operandStk.push( (int)(ch - '0') );
        //If operator or brackets
        else{
            
            //Closed bracket
            if( ch == ')' ){
                
                while( operatorStk.peek() != '('  ){
                    
                    solveSubExpr(operandStk, operatorStk);                
                    
                }
                
                operatorStk.pop();
                continue;
                
            }
            //Solve high precedence operators first
            else if( ch!='(' && operatorStk.size() > 0 && (operatorStk.peek() == '*' || operatorStk.peek() == '/') ){
                
                solveSubExpr(operandStk, operatorStk);           
                    
            }         
                
            operatorStk.push(ch);
            
        }
         
     }
     
     while( operandStk.size() > 0 && operatorStk.size() > 0 ){
        solveSubExpr(operandStk, operatorStk);
     }
     
     return operandStk.peek();
        
    
}
 
 
 public static int evaluateSubExpr(Character operator, int operand1, int operand2){
     
     if(operator == '+') return (operand1 + operand2);
     
     else if(operator == '-') return (operand1 - operand2);
     
     else if(operator == '*') return (operand1 * operand2);
     
     else if(operator == '/') return (operand1 / operand2);
     
     return 0;
 }
 
 
 public static void solveSubExpr(Stack<Integer> operandStk, Stack<Character> operatorStk){
    
    int operand2 = operandStk.pop();
    int operand1 = operandStk.pop();
         
    char operator = operatorStk.pop();
         
    int result = evaluateSubExpr(operator, operand1, operand2);
    operandStk.push(result);     
     
 }
 
 
 
}
