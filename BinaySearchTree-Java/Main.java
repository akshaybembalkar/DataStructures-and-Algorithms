import java.util.Scanner;

public class Main {
	static BinaryTree obj;
	static char choice;
	static int ch;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		obj = new BinaryTree();
		try{
		do{
		System.out.println("Menu For Binary Search Tree (Values in Integer)");
		System.out.println("1. Insert Node\n2. Display\n3. Search Node\n4. Delete Node\n5. DFS Display");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Your Choice: ");
		ch = scanner.nextInt();
		
		switch(ch){
		
		case 1:
			System.out.print("Enter Node value: ");
			obj.insert(scanner.nextInt());
			
			break;
			
		case 2:
			obj.display(obj.root);
			break;
			
		case 3:
			System.out.print("Enter Node to search: ");
			try{
			if(obj.search(obj.root,scanner.nextInt()))
				System.out.println("Node Found");
			else
				System.out.println("Cannot Find node");
			}catch(NullPointerException e){
				
			}
			break;
			
		case 4:
			System.out.print("Enter Node to Delete: ");
			obj.deleteNode(obj.root,scanner.nextInt());
			break;
			
		case 5:
			try{
			obj.display();
			}catch(NullPointerException e){
				
			}
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		System.out.print("Do you wanna continue (y/n): ");
		choice = scanner.next().charAt(0);
		}while(choice=='y');
		}catch(Exception InvalidChoiceException){
			System.out.println("Invalid choice");
		}
		
	}

}
