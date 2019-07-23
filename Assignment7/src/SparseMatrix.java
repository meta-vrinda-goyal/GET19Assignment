public final class SparseMatrix {
	
	private final int[][] matrix;
	private final int rowSize;
	private final int colSize;

	public SparseMatrix(int[][] array) {
	    //store dimension of array
	    rowSize = array.length;
	    colSize = array[0].length;
	    //count non-zero element in array
	    int size = countNonZero(array);
	    this.matrix = new int[size][3];  //column length is fixed
	    int rowCount = 0;                //for storing elements in sparse matrix
	    for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array[0].length; j++) {
		    if (array[i][j] != 0){
		    //store non-zero elements in sparse matrix
			matrix[rowCount][0] = i;
			matrix[rowCount][1] = j;
			matrix[rowCount][2] = array[i][j];
			rowCount++;
		    }
		}
	    }
	}

	/**
	 * @param array 
	 * @return number count of non-zero element in array
	 */
	public static int countNonZero(int array[][]) {
	    //count non-zero elements
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array[i].length; j++) {
		    if (array[i][j] != 0){
			count++;
		    }
		}
	     }
	     return count;
	}
	
	public int[][] getMatrix() {
	    return matrix;
	}

	public int getRowSize() {
	    return rowSize;
	}

	public int getColSize() {
	    return colSize;
	}

	/**
	 * @return transpose of matrix
	 */
	public int[][] getTranspose() {
	    //transpose of sparse matrix
	    int[][] transMatrix = new int[matrix.length][3];
	    for (int i = 0; i < matrix.length; i++) {
            //interchange columns and rows of sparse matrix
		transMatrix[i][0] = matrix[i][1];
		transMatrix[i][1] = matrix[i][0];
		transMatrix[i][2] = matrix[i][2];
	    }
	    //convert in 2d matrix
	    return convertInMatrix(transMatrix, colSize, rowSize);
	}
	
	/**
	 * @return true if matrix is symmetrical else false
	 */
	public boolean isSymmetrical() {
	    //check for symmetrical
	    int i, j;
	    SparseMatrix sp = new SparseMatrix(getTranspose());
	    int[][] transMatrix = sp.getMatrix();
	    if (matrix.length == transMatrix.length) {
		for (i = 0; i < matrix.length; i++) {
		    for (j = 0; j < transMatrix.length; j++) {
			if (matrix[i][0] == transMatrix[j][0] && matrix[i][1] == transMatrix[j][1] && matrix[i][2] == transMatrix[j][2]) {
			    //check element of sparse matrix
			    break;
			}
		     }
		     if (j >= transMatrix.length){
		         return false;
		     }
		 }
		 return true;
	    }
	    return false;
	}

	/**
	 * @param array1 first array
	 * @param array2 second array
	 * @return number count of common elements in array1 and array2 
	 */
	private int commonElementCount(int[][] array1, int[][] array2) {
	    //count common elements in two array
	    int count = 0;
	    for (int i = 0; i < array1.length; i++) {
		for (int j = 0; j < array2.length; j++) {
		    if (array1[i][0] == array2[j][0] && array1[i][1] == array2[j][1]){
			count++;
		    }
		}
	    }
	    return count;
	}

	/**
	 * @param sp sparse matrix
	 * @return add matrix of sp with matrix of class 
	 */
	public int[][] addMatrix(SparseMatrix sp) {
	    //check addition condition of matrix
	    if (rowSize == sp.getRowSize() && colSize == sp.getColSize()) {
                int[][] matrix2 = sp.getMatrix();
		int commonElements = commonElementCount(matrix, matrix2);
		//initialize result matrix
		int[][] result = new int[matrix.length + matrix2.length - commonElements][3];
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < 3; j++){
		        //put one matrix in result matrix
		        result[i][j] = matrix[i][j];
		    }
		}
		for (int i = 0; i < matrix2.length; i++) {
		    int j;
		    for (j = 0; j < matrix.length; j++) {
		        if (matrix2[i][0] == result[j][0] && matrix2[i][1] == result[j][1]) {
			     //add common element of matrix2 in result matrix
			     result[j][2] += matrix2[i][2];
			     break;
		        }
		    }
		   if (j >= matrix.length) {
			//add non common elements in result matrix
			result[matrix.length + i][0] = matrix2[i][0];
			result[matrix.length + i][1] = matrix2[i][1];
			result[matrix.length + i][2] = matrix2[i][2];
		   }
		}
		return convertInMatrix(result, rowSize, colSize);
	    } 
	   else{
		throw new AssertionError("dimensions not equal");
	   }
	}

	/**
	 * @param sp sparse matrix
	 * @return multiply of matrix of sp with class matrix
	 */
	public int[][] multiplyMatrix(SparseMatrix sp){
	    //check condition of multiplication of matrix
	    if(colSize == sp.getRowSize()){
	        int[][] result = new int[rowSize][sp.getColSize()];
		int[][] matrix2 = new SparseMatrix(sp.getTranspose()).getMatrix();
		for(int i = 0; i<matrix.length; i++){
		    for(int j =0; j<matrix2.length; j++){
			if( matrix[i][1] == matrix2[j][1] ){
			    //multiply elements of matrix
			    result[matrix[i][0]][matrix2[j][0]] += matrix[i][2]*matrix2[j][2];
			}
		    }
		}
		return result;
	     }
	     else{
	         throw new AssertionError("multiply condition not satisfied");
	     }
	}
	
	/**
	 * @param sparseMatrix
	 * @param row
	 * @param col
	 * @return matrix of sparse matrix
	 */
	public int[][] convertInMatrix(int[][] sparseMatrix,int row,int col){
	    //convert sparse matrix to matrix
	    int[][] result=new int[row][col];
	    for(int i = 0; i<sparseMatrix.length; i++){
	        result[sparseMatrix[i][0]][sparseMatrix[i][1]] = sparseMatrix[i][2];	
	    }
	    return result;
	}
}
