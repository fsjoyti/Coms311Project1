

import java.util.*;
public class HashTable {
	
	private LinkedList<Tuple>[] hashtable;
	private HashFunction h;
	private int sizeofHashTable;
	private int maxLoad;
	private int avgLoad;
	
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
	
	
	public void add(Tuple t){
		int size_new = sizeofHashTable;
		sizeofHashTable = setsize(size_new);
		
		
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
