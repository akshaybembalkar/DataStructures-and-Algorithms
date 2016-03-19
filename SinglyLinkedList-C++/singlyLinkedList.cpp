#include<iostream>


using namespace std;

struct Node{
	int data;
	Node* next;
};

Node* head = NULL;

Node* sizeAllocate();
void insertNode(int);
void displaylist();
void deleteNode(int);
bool searchNode(int);

int main()
{
	
	int ch,value;
	char choice;
	do{
		cout<<"\n1. Insert Node\n2. Display List\n3. Delete Node\n4. Search Node";
		cout<<"\nEnter your choice: ";
		cin>>ch;

		switch(ch)
		{
			case 1: 
				insertNode(10);
				insertNode(20);
				insertNode(30);
				insertNode(40);
				/*cout<<"\nEnter value to insert: ";
				cin>>value;
				insertNode(value);*/
				break;
			case 2: cout<<"\nYour list: "<<endl;
				displaylist();
				break;
			case 3: cout<<"\nEnter value to delete: ";
				cin>>value;
				deleteNode(value);
				break;
			case 4: cout<<"\nEnter value to search: ";
				cin>>value;
				cout<<"Searching... "<<endl;
				if(searchNode(value))
					cout<<"Node found"<<endl;
				else
					cout<<"Not found"<<endl;
				break;
			default:cout<<"Wrong Choice: "<<endl;
				break;
		}
		cout<<"Continue ? (y/n): ";
		cin>>choice;

	}while(choice=='y');
	

	
	


	Node* temp = head;;
	while(head!=NULL){
		temp = head;
		head = head->next;
		delete[] temp;
	}

	return 0;
}

struct Node* sizeAllocate(){
	Node* temp;
	temp = new Node[sizeof(struct Node)];
	return temp;
}

void insertNode(int val)
{
	Node *temp = sizeAllocate();
	Node *curr = head;
	temp->data = val;
	if(head==NULL){
		head = temp;
		return;
	}
	else{
		while(curr->next!=NULL)
			curr = curr->next;
		curr->next = temp;
	}

}

void displaylist(){

	Node* curr = head;
	
	while(curr!=NULL){
		cout<<curr->data<<" ";
		curr = curr->next;
	}
	cout<<endl;
}

void deleteNode(int val)
{
	Node* curr = head;
	Node* temp;
	if(curr==NULL)
		return;

		while(curr!=NULL){
			if(curr->data==val){
				head = head->next;
				delete[] curr;
				curr = head;
				continue;
			}
			if(curr->next!=NULL){
			if(curr->next->data == val){
				temp = curr->next;
				curr->next = curr->next->next;
				delete[] temp;
			}
			}
			curr = curr->next;
		}
	return;
}
bool searchNode(int val)
{
	if(head->data==val)
		return true;
	else
	{
		Node* curr = head;
		while(curr->next!=NULL){
			curr = curr->next;
			if(curr->data==val)
				return true;
		}
		return false;
	}

}
