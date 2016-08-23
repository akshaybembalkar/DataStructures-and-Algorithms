import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        HashMap<Integer,Integer> myMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int t = 0;
        t = sc.nextInt();
        while(t>0){
            myMap.clear();
            int m = 0,n = 0;
            int[] arr;
            sc.nextLine();
            m = sc.nextInt();
            n = sc.nextInt();
            sc.nextLine();   
            //System.out.print(m);
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                myMap.put(0,0);
            }
            int val = 0;
            for(int i=0;i<n;i++){
                int k = m - (arr[i]);
             if(myMap.containsKey(k) && arr[i]!=m){
                 val = myMap.get(k);
                 if(i<val)
                    System.out.println((i+1)+" "+val);
                 else
                     System.out.println(val+" "+(i+1));
                 break;
             }
             else{
                 myMap.put(arr[i],i+1);
             }
            }
            
            t--;
        }
        
    }
}