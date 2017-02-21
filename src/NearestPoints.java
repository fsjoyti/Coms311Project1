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

	/**
	 * @param p
	 * Returns an array list of points (from the set S) that are
	 * close to p.
	 * @return
	 */
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

	/**
	 * Builds the data structure that enables to quickly answer nearest point
	 * queries
	 */
	public void buildDataStructure() {
		int n = setofPoints.size();
		int m = 0; // Initial size of the hash table
		while (m <= (1.5 * n)) {
			m++;
		}

		table = new HashTable(m);

		System.out.println(m); // TODO - Remove later

		for (int i = 0; i < n; i++) {
			float p = setofPoints.get(i);
			int g = (int) (Math.floor(p));
			Tuple point = new Tuple(g, p);
			table.add(point);

		}

	}

	/**
	 * 
	 * @param p
	 * @return Returns an array list of points (from the S) that are close to p.
	 *         This method must use the data structure that was built.
	 */
	public ArrayList<Float> npHashNearestPoints(float p) {
		ArrayList<Float> nearestPoints = new ArrayList<Float>();
		ArrayList<Tuple> nearest_prev_pt = new ArrayList<Tuple>();
		ArrayList<Tuple> nearest_next_pt = new ArrayList<Tuple>();
		int g = (int) (Math.floor(p));

		ArrayList<Tuple> listofPoints = table.search(g);

		if (g >= 1) {

			nearest_prev_pt = table.search(g - 1);
		}
		if (g + 1 < table.size()) {

			nearest_next_pt = table.search(g + 1);
		}

		for (int i = 0; i < nearest_prev_pt.size(); i++) {
			Tuple point = nearest_prev_pt.get(i);
			float value = point.getValue();
			nearestPoints.add(value);

		}

		for (int i = 0; i < listofPoints.size(); i++) {
			Tuple point = listofPoints.get(i);
			float value = point.getValue();
			nearestPoints.add(value);

		}

		for (int i = 0; i < nearest_next_pt.size(); i++) {
			Tuple point = nearest_next_pt.get(i);
			float value = point.getValue();
			nearestPoints.add(value);

		}

		return nearestPoints;
	}

	/**
	 * For every point p ∈ S, compute the list of all points from S that
	 * are close to p by calling the method NaiveNearestPoints(p). Write the results to a file named
	 * NaiveSolution.txt
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void allNearestPointsNaive() throws FileNotFoundException, UnsupportedEncodingException , IOException{
		
		 PrintWriter writer = new PrintWriter("NaiveSolution.txt", "UTF-8");
		ArrayList<Float> nearestPoints = new ArrayList<Float>();
		float point = 0.0f;
		writer.println("Point" + " " + "Nearest Points ");
		for (int i = 0; i < setofPoints.size(); i++) {
			point = setofPoints.get(i);
			nearestPoints = naiveNearestPoints(point);
			
			for(int j = 0; j< nearestPoints.size(); j++) {
			  writer.println(+point + "    " +nearestPoints.get(j)); 
			
		 }
		}
		 
		   writer.close();

	}

	public void allNearestPointsHash() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		
		PrintWriter writer = new PrintWriter("HashSolution.txt", "UTF-8");
		 ArrayList<Float> nearestPoints = new ArrayList<Float>();
		 float point = 0.0f;
		 writer.println("Point" + " " + "Nearest Points ");
		 for (int i = 0; i < setofPoints.size(); i++) {
			point = setofPoints.get(i);
			nearestPoints = npHashNearestPoints(point);
			for (int j = 0; j < nearestPoints.size(); j++) {
				
				  writer.println(+point + "    " +nearestPoints.get(j)); 
				
			 }
			}
			 
			   writer.close();
	}

}
