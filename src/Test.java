
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
	/*	HashTable h1 = new HashTable(3);
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
	    System.out.println("Load factor"+h1.loadFactor());
	    System.out.println("Average load"+h1.averageLoad());
	    
	    ArrayList <Tuple> a1 = h1.search(3);
	    System.out.println(a1.size());
	    
	    for(int i = 0; i < a1.size(); i++){
	    	Tuple a = a1.get(i);
	    	System.out.println(a.getKey());
	    	System.out.println(a.getValue());
	    }
	    
	    Tuple t3 = new Tuple(4,8);
	    h1.add(t3);
	    System.out.println("Number of elements in the hashtable"+ h1.numElements());
	    System.out.println("Load factor"+ h1.loadFactor());
	    Tuple t4 = new Tuple(6,9);
	    h1.add(t4);
	    System.out.println("Number of elements in the hashtable"+ h1.numElements());
	    System.out.println("Size of hashtable"+h1.size());
	    System.out.println("Load factor"+ h1.loadFactor());
	    
	    Tuple t5 = new Tuple(6,9);
	    h1.add(t5);
	    System.out.println("Number of elements in the hashtable"+ h1.numElements());
	    System.out.println("Size of hashtable"+h1.size());
	    System.out.println("Load factor"+ h1.loadFactor());
	    
	    NearestPoints np = new NearestPoints("points.txt");
	    np.buildDataStructure();
	   */
	   
		//------ Testing Nearest points------//
		
		ArrayList<Float> list = new ArrayList<Float>();
		list.add((float) 3.9);
		list.add((float) 2.56);
		list.add((float) 1.34);
		list.add((float) 6.57);
		list.add((float) 5.1);
		list.add((float) 3.6);
		list.add((float) 2.46);
		list.add((float) 1.24);
		list.add((float) 6.67);
		list.add((float) 5.7);
		
		NearestPoints np = new NearestPoints(list);
		
		NearestPoints np_points = new NearestPoints("points.txt");
	    np_points.buildDataStructure();
		
		//Testing Naive Nearest points
		
		/*System.out.println("The nearest points are: " +np.naiveNearestPoints(4.5f));
		System.out.println("The nearest points for 3.9 are: " +np.naiveNearestPoints(3.9f));*/
		
	    //Testing Neighbor preserving hashing
		np.buildDataStructure();
		System.out.println("The Array list of points for 3.9 are: " +np.npHashNearestPoints(3.9f));

		//Testing for all nearest points text file
		
		//np_points.allNearestPointsNaive();
		//np_points.allNearestPointsHash();
		System.out.println("COmpleted running");
	}

}
