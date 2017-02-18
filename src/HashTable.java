

import java.util.*;
public class HashTable {
	
	private LinkedList<Tuple>[] hashtable;
	private HashFunction h;
	private int sizeofHashTable;
	private int maxLoad;
	private int avgLoad;
	private int loadFactor;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size){
		sizeofHashTable = setsize(size);
		h = new HashFunction(sizeofHashTable );
		hashtable = new LinkedList[sizeofHashTable ];
		for (int i= 0; i < sizeofHashTable ; i++){
			hashtable[i] = new LinkedList<Tuple>();
		}
		
		
	
		
	}
	
	
	public int maxLoad(){
		
		return maxLoad;
	}
	
	
	public int averageLoad(){
		
		return avgLoad;
	}
	
public int loadFactor(){
		
		return loadFactor;
	}
	

	public void add(Tuple t){
		
		int hashkey = h.hash(t.getKey());
		hashtable[hashkey].add(t);
		if(loadFactor > 0.7){
			rehash();
			
			
			
		}
		
		
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
    		add(value);
    		
    		
    	}
    
    	
    }
	
}
	
	
	private int setsize(int range) {
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
