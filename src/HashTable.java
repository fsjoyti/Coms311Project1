
import java.util.*;
public class HashTable {
	
	private LinkedList<Tuple>[] hashtable;
	private HashFunction h;
	private int sizeofHashTable;
	private int maxLoad;

	private float avgLoad;
	private float loadFactor;
	private int numElements;


	
	/**
	 * Finds the smallest prime integer p whose value is at least size. Creates
	 * a hash table of size p where each cell initially is NULL. It will determine the hash function to be
	 * used in the hash table by creating the object new HashFunction(p).
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int size){
		sizeofHashTable = setsize(size);
		h = new HashFunction(sizeofHashTable);
		hashtable = new LinkedList[sizeofHashTable ];
		for (int i= 0; i < sizeofHashTable ; i++){
			hashtable[i] = new LinkedList<Tuple>();
		}
		
		
	
		
	}
	/**
	 * Returns maximum load of the hash table
	 * @return
	 */
	
	public int size(){
		return sizeofHashTable;
	}
	
	/**
	 * return the load factor which
	 * is numElements()/size()
	 * @return
	 */
	
	public int maxLoad(){
		for (int i = 0; i< sizeofHashTable;i++){
			LinkedList<Tuple> list = hashtable[i];
			if (list.size() > maxLoad){
				maxLoad = list.size();
				
				
			}
			
		}
		
		return maxLoad;
	}
	
	/**
	 * Returns the average load of the hash table
	 * @return
	 */
	public float averageLoad(){
		int sum = 0;
		
		for (int i = 0; i< sizeofHashTable;i++){
			LinkedList<Tuple> list = hashtable[i];
			sum += list.size();
			
		}
		avgLoad = (float)sum/numElements;
		
		
		return avgLoad;
	}
	/**
	 * Returns the average load of the hash table
	 * @return
	 */
	public float loadFactor(){
		loadFactor =(float) numElements/sizeofHashTable ;
		
		return loadFactor;
	}
	

	/**
	 * returns the number of Tuples 
	 * that are currently stored in the hash table.
	 * @return
	 */
	
	public int numElements(){
		return numElements;
	}
	
	/**
	 *  Adds the tuple t to the hash table
	 * @param t
	 * 
	 */

	


	public void add(Tuple t){
		
		if(loadFactor > 0.7){
			rehash();
			
			
			
		}	
		
		int hashkey = h.hash(t.getKey());
		hashtable[hashkey].add(t);

		numElements++;

		
	}
	/**
     * Remove tuple t from the hash table.
     * @param t the tuple to remove.
     */
		
	public void remove(Tuple t){
		LinkedList<Tuple> tempList = hashtable[h.hash(t.getKey())];
		ListIterator<Tuple> listIterator = tempList.listIterator();
		while(listIterator.hasNext()){
    		Tuple value = listIterator.next();
    		if (value.equals(t)){
    			hashtable[h.hash(t.getKey())].remove(value);
    			numElements--;
    		}
    		
    		
    	}
		
	}
	
	/**
     * Finds tuple with the key in the hash table.
     * @param k the item to search for.
     * @return an array list of Tuples (in the hash table) whose key equals k.
     */
	public ArrayList<Tuple> search(int k){

		int hashkey = h.hash(k);
		if (hashtable.length > hashkey && hashtable[hashkey]!=null ){
			LinkedList<Tuple> tempList =  hashtable[hashkey];
			List <Tuple> mylist = new ArrayList<Tuple>(tempList);
			
			
			return (ArrayList<Tuple>) mylist;
		}
		else {
			ArrayList<Tuple> myList = new ArrayList<Tuple>();
			return myList;
		}

		
	}
	
	
// For testing purposes to be removed 
         public HashFunction returnhash(){
        	 return h;
        	 
         }
         
         
      // For testing purposes to be removed 
         public LinkedList<Tuple>[] returnhashTable(){
        	 return hashtable;
        	 
         }

	
@SuppressWarnings("unchecked")
private void rehash(){
	
	int oldsize = sizeofHashTable;
	int size_new = sizeofHashTable * 2;
	sizeofHashTable = setsize(size_new);
    LinkedList<Tuple>[] oldhashtable = hashtable;
    
    
    hashtable = new LinkedList[sizeofHashTable];
    for (int i= 0; i < sizeofHashTable ; i++){
		hashtable[i] = new LinkedList<Tuple>();
	}
    
    
    
    for (int i = 0; i < oldsize ; i++){
    	LinkedList<Tuple> old =  oldhashtable[i];
    	
    
    	ListIterator<Tuple> listIterator = old.listIterator();
    	while(listIterator.hasNext()){
    		Tuple value = listIterator.next();
    		HashFunction newhash = new HashFunction(sizeofHashTable);
    		int hashkey = newhash.hash(value.getKey());
    		hashtable[hashkey].add(value);
    		
    		
    		
    		
    	}
    
    	
    }
	
	
	
}
/**
 * Private helper method to calculate the size of hashtable
 * 
 * 
 */
	
	private int setsize(int range) {
		while (!isPrime(range)){
			  range ++;
		  }
		return range;
	}
	
	
	/**
	 * Private helper method to check if a number is prime
	 * 
	 * 
	 */
	
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
