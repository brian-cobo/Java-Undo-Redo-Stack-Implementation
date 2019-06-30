// Stack Examples discussed in class.

import java.util.Scanner;

public class StackDriver
{
    public static void main(String []args)
    {

	Scanner in = new Scanner(System.in);
	System.out.print("Enter any parenthesized expression: ");
	String s = in.nextLine();
	
	// check to see if it is a legal parenthesization
	if(isLegal(s)){
	    System.out.println(s + " is a legal parenthesization");

	    // now that you agree that it is a legally parenthesized expression, Let's go ahead 
	    // and evaluate it. Make sure you write two operands per operator.
	    // make sure that all the operands are digits, the code doesn't handle variables
	    // example (((1 + 2) * 3) - ((5 + 4) / 3))
	    evaluateExpr(s);
	    
	}else
	    System.out.println(s + " is a not legal parenthesization");



	

    }

    // go thru the string and
    // every time it sees a ( it pushes it on the stack, and it will only pop a ( off the stack
    // when it encounteres a ).
    public static boolean isLegal(String str)
    {
	int i;
	ListStack<Character> s = new ListStack<Character>();

	for(i = 0; i < str.length(); i++)
	    if(str.charAt(i) == '(' )
		s.push('(');
	    else if(str.charAt(i) == ')')
		s.pop();

	return s.isEmpty();
    }

    // Evaluate the expression, but the expression must be fully parenthesized
    // in other words it will not evaluate 9 + 5, but it will evaluate (9+5)
    // also it will not evaluate (8 * 4) + 7, but will evaluate ((8 * 4) + 7)

    // go thru the string and
    // if you see a number push on s1, 
    // if you see an operator push on s2
    // if you see a ) 
    //       pop operand2 and operand1 from stack 1 (in this order)
    //       then pop the operator from stack 2 and 
    //       apply the operator to the operands
    //       push the result back on stack 1
    // finally at the end print the result and pop it off of stack 1.
    public static void evaluateExpr(String str)
    {
	int i;
	ListStack<Integer> s1 = new ListStack<Integer>();
	ListStack<Character> s2 = new ListStack<Character>();

	for(i = 0; i < str.length(); i++){
	    
	    if(Character.isDigit(str.charAt(i)))
		s1.push((int)(str.charAt(i)- '0'));
	    else if(str.charAt(i) == '+' || str.charAt(i) == '-' ||
		    str.charAt(i) == '*' || str.charAt(i) == '/' ||
		    str.charAt(i) == '%')
		s2.push(str.charAt(i));
	    else if(str.charAt(i) == ')'){
		
		int opnd1, opnd2;
		char oper = s2.topAndPop();
		opnd2 = s1.topAndPop();
		opnd1 = s1.topAndPop();
		
		switch(oper){
		case '+': 
		    s1.push(opnd1 + opnd2);
		    break;
		case '-': 
		    s1.push(opnd1 - opnd2);
		    break;
		case '*': 
		    s1.push(opnd1 * opnd2);
		    break;
		case '/': 
		    s1.push(opnd1 / opnd2);
		    break;
		case '%': 
		    s1.push(opnd1 % opnd2);
		    break;
		}

	    }
	    
	}

	System.out.println("The result of the expression is: " + s1.topAndPop());

    }


}
