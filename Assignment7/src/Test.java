public class Test {
	public static void main(String ar[]) {
		SparseMatrix sp = new SparseMatrix(new int[][] { { 1, 0 }, { 0, 1} });
		for (int i = 0; i < sp.getMatrix().length; i++) {
			for (int j = 0; j < sp.getMatrix()[0].length; j++) {
				System.out.print(sp.getMatrix()[i][j] + "  ");
			}
			System.out.println("");
		}
		
		System.out.println("\n");
		SparseMatrix sp2 = new SparseMatrix(new int[][] { { 2, 0 }, { 0, 2 } });
		for (int i = 0; i < sp2.getMatrix().length; i++) {
			for (int j = 0; j < sp2.getMatrix()[0].length; j++) {
				System.out.print(sp2.getMatrix()[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
		int[][] tr=sp.transpose();
		for (int i = 0; i < tr.length; i++) {
			for (int j = 0; j < tr[0].length; j++) {
				System.out.print(tr[i][j] + "  ");
			}
			System.out.println("");
		}
		if(sp.isSymmetrical())
			System.out.println("ok");
		System.out.println("");
		
		int[][] tr1=sp.addMatrix(sp2 );
		for (int i = 0; i < tr1.length; i++) {
			for (int j = 0; j < tr1[0].length; j++) {
				System.out.print(tr1[i][j] + "  ");
			}
			System.out.println("");
		}
		
		int[][] tr11=sp.multiplyMatrix(sp2 );
		for (int i = 0; i < tr11.length; i++) {
			for (int j = 0; j < tr11[0].length; j++) {
				System.out.print(tr11[i][j] + "  ");
			}
			System.out.println("");
		}
		
	}
}
