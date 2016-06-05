
public class Solution {

	public static void main(String[] argc)
	{
		//System.out.println("Hay");
		
		Stack myStack = new Stack();
		myStack.push(10);
		myStack.push(20);
		
		myStack.displayStack();
		
		myStack.pop();
		myStack.displayStack();
		myStack.push(30);
		myStack.push(40);
		myStack.push(50);
		myStack.push(60);
		myStack.displayStack();
		myStack.pop();
		myStack.displayStack();
	}
}
