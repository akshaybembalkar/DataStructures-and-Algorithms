
public class Stack {
	
	int top;
	LinkedList list;
	Stack()
	{
		top = -1;
		list = new LinkedList();
	}
	
	void push(int element)
	{
		list.insertNode(element);
		top = list.head.data;
	}
	
	void displayStack()
	{
		list.display();
	}
		
	void pop()
	{
		list.removeElement(top);
		if(list.head !=null)
			top = list.head.data;
	}
	
}
