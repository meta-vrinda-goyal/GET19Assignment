package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketTest {

	@Test
	public void test() {
		int[] quotaOfBowler = new int[]{6,5,10};
		Cricket cricket = new Cricket(3, 10, quotaOfBowler);
	    String[] order = cricket.strategyOfBowling();
	    for(int i = 0; i<order.length; i++){
	    	System.out.println(order[i]);
	    }
	}

}
