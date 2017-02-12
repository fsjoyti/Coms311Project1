
public class HashFunction {
	private int a;
	private int b;
	private int p;

	
	public HashFunction(int range){
		
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
	
	
	
	
	
}
