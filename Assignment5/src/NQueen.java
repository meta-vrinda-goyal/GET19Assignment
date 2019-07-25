
public class NQueen {
	/**
	 * @param board : 2d matrix
	 * @param dimensionOfMatrix
	 */
	void printBoard(int board[][], int dimensionOfMatrix ){ 
        for (int i = 0; i < dimensionOfMatrix; i++){ 
            for (int j = 0; j < dimensionOfMatrix; j++){ 
                System.out.print(" " + board[i][j] + " "); 
            }
            System.out.println(); 
        } 
    } 
	
	/**
	 * @param board : matrix
	 * @param row : current row of matrix at which we are looking to place a queen
	 * @param col : current column of matrix at which we are looking to place a queen
	 * @param dimensionOfMatrix
	 * @return boolean : true if it is valid to place queen else false
	 */
	boolean  isValidToPlaceQueen(int board[][], int row, int col,int dimensionOfMatrix){ 
	     int i, j; 
	     // If queen exist in upper row 
	     for (i = row-1; i >= row; i--){ 
	         if (board[i][col] == 1){    
	             return false;
	         }
	     }
	     //if queen exist in upper left diagonal
	     for (i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
	         if (board[i][j] == 1){ 
	             return false;   
	         }
	     }
	     //if queen exist in upper right diagonal   
	     for (i = row, j = col; i >= 0 && j < dimensionOfMatrix; i--, j++){ 
	    	 if (board[i][j] == 1){ 
	    		 return false;    
	    	 }
	     }
	     return true; // if it is valid to place a queen
	 }
	
	/**
	 * @param board
	 * @param startRow row at which we need to place a queen
	 * @param dimensionOfMatrix
	 * @return true if solution exist else false
	 */
	boolean nQueen(int[][] board,int startRow,int dimensionOfMatrix){
		if (startRow >= dimensionOfMatrix){     // if all rows are filled with queens then solution exist 
			printBoard(board,dimensionOfMatrix);
			return true;
		}
		for (int i = 0; i < dimensionOfMatrix; i++){ 
		// check if valid then place queen 
	        if (isValidToPlaceQueen(board,startRow,i,dimensionOfMatrix)){ 
	            board[startRow][i] = 1; 
	            	//RECURSIVE CALL with next row as starting row
	                if (nQueen(board, startRow + 1, dimensionOfMatrix)){
	                	return true; 
	                }
	                board[startRow][i] = 0; // BACKTRACK
	        } 
	    } 
		return false;
	}
}
