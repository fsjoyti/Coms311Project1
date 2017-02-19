import java.util.*;
import java.io.*;

public class NearestPoints {
	private ArrayList<Float> setofPoints;
	private HashTable table;

	public NearestPoints(String dataFile) throws FileNotFoundException {
		setofPoints = new ArrayList<Float>();
		File f = new File(dataFile);
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {
			String value = input.nextLine();
			float point = Float.valueOf(value);
			setofPoints.add(point);

		}
	}

	public NearestPoints(ArrayList<Float> pointSet) {
		setofPoints = new ArrayList<Float>(pointSet);
	}

	public ArrayList<Float> naiveNearestPoints(float p) {
		ArrayList<Float> nearestPoints = new ArrayList<Float>();
		for (int i = 0; i < setofPoints.size(); i++) {
			float point = setofPoints.get(i);
			float difference = point - p;
			float abs = Math.abs(difference);
			if (abs <= 1) {
				nearestPoints.add(point);
			}
		}

		return nearestPoints;

	}

	public void buildDataStructure() {
		int n = setofPoints.size();
		int m = 0;
		while (m <= (1.5 * n)) {
			m++;
		}

     table = new HashTable(m);
     
     System.out.println(m);
		table = new HashTable(m);

		for (int i = 0; i < n; i++) {
			float p = setofPoints.get(i);
			int g = (int) (Math.floor(p));
			Tuple point = new Tuple(g, p);
			table.add(point);

		}
	}

	public ArrayList<Float> npHashNearestPoints(float p) {
		ArrayList<Float> nearestPoints = new ArrayList<Float>();
		int g = (int) (Math.floor(p));
		ArrayList<Tuple> listofPoints = table.search(g);
		
		for (int i = 0; i < listofPoints.size();i++){
			Tuple point = listofPoints.get(i);
			float value = point.getValue();
			nearestPoints.add(value);
			
		}

		return nearestPoints;
	}
	
	public void allNearestPointsNaive() {
		for (int i = 0; i <  setofPoints.size(); i++ ){
		 float point = setofPoints.get(i);
		 ArrayList<Float> nearestPoints = naiveNearestPoints(point);
		  File file = new File("NaiveSolution.txt");
		  try{
		  FileWriter fwriter = new FileWriter(file);
		  PrintWriter pWriter = new PrintWriter(fwriter);
		  pWriter.print("Point" + " " + "Nearest Point");
		   pWriter.println();
		   
		   
		  
		  
		  }
		  catch(Exception e){
			  System.out.println("Unable to write to file");
		  }
		 
		
			
		}
	}

}
