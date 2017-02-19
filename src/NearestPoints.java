import java.util.*;
import java.io.*;
public class NearestPoints {
	private ArrayList<Float> setofPoints;
	

	public NearestPoints(String dataFile) throws FileNotFoundException{
		setofPoints = new ArrayList<Float>();
		File f = new File(dataFile);
		Scanner input = new Scanner(f);
		while(input.hasNextLine()){
			String value = input.nextLine();
			float point = Float.valueOf(value);
			setofPoints.add(point);
			
		}
		
		
		
		
		
		
	}
	
	public NearestPoints(ArrayList<Float> pointSet){
		 setofPoints = new ArrayList<Float>(pointSet);
		 
		
	}
	
	public ArrayList <Float> naiveNearestPoints(float p){
		ArrayList <Float> nearestPoints = new ArrayList<Float>();
		for (int i = 0; i < setofPoints.size();i ++){
			float point = setofPoints.get(i);
			float difference = point - p;
			float abs = Math.abs(difference);
			if (abs <= 1){
				nearestPoints.add(point);
			}
		}
		
		 return nearestPoints;
		
	}
	
	public void buildDataStructure(){
		int n = setofPoints.size();
		int m = 0;
		
		while (m  <= (1.5 * n)) {
			m ++;
		}
		
		HashTable table = new HashTable(m);
		
		for (int i = 0; i < n ; i++){
			float p = setofPoints.get(i);
			int g = (int)(Math.floor(p));
			 Tuple point = new Tuple(g,p);
			 table.add(point);
			
		}
		
		
	}
	
	
	
	
	
	
}
