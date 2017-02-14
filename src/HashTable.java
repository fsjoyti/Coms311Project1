
public class HashTable {
	
	
	

	public HashTable(int size){
		size = setinitialp(size);
		
	
		
	}
	
	private int setinitialp(int range) {
		while (!isPrime(range)){
			  range ++;
		  }
		return range;
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
