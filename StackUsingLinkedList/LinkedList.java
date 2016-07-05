
public class LinkedList {

	Node head;
	LinkedList()
	{
		head = null;
	}
	
	void insertNode(int val){
		Node temp = new Node();
		temp.data = val;
		if(head==null){
			head = temp;
		}
		else{
			Node curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = temp;
		}
	}
	
	void display()
	{
		if(head != null){
			Node temp;
			temp = head;
			System.out.println("Stack Contents: ");
			while(temp!=null){
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	void removeElement(int val){
		
		if(head.next==null){
			head = null;
			return;
		}
			
		
		if(head!=null){
			Node temp = head;
			while(temp.next.next!=null){
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	
	
	class Node
	{
		int data;
		Node next;
		Node(){
			data = 0;
			next = null;
		}
	}
}
