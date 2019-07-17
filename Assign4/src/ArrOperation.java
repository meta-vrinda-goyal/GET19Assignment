import java.util.ArrayList;
import java.util.List;

public class ArrOperation{

	/**
	 * calculates size of the largest mirror section of array
	 * @param arr array of positive numbers
	 * @return max
	 */
	public static int maxMirror(int arr[]){
		if(arr.length != 0) {
		int max = 0;			//max will store the size of largest mirror
		int count = 0;		//count will hold the size of current mirror
		int length=arr.length;
		for(int i = 0; i <= length-1; i++){
			for(int j = i+1;j <= length-1; j++){
				/*if we find the same element then we will calculate the length of mirror formed*/
				if(arr[i] == arr[j]){
					for(int k = i,l = j; k <= l; k++,l--){ 
						if(arr[k] == arr[l]){
							count++;
							if(k == l){
								count = count*2-1;
							}
						}
						/*If mirror breaks then get out of inner loop*/
						else{
							break;
						}
					}
					if(count>max){
						max = count;//if current mirror is greater of all previous mirror
					}
					count = 0;
				}
			}
		}
		return max;//value of max mirror
		}
		else {
			throw new AssertionError("Array is empty!");
		}
	}
	/**
	 * number of clumps in array
	 * @param arr array of positive numbers 
	 * @return clump 
	 */
	public static int countClumps(int arr[]){
		if (arr.length!=0){
		int current = -1, clump = 0;
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] == arr[i + 1] && arr[i] != current){
				current = arr[i];    //store current value
				clump++;             //increase clump value if number occurs for second time in clump
			} 
			else{
			    if(arr[i] != current){
					current = -1;    //if a clump ends reset current
				}
			}
		}
		return clump;
		}
		else {
			throw new AssertionError("Array is empty");
		}
	}
	
	/**
	 * @param arr array of positive numbers
	 * @param x is a number
	 * @param y is a number
	 * @return array in which x is followed by y
	 */
	public static int[] fixXY(int arr[],int x,int y){
		if (arr.length!=0) {
			int count=0;				//count of x in array
			List<Integer> xList=new ArrayList<Integer>();//for storing indexes of x
			List<Integer> yList=new ArrayList<Integer>();//for storing indexes of y
			boolean flag = true;
			for(int i=0;i<arr.length;i++){
				if(arr[i]==x){
					xList.add(i);   //store index of x in list
					count++;
				}
				else if(arr[i]==y){
					yList.add(i);  //store index of y in list
				} 
			}
			for(int l=0;l<count-1;l++){
				if((xList.get(l+1)==xList.get(l)+1)){
					flag = false;
					break;
				}
			}
			
			/*swapping position of y in array*/
			if(xList.size()==yList.size() && !xList.contains(arr.length-1) && flag){
				for(int i=0;i<count;i++){
					int temp=arr[xList.get(i)+1];
					arr[xList.get(i)+1]=y;
					arr[yList.get(i)]=temp;
				}
				return arr;
			}
			else {
				throw new AssertionError();
			}
		}
		else {
			throw new AssertionError("Array is empty");
		}
	}
	/**
	 * @param arr array of positive numbers 
	 * @return split index if it exist else return -1
	 */
	public static int splitArray(int arr[]){
		if(arr.length!=0) {
		int sum1=arr[0];			//set first value of array
		int sum2=arr[arr.length-1]; //set last value of array
		int i=1,j=arr.length-2;
		while(i<=j){
			//check for split index
			if(sum1>=sum2){
				sum2+=arr[j];
				j--;
			}
			else if(sum2>sum1){
				sum1+=arr[i];
				i++;
			}
		}
		if(sum1==sum2 && j>=0) //check sum of both side
			return i;  //return split index
		else
			return -1;
		}
		else {
			throw new AssertionError("Array is empty");
		}
	}
	public static void main (String args[]) {
		int[] data={1,2,1,4,1,2,1};
		System.out.println("ans" + maxMirror(data));
	}
}

