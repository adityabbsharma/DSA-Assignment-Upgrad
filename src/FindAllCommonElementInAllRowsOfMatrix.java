/*
* Find All Common Element in Each Row of Matrix
Description
Given an M x N matrix of integers, find all the common elements that are present in all rows of the
* given matrix in O(M * N) time.

For example, take a look at the matrix given below.

11 12 11 14 18

13 17 18 15 11

18 17 17 13 11

18 11 12 17 19

In this matrix, 11 and 18 appear in each row. Hence, 11 and 18 will be the common elements that are present in each row.


Note that if multiple common elements are present in each row, you need to print them in ascending order.

Input Format:

The first line contains two integers M as the number of rows and N as the number of columns.

From the next line, there are N elements in a line up to M lines, representing the elements of the matrix.


Output Format:

The output contains all the common elements that are present in each row of the given matrix,
* printed in ascending order.

Sample Test Cases:

Input:

4 5

11 12 11 14 18

13 17 18 15 11

18 17 17 13 11

18 11 12 17 19

Output:

11 18

Input:

4 4

17 12 11 10

13 17 10 15

10 17 17 13

12 11 10 17

Output:

10 17
* */
import java.util.*;
public class FindAllCommonElementInAllRowsOfMatrix {
    public static void printElementInAllRows(int mat[][]) {

        // Write code here
//        HashSet<Integer> hSet = new HashSet<>();
        ArrayList<TreeSet> hashSetArrayList = new ArrayList<>();
        TreeSet<Integer> resultSet = new TreeSet<>();
        int sizeofFirstArray = mat[0].length;
        for(int i=0;i<mat.length;i++){
            TreeSet<Integer> hSet = new TreeSet<>();
            for(int j=0;j<mat[i].length;j++){
                hSet.add(mat[i][j]);
            }
            hashSetArrayList.add(hSet);
        }
        Iterator<Integer> itr = hashSetArrayList.get(0).iterator();
        while(itr.hasNext()){
            int k = itr.next();
            boolean containedFlag=true;
            for(int i=1;i<mat.length;i++){
                if(!hashSetArrayList.get(i).contains(k))
                    containedFlag= false;
            }
            if(containedFlag)
                resultSet.add(k);
        }
        for(Integer j: resultSet){
            System.out.print(j+" ");
        }

    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}
