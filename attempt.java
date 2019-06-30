import java.util.*;
public class attempt
{

	public static void spop(Stack <String> stack)
	{
		System.out.println();
		if(sempty(stack) == false)
			stack.pop();
		else
			System.out.println("Cannot pop, stack is empty");
	}
	
	public static void spush(Stack <String> stack, String word)
	{
		System.out.println("Pushing: "+word);
		stack.push(word);
	}
	
	public static void speek(Stack <String> stack)
	{
		System.out.println("Top of Stack is: " + stack.peek());
	}
	
	public static boolean sempty(Stack <String> stack)
	{
		if ( stack.empty() == true)
		{
			System.out.println("Stack is empty");
			return true;
		}
		else
		{
			System.out.println("Stack is not empty");
			return false;
		}
	}
	public static void main(String args[])
	{
		Stack <String> stack = new Stack<String>();
		
		sempty(stack);
		spush(stack, "class");
		sempty(stack);
		spop(stack);
		sempty(stack);
		spop(stack);
		
				
	}
}