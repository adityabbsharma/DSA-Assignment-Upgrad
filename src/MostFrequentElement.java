/*
* Most Frequent Element
Description
Given an array of integers, find the most frequent element in the array. If multiple elements appear a
* maximum number of times, print any one of them. Return -1 in case there are no elements.

Input Format:

The first line contains the size of the array, N.

The second line contains the elements of the array.

Output Format:

The output contains the most frequent element in the array.

Sample Test Cases:

Input:

8

1 3 2 5 2 1 9 2

Output:

2

Input:

8

10 15 12 11 13 12 11 11

Output:

11
* */
import java.util.*;
public class MostFrequentElement {
    public static int mostFrequentElement(int[] arr) {

        // Write code here
        if(arr.length==0)
            return -1;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],1);
            }
            else{
                int count = hashMap.get(arr[i]);
                hashMap.put(arr[i],++count);
            }
        }
        int maxCount=0,maxOccuredElement=0;
        for(Integer key:hashMap.keySet()){
            if(maxCount<hashMap.get(key)){
                maxCount = hashMap.get(key);
                maxOccuredElement = key;
            }
        }
        return maxOccuredElement;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }

}
