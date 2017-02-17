
public class HashTable {
	
	private int maxLoad;
	private int avgLoad;
	private int size;
	private Tuple t;
	private HashFunction hf;
	private int numTuples;
	
	/**
	 * Finds the smallest prime integer p whose value is at least size. Creates
	 * a hash table of size p where each cell initially is NULL. It will determine the hash function to be
	 * used in the hash table by creating the object new HashFunction(p).
	 * @param size
	 */

	public HashTable(int size){
		//Set initial size
		size = setinitialp(size);
		//Determine the hashfunction used in the hash Table. 
		hf = new HashFunction(size);
	}
	/**
	 * Returns maximum load of the hash table
	 * @return
	 */
	public int maxLoad(){
		
		return maxLoad;
	}
	/**
	 * Returns the average load of the hash table
	 * @return
	 */
	
	public int averageLoad(){
		
		return avgLoad;
	}
	//Not sure
	public int size(){
		
		return size;
	}
	/**
	 * returns the number of Tuples 
	 * that are currently stored in the hash table.
	 * @return
	 */
	public int numElements(){
		
		return numTuples;
		
	}
	/**
	 * return the load factor which
	 * is numElements()/size()
	 * @return
	 */
	public int loadFactor(){
		
		return numElements()/size();
	}
	
	/**
	 *  Adds the tuple t to the hash table
	 * @param t
	 * 
	 */
	public void add(Tuple t){
		
		int size_new = size * 2;
		
		if(!isPrime(size_new)){
			size_new++;
		}
		//Unsure
		hf.hash(t.getKey());
		
		if(loadFactor() > 0.7){
			//Create new hash table with double the size
			HashTable ht = new HashTable(size_new);
			//Rehash all the elements to the new hash table????
			
		}
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
