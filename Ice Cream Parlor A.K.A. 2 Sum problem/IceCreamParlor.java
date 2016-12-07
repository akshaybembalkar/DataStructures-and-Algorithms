/*
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together m
 * dollars for ice cream. On any given day, the parlor offers a line of flavors. 
 * Each flavor, i, is numbered sequentially with a unique ID number from 1 to n and 
 * has a cost, ci, associated with it.

 * Given the value of m and the cost of each flavor for t trips to the Ice Cream Parlor, 
 * help Sunny and Johnny choose two flavors such that they spend their entire pool of money
 * (m) during each visit. For each trip to the parlor, print the ID numbers for the two 
 * types of ice cream that Sunny and Johnny purchase as two space-separated integers on 
 * a new line. You must print the smaller ID first and the larger ID second.

Note: Two ice creams having unique IDs i and j may have the same cost
 * 
 * 
 * 
 * 
 * 
 */



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