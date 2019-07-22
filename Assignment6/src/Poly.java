
public final class Poly {
	
	private final int[] array;
	public Poly(int[] array) {
		this.array = array;
	}
	public int[] getArray(){
		return array;
	}
	public int getDegree(){
		return array.length-1;
	}
	public float evaluate(float x){
		int[] coefficient = getArray();
		int degree = getDegree();
		float ans = 0;
		for(int i = 0; i<= degree; i++){
			ans += coefficient[i]*Math.pow(x,i);
		}
		return ans;
	}
	public Poly addPoly(Poly p2){
		int degreeOfP1 = getDegree();
		int degreeOfP2 = p2.getDegree();
		
		int[] coefficientOfP1 = getArray();
		int[] coefficientOfP2 = p2.getArray();
		
		int lenOfArr = degreeOfP1 > degreeOfP2 ? degreeOfP1 :degreeOfP2;
		int [] addArr = new int[lenOfArr+1];
		if(lenOfArr == degreeOfP1){
			for (int i = 0; i<=degreeOfP2 ;i++){
				addArr[i] = coefficientOfP1[i] + coefficientOfP2[i];
			}
			for (int i = degreeOfP2+1; i<=degreeOfP1 ;i++){
				addArr[i] = coefficientOfP1[i];
			}
		}
		else{
			for (int i = 0; i<=degreeOfP1 ;i++){
				addArr[i] = coefficientOfP1[i] + coefficientOfP2[i];
			}
			for (int i = degreeOfP1+1; i<=degreeOfP2 ;i++){
				addArr[i] = coefficientOfP2[i];
			}
		}
		return new Poly(addArr);
	}
	public Poly multiplyPoly(Poly p2){
		int degreeOfP1 = getDegree();
		int degreeOfP2 = p2.getDegree();
		
		int[] coefficientOfP1 = getArray();
		int[] coefficientOfP2 = p2.getArray();
		
		int lenOfArr = degreeOfP1 + degreeOfP2 +1;
		int[] multiplyArr = new int[lenOfArr];
		
		if(degreeOfP1 >= degreeOfP2){
			for (int i = 0; i <= degreeOfP1; i++)
				for (int j = 0; j <= degreeOfP2; j++) {
					multiplyArr[(i + j)] = multiplyArr[(i + j)] + (coefficientOfP1[i] * coefficientOfP2[j]);
				}
		}
		if(degreeOfP2 > degreeOfP1){
			for (int i = 0; i <= degreeOfP2; i++) {
				for (int j = 0; j <= degreeOfP1; j++) {
					multiplyArr[(i + j)] = (multiplyArr[(i + j)] + (coefficientOfP2[i] * coefficientOfP1[j]));
				}
			}
				
		}
		return new Poly(multiplyArr);
		
	}
	
}
