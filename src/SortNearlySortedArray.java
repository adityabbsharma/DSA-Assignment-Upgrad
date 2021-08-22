/*
*
Sort Nearly Sorted Array
* Description
Given a k-sorted array of n elements, where each element is at most k steps away from its target position
* as it would have been in an array that is sorted in ascending order. Write a program to sort the array
* in O(n log k) time.

For example, an element at index i in an array that was sorted in ascending order can be found at
* indexes i - 3, i - 2, i - 1, i, i + 1, i + 2 and i + 3 in the given k-sorted array.

Input Format:

The first line contains an integer ‘N’ as the size of the array.

The second line contains an integer ‘K’ representing the maximum number of steps that each element can
* deviate from its target position as it would have been in an array that is sorted in ascending order.

The third line contains the elements of the k-sorted array.

Output Format:

The output contains the elements of the array that is sorted in ascending order.

Sample Test Cases:

Input:

7

3

7 6 4 3 9 11 10

Output:

3 4 6 7 9 10 11

Input:

7

3

6 5 3 2 8 10 9

Output:

2 3 5 6 8 9 10
* */
import java.util.*;
import java.util.stream.Collectors;

public class SortNearlySortedArray {
    private static void sortArray(int[] arr, int k) {

        //-------------first approach without using min heap but with nlogk time complexity-

        // we will keep a window of size k, starting from start index 0,
        // first sort this window. next move the window 1 step ahead compare the k+1th element
        // by doing binary search and insert in correct position.then move the window 1 step again
        // repeat the process. til we reach last element- logk is the binary search time and in total nlogk
        int[] kWindow = new int[k+1];
        for(int i=0;i<=k;i++){
            kWindow[i] = arr[i];
        }
        Arrays.sort(kWindow);
        for(int i=0;i<=k;i++){
            arr[i] = kWindow[i];
        }
        Integer[] boxedArray = Arrays.stream(kWindow).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, boxedArray);

        for(int i= k+1;i<arr.length;i++){
            int startIndexOfKWindowArr = i-(k+1);
            int endIndexOfKWindowArr = i-1;
            int leftIndex = startIndexOfKWindowArr;
            int rightIndex = endIndexOfKWindowArr;
            int midIndex=0;
            while(leftIndex<rightIndex){
                if(leftIndex+1==rightIndex){
                    if(arr[i]>list.get(leftIndex) && arr[i]<list.get(rightIndex)){
                        midIndex=leftIndex+1;
                    }
                    else if(arr[i]>list.get(rightIndex))
                        midIndex = rightIndex+1;
                    else if(arr[i]== list.get(leftIndex))
                        midIndex = leftIndex;
                    else if(arr[i]== list.get(rightIndex))
                        midIndex = rightIndex;
                    else if(arr[i]<list.get(leftIndex))
                        midIndex = leftIndex;
                    break;
                }
                if(arr[i] == list.get(midIndex)){
                    break;
                }
                if(arr[i]>=list.get(rightIndex) ){
                    midIndex = i;
                    break;
                }
                if(arr[i]<=list.get(leftIndex)){
                    midIndex=leftIndex;
                    break;
                }
                midIndex = (rightIndex+leftIndex)/2 ;
                if(arr[i]>list.get(midIndex)){
                    if(leftIndex == rightIndex-1){
                        midIndex++;
                        break;
                    }
                    leftIndex = midIndex+1;
                }
                else if(arr[i]<list.get(midIndex)){
                    if(leftIndex == rightIndex-1){
                        midIndex--;
                        break;
                    }
                    rightIndex = midIndex-1;
                }
            }
            list.add(midIndex,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        //------------------------- second apporoach using minheap or priority queue
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i=0;i<arr.length;i++){
//            pq.add(arr[i]);
//        }
//        Iterator<Integer> it = pq.iterator();
//        int i=0;
//        while(it.hasNext()){
//            arr[i++] = pq.poll();
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
