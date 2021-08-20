/*
* Find kth Largest Element in a Stream
Given an infinite stream of integers, find the kth largest element at any point in time.
Hint: If you keep the stream sorted somehow at all times, it becomes easier to detect the kth largest number
* at any given point in time.

Input Format:

The first line contains an integer ‘N’ as the size of the stream.

The second line contains an integer ‘K’ representing the position of the largest number.

The third line contains elements of the stream of size ‘N’.



Output Format:

The output contains the kth largest number at any point in time. If the kth largest number does not exist, then print ‘None’ (without quotes and with capital letter ‘N’).



Sample Test Cases:

Input:

8

3

20 30 21 80 60 50 110 15



Output:

None

None

3 largest number is 20

3 largest number is 21

3 largest number is 30

3 largest number is 50

3 largest number is 60

3 largest number is 60



Explanation: As and when the stream of integers arrives, we can output the kth largest no. Here, the initial number of elements is 8 and we need to find the 3rd largest number at all times as and when the integers arrive in the stream. Let us see the stream at every iteration as and when the integers arrive:
1st iteration: 20

2nd iteration: 20 30

3rd iteration: 20 30 21

4th iteration: 20 30 21 80

5th iteration: 20 30 21 80 60

6th iteration: 20 30 21 80 60 50

7th iteration: 20 30 21 80 60 50 110

8th iteration: 20 30 21 80 60 50 110 15



Let us now see what the 3rd largest number is in each iteration:

1st iteration: 3rd Largest among [20] = None

2nd iteration: 3rd Largest among [20 30] = None

3rd iteration: 3rd Largest among [20 30 21] = 20

4th iteration: 3rd Largest among [20 30 21 80] = 21

5th iteration: 3rd Largest among [20 30 21 80 60] = 30

6th iteration: 3rd Largest among [20 30 21 80 60 50] = 50

7th iteration: 3rd Largest among [20 30 21 80 60 50 110] = 60

8th iteration: 3rd Largest among [20 30 21 80 60 50 110 15] = 60



Thus, our output then becomes:

None

None

3 largest number is 20

3 largest number is 21

3 largest number is 30

3 largest number is 50

3 largest number is 60

3 largest number is 60
* */
import java.util.*;
public class KthLargestElementInAStream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {

            stream[i] = sc.nextInt();
            int temp = kthLargest(k,stream[i]);
            if(temp!=-1){
                System.out.println(k+" largest number is "+temp);
            }
            else
                System.out.println("None");

        }
// Write code here

    }
    static Stack<Integer> stackMain = new Stack<>();

    public static int kthLargest(int k,int num){
        Stack<Integer> stackTemp = new Stack<>();
        if(stackMain.isEmpty()){
            stackMain.push(num);
            return stackMain.size()<k?-1:k;
        }
        else{
            while(!stackMain.isEmpty()){
                if(num<stackMain.peek()){
                    int temp = stackMain.pop();
                    stackTemp.push(temp);
                }
                else
                    break;
            }
            stackMain.push(num);
            while(!stackTemp.isEmpty()){
                stackMain.push(stackTemp.pop());
            }
            int count=0,kThLargest=0;
            while(!stackMain.isEmpty()){
                if(count<k){
                    kThLargest = stackMain.pop();
                    stackTemp.push(kThLargest);
                    count++;
                }
                else
                    break;
            }
            while(!stackTemp.isEmpty()){
                stackMain.push(stackTemp.pop());
            }
            //System.out.println(stackMain);
            return stackMain.size()<k?-1:kThLargest;
//            return kThLargest;
        }
    }

}
