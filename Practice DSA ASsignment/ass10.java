import java.util.Scanner;

public class ass10 {

    //Is safe function
    public static boolean isSafe(char chessBorad[][] , int row , int col){

        //vertically up
        for(int i=row-1;i>=0;i--){
           if(chessBorad[i][col] =='Q') {
            return false;
           } 
        }

        //left diagonal up
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i-- , j--){
           if (chessBorad[i][j]=='Q'){
            return false;
           } 
        }

        //right diagonal up 
        for(int i=row-1 , j=col+1; i >=0 && j<chessBorad.length;i-- , j++){
            if(chessBorad[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    //main Queen function

    public static void nQueen(char chessBorad[][] , int row){
        if(row==chessBorad.length){
            printChessBoard(chessBorad);
            count++;
        }

        //column loop

        for(int j=0;j<chessBorad.length ; j++){
            //check is safe
            if(isSafe(chessBorad, row, j)){
                chessBorad[row][j]='Q';
                nQueen(chessBorad, row+1);
                chessBorad[row][j]='X';   //backtracking
            }
        }
    }

    //Print chess Board 
    public static void printChessBoard(char chessBorad[][]){

        System.out.println("-------------------Chess Board --------------------");
        for(int i=0;i<chessBorad.length ; i++){
            for(int j=0;j<chessBorad.length;j++){
                System.out.print(chessBorad[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int count=0;
    //main function
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the chessboard size : ");
        int n=sc.nextInt();

        char chessBorad[][]=new char[n][n];

        //Intialize with "X"
        for(int i=0;i<chessBorad.length ; i++){
            for(int j=0;j<chessBorad.length;j++){
                chessBorad[i][j]='X';
            }
        }

        nQueen(chessBorad, 0);
        System.out.println();
        System.out.println("Total count of solutions : "+count);
    }
}
