#include <iostream>

using namespace std;

void quicksort(int arr[],int low,int high);
int sort(int arr[],int low,int high);

int main(){
//	int arr[]={5,8,1,3,9,6};
//	int arr[]={3,1,2};
	int arr[] = {4,12,7,300,543,12,67,22,98,56,24,78,11};
	int size = sizeof(arr)/sizeof(arr[0]);
	quicksort(arr,0,size-1);
	for(int i=0;i<size;i++)
		cout << arr[i]<<" ";
	return 0;
}

void quicksort(int arr[],int low,int high){
//	int mid = (low+high)/2;
	int loc;
	if(low < high){
		loc = sort(arr,low,high);
		quicksort(arr,low,loc-1);
		quicksort(arr,loc+1,high);
	}

}

int sort(int arr[],int low,int high){

	int pivote = arr[high];
	int i = low;
	int j = high - 1;

	while(i<j){
		if(arr[i]>=pivote && arr[j]<=pivote){
			int t;
			t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;j--;
		}
		else if(arr[i] < pivote)
			i++;
		else if(arr[j] > pivote)
			j--;
	}
	if(arr[i] <= arr[high])
		i++;
	int t = arr[i];
	arr[i] = arr[high];
	arr[high] = t;
	return i;
}
