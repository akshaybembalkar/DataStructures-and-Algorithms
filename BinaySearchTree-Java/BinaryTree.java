import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BinaryTree {
    public Node root;
   
    List<Node> list = new ArrayList<Node>();
       
    HashMap<Integer,List<Integer>> myMap = new HashMap<Integer,List<Integer>>();;

    public BinaryTree() {
        this.root = null;
    }


    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }

    }
    public void display(Node root) {
    	if(root!=null){
    	System.out.print(root.data+" ");
    	display(root.left);
    	display(root.right);
    	}
    }

    public void display() {
    	int key,value;
        BFS();
      //  display(this.root);
        for(HashMap.Entry<Integer,List<Integer>> entry : myMap.entrySet()){
                key = entry.getKey();
                System.out.print(key+"->");
                for(int j=0;j<entry.getValue().size();j++){
                	value = entry.getValue().get(j);
                    System.out.print(":"+value);
                }    
             System.out.println();
        }
     }

    
    public boolean search(Node rt,int input){
    	if(input==rt.data){
    		return true;
    	}
    	else if(input < rt.data){
    		if(rt.left==null)
    			return false;
    		else
    			return search(rt.left,input);
    	}
    	else if(input > rt.data){
    		if(rt.right==null)
    			return false;
    		else
    			return search(rt.right,input);
    	}
    	return false;
    	
    }
  
    Node deleteNode(Node root, int key)
    {
        // base case
        if (root == null) return root;
     
        // If the key to be deleted is smaller than the root's key,
        // then it lies in left subtree
        if (key < root.data)
            root.left = deleteNode(root.left, key);
     
        // If the key to be deleted is greater than the root's key,
        // then it lies in right subtree
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
     
        else
        {
            // node with only one child or no child
            if (root.left == null)
            {
                Node temp = root.right;
                //free(root);
                this.root = temp;
                myMap.clear();
                return temp;
            }
            else if (root.right == null)
            {
                Node temp = root.left;
                //free(root);
                this.root = temp;
                myMap.clear();
                return temp;
            }
     
          //If node to be deleted have two children, get smallest right child.
            Node temp = minValueNode(root.right);
            root.data = temp.data;
            // Delete the inorder successor
            root.right = deleteNode(root.right, temp.data);
        }
        this.root = root;
        myMap.clear();
        return root;
    }
    
    Node minValueNode(Node node)
    {
        Node current = node;
     
        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;
     
        return current;
    }
    
    public void BFS(){

        int level = 0;
        Node previous = null;
        //LinkedList<Integer> levelList= new LinkedList<Integer>();
        boolean flag = false;
        List<Integer> levelList = new ArrayList<Integer>();
        //myMap.put(level,this.root);
        list.add(this.root);
        //levelList.add(this.root.data);
        //myMap.put(level, levelList);
        while(!list.isEmpty()){
        	if(flag==false){
        		
        		//flag = true;
        	}
            //Node n = list.get(0);
            Node n = list.remove(0);
            if(previous!=null) {
                if (n.data < previous.data) {
                    level++;
                  //  levelList.clear();
                    //flag = false;
                    levelList = new ArrayList<Integer>();
                }
                else{
                	flag = true;
                }
            }
            previous = n;
            levelList.add(n.data);
            myMap.put(level, levelList);
            
            if (n.left !=null)
            {
                list.add(n.left);//enqueue the left child
            }
            if (n.right !=null)
            {
                list.add(n.right);//enque the right child
            }

        }
    }
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
