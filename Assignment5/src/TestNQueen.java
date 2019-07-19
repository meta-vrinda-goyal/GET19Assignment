import static org.junit.Assert.*;

import org.junit.Test;


public class TestNQueen {

	@Test
	public void testWhenSolExist() {
		NQueen Queen = new NQueen(); 
		int dimensionOfMatrix = 4;
		int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		assertTrue(Queen.nQueen(board,0,dimensionOfMatrix));
		
	}
	@Test
	public void testWhenSolNotExist() {
		NQueen Queen = new NQueen(); 
		int dimensionOfMatrix = 3;
		int [][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		assertFalse(Queen.nQueen(board,0,dimensionOfMatrix));
	}

}
