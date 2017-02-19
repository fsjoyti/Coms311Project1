
public class HashFunction {
	private int a;
	private int b;
	private int p;

	
	public HashFunction(int range){
	  range = setinitialp(range);
	  p = range;
	  
	  a = (int)(Math.random() * range);
	  b = (int)(Math.random() * range);
	  
	  
		
	}

	private int setinitialp(int range) {
		while (!isPrime(range)){
			  range ++;
		  }
		return range;
	}
	
	/*
	 * Is this supposed to be of type int
	 */
	public int hash(int x){
		int value = (a * x + b) % p;
		return value;
	}
	
	public int getA(){
		return a;
	}
	
	public void setA(int x){
		a = x % p;
	}
	
	
	public int getB(){
		return b;
	}
	
	public void setB(int y){
		b = y % p;
	}
	
	
	public int getP(){
		return p;
	}
	
	public void setP(int x){
		x = setinitialp(x);
		p = x;
		
	}
	
	private boolean isPrime(int num){
		if (num%2==0)
			return false;
		for (int i = 3; i*i <= num; i++){
			if (num%i == 0){
				return false;
			}
			
		}
		return true;
		
	}
	
	
	
	
}