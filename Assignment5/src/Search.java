
public class Search {

	/**
	 * @param arr input array
	 * @param num element to be found
	 * @return index if element is found else throw assertion error
	 */
	public static int doLinearSearch(int arr[],int num){
	    if(arr.length>=1){
	        if(arr[0] == num ){
		    return 0;
		}
		//form duplicate array beginning with second element of previous array
		else{
		    int[] newArr = new int[arr.length-1]; //new array
		    for(int i = 1; i < arr.length; i++){
			newArr[i-1] = arr [i]; 
		    }
		    return 1+doLinearSearch(newArr, num);//recursion call on new array
		}
	    }
	    else{
		throw new AssertionError();//throw if element not found
	    }
	}
	
	/**
	 * @param arr input array of sorted elements
	 * @param num number to be found
	 * @return index at which element occurs else throw assertion error
	 */
	public static int doBinarySearch(int arr[],int num) {
	    if (arr.length>=1) {
	        int mid = arr.length/2; // middle element
		    if(arr[mid] == num ) {
			return mid;
		    }
		    else {
			if(arr[mid] < num) { //if middle element is lesser then search second half of array
			    int[] newArr = new int[arr.length-mid-1];
				for (int i = mid+1,j=0; i < arr.length; i++ ) {
				    newArr[j] = arr[i];
				    j++;
				}
				return mid + doBinarySearch(newArr, num) +1;
			}
			else{  //if if middle element is larger then search first half of array
			    int[] newArr = new int[mid];
				for (int i = 0; i < mid; i++ ) {
				    newArr[i] = arr[i];
				}
				return doBinarySearch(newArr, num);
			}
		    }
	    }
	    else {
		throw new AssertionError();
	    }
	}
}

