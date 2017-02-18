import java.util.LinkedList;
import java.util.ListIterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable h1 = new HashTable(3);
		System.out.println("Size of hashtable"+h1.size());
	    System.out.println("Value of A "+h1.returnhash().getA());
	    System.out.println("Value of B"+h1.returnhash().getB());
	    System.out.println("Value of P"+h1.returnhash().getP());
	    Tuple t1 = new Tuple(3,5);
	    System.out.println(t1.getKey());
	    System.out.println(h1.returnhash().hash(t1.getKey()));
	    h1.add(t1);
	    LinkedList<Tuple>[] l1 = h1.returnhashTable();
	    System.out.println("Number of elements in the hashtable"+ h1.numElements());
	    
	    for(int i=0;i < l1.length;i++){
	    	LinkedList<Tuple> old = l1[i];
	    	ListIterator<Tuple> listIterator = old.listIterator();
	    	while(listIterator.hasNext()){
	    		Tuple z = listIterator.next();
	    		System.out.println(z.getKey());
	    		System.out.println(z.getValue());
	    	}
	    }
	    
	    System.out.println("Maxload "+h1.maxLoad());
	    Tuple t2 = new Tuple(3,5);
	    
	    //h1.remove(t2);
	    //System.out.println("Number of elements in the hashtable"+ h1.numElements());
	    System.out.println(h1.loadFactor());
	    
	   
	    
	    
	    

	}

}
