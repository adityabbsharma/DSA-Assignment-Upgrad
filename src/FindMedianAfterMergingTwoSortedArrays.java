/*
* Find Median After Merging Two Arrays
Description
Write a program to find the median of the array obtained after merging the two given sorted integer arrays of the same length.
* Note that both the arrays are sorted.

Input Format:

The first line contains an integer N as the size of both the arrays.

The second line contains elements of the first array of size N.

The next line contains elements of the second array of size N.

Output Format:

Print the median of the array obtained after merging the two given integer arrays.

Sample Test Cases:

Input:

5

1 12 15 26 38

2 13 17 30 45

Output:

16
* */
import java.util.*;
public class FindMedianAfterMergingTwoSortedArrays {
    public static int median(int[] arr1, int[] arr2 , int n){

        // Write code here
        int[] resultArr = new int[2*n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr1[i]);
        }
        for(int i=0;i<n;i++){
            pq.add(arr2[i]);
        }
        int i=0;
        while(!pq.isEmpty()){
            resultArr[i] = pq.remove();
            i++;
        }
        return (resultArr[n-1]+resultArr[n])/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, n));
    }
}
