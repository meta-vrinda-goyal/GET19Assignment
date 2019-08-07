package Question3;

public class Cricket {
	// bowler array 
	Bowler[] bowlers;
	int noOfBowlers;
	int totalBalls;
	//array storing order
	String [] orderOfBowler;
	MaxHeap maxHeap ;
   
	public Cricket(int noOfBowlers, int totalBalls, int [] quotaOfBowler ) {
		this.noOfBowlers = noOfBowlers;
		this.totalBalls = totalBalls;
		bowlers = new Bowler[noOfBowlers];
		int sumOfBalls = 0;
		for(int i = 0; i<noOfBowlers; i++){
			Bowler bowler = new Bowler("Bowler" + (i+1),quotaOfBowler[i]);
			bowlers[i] = bowler;
			sumOfBalls += quotaOfBowler[i];
		}
		if(sumOfBalls >= totalBalls){
			maxHeap = new MaxHeap(noOfBowlers);
			for (int i = 0; i< noOfBowlers; i++){
				maxHeap.insert(bowlers[i]);
			}
		}
		else {
			throw new AssertionError("Invalid input");
		}
		
	}
	
    /**
     * @return string of bowler with their bowling order
     */
    public String[] strategyOfBowling(){
		orderOfBowler =  new String[totalBalls];
		for(int i = 0; i<totalBalls; i++){
		    Bowler bowler = maxHeap.extractMax();
		    orderOfBowler[i] = bowler.getName();
		    bowler.setNoOfBalls(bowler.getNoOfBalls()-1);
		    maxHeap.insert(bowler);
		}
		return orderOfBowler;
		
	}
    public void print(){
    	for(int i = 0; i<orderOfBowler.length;i++){
    		System.out.println(orderOfBowler[i]);
    	}
    }
}
