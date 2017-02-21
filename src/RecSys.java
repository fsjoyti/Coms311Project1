import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecSys {
	
	/**
	 * The string mrMatrix is contains the absolute path name of the file that
	 * contains the mapped ratings matrix.
	 * @param mrMatrix
	 * @throws FileNotFoundException 
	 */
	public void RecSys(String mrMatrix) throws FileNotFoundException{
		
		//Access file and parse the movies and ratings
		File f = new File(mrMatrix);
		Scanner input = new Scanner(f);
		while(input.hasNext()){
			String value = input.next();
			int user = Integer.valueOf(value);
			String movies = input.nextLine();
			int noOfmovies = Integer.valueOf(movies);
			
		}
		
	}
	/**
	 * If the user u has rated movie m, then it returns that rating; otherwise
	 * it will predict the rating based on the approach described above, 
	 * and returns the predicted rating.
	 * @param u
	 * User
	 * @param m
	 * Movie
	 * @return
	 * The rating
	 */
	public Float ratingOf(int u, int m){
		
		
		return 0f;
	}
	
}
