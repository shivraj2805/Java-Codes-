public class SudokoSolver {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        //Row
        for(int i=0;i<=8;i++){
            if(sudoku[row][i]==digit){
                return false;
            }

        //sudoko
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;sc++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
        }
    }
    public static boolean sudokusolver(int sudoko[][],int row , int col){
        //base case 
        if(row ==9 && col==0){
            return true;
        }
        
        //Recursion
        int nextRow = row , nextCol=col+1;
        if(col+1=9){
            nextRow=row+1;
            nextCol=0;

        }
        if(sudoko[row][col]!=0){
            return sudokusolver(sudoko, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoko, row, col, digit)){
                sudoko[row][col]=digit;

                if(sudokusolver(sudoko,nextRow,nextCol)){
                    return true;
                }
                sudoko[row][col]=0;
            }
        }
        return false;
    }
    //print sudoko

    //main function
    }
