#include <iostream>

using namespace std;

int main()
{
	int arr[] = {5,8,1,3,9,6,20,28,22,90,0,7};
	int size = sizeof(arr)/sizeof(arr[0]);
	int min = 0;

	for(int i=0;i<size;i++){
		min = arr[i];
		int tempI;
		for(int j=i+1;j<size;j++){
			if(arr[j] < min){
				min = arr[j];
				tempI  = j;
				}
		}
		if(tempI!=i){
			int temp;
			temp = arr[i];
			arr[i] = arr[tempI];
			arr[tempI] = temp;
		}
	}

	for(int i=0;i<size;i++){
		cout << arr[i]  << " ";
	}
}

