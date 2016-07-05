#include <iostream>

using namespace std;

int main()
{
	int arr[] = {8,5,1,3,9,6,20,28,22,90,0,7};
	int size = sizeof(arr)/sizeof(arr[0]);
	int key = 0;
	int j = 0;

	for(int i=1;i<size;i++){
		key = arr[i];
		j = i;

		while(j > 0 && key < arr[j-1]){ //To sort array in descending order, change to key > arr[j-1]
			int temp;
			temp = arr[j];
			arr[j] = arr[j-1];
			arr[j-1] = temp;
			j--;
		}
	}

	for(int i=0;i<size;i++){
		cout << arr[i]  << " ";
	}
}
