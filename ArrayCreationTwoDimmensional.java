import java.util.*;
public class ArrayCreationTwoDimmensional {

    public static void SearchingElement(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(key==matrix[i][j]){
                    System.out.println(key + " is found at index "+"("+i+","+j+")");
                }else{
                    System.out.println("Not found");
                }
            }}
    }

    public static void MaxAndMin(int matrix[][]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>max){
                    max=Math.max(matrix[i][j],max);
                }
                if(matrix[i][j]<min){
                    min=Math.min(matrix[i][j], min);
                }
            }}
            System.out.println("max : "+max);
            System.out.println("min : "+min);

    }
    public static void PrintSpiralMatrix(int matrix[][]){
        int startRow=0;
        int startcol =0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;

        while(startRow<=endRow && startcol <= endCol){
            //top
            for(int j=startcol;j<=endCol;j++){
                System.out.print(matrix[startRow][j]+" ");
            }

            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }

            //bottom
            for(int j=endCol-1;j>=startcol;j--){
                System.out.print(matrix[endRow][j]+" ");
            }

            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                System.out.print(matrix[i][startcol]+" ");
            }

            startRow++;
            startcol++;
            endCol--;
            endRow--;
        }
    }

    public static void diagonalSum(int matrix[][]){
        int PriSum=0;
        int SecSum=0;
        int DiagSum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j){
                    PriSum+=matrix[i][j];
                }
                if(i+j==matrix.length-1){
                    SecSum+=matrix[i][j];
                }
            }
        }
        DiagSum=PriSum+SecSum;
        System.out.println("Diagonal Sum :" + DiagSum);
    }
    public static boolean StaircaseSearching(int matrix[][],int key){
        int row=0;
        int col=matrix[0].length-1;

        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.println(key + " Found At "+"("+row+","+col+")");
                return true;
            }else if(key<matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Key Not Found");
        return false;

    }

    public static void foundSeven(int matrix[][]){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==7){
                    count++;
                }
            }
        }
        System.out.println("Count of 7 : "+count);

    }
    public static void SumOf2ndRow(int matrix[][]){
        int sum=0;
        for(int j=0;j<matrix[0].length;j++){
           sum+=matrix[1][j];
        }
        System.out.println(sum);
    }
    public static void transpose(int matrix[][]){
        int arr[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               arr[i][j]=matrix[j][i];
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int matrix[][]=new int [3][3];

        int n=matrix.length;
        int m=matrix[0].length;
        //2D array Input
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        //output of array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }

       // System.out.println("Enter element do you want to search : ");
       // int key = sc.nextInt();
       // SearchingElement(matrix, key);
        //MaxAndMin(matrix);
        //PrintSpiralMatrix(matrix);
        //diagonalSum(matrix);
        //StaircaseSearching(matrix, key);
       // foundSeven(matrix);
       //SumOf2ndRow(matrix);
       transpose(matrix);
    }
}
