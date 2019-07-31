public  class RotateSubList {
	/**
	 * @param list to be rotated
	 * @param L starting index
	 * @param R ending index
	 * @param N number of rotation
	 */
	public void rotateSubList(LinkedList list, int L ,int R , int N){
		if(L < R){
			//if rotation gives same list
			if(N == (R-L+1)){
				return;
			}
			if(N < R-L+1 ){
				//get previous of starting node
				Node start = list.head;
				for (int i = 1; i < L-1; i++){
					start = start.next;
				}
			
				//get ending node
				Node end = list.head;
				for (int i = 1; i < R; i++){
					end = end.next;
				}
			
				//getting after of ending node
				Node temp = end.next;
				//changing next of ending node to starting node
				end.next = start.next;
			
				//getting new ending node
				Node temp2 = list.head;
				for (int i = 1; i < R-N; i++){
					temp2 = temp2.next;
				}
			
				//changing next of (previous of starting node)
				start.next = temp2.next;
				temp2.next = temp;
			}
			// if N > R-L+1
			else {
				//again call the method with updated N
				rotateSubList(list, L, R, (N-(R-L+1)));
			}
		}
	
	    else {
		     throw new AssertionError("L should be less than R");
	    }

    }
}
