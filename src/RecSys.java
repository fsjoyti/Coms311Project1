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
	public RecSys(String mrMatrix) throws FileNotFoundException{
		
		//Access file and parse the movies and ratings
		File f = new File(mrMatrix);
		Scanner input = new Scanner(f);
		while(input.hasNextLine()){
			String value = input.next().trim();
			int user = Integer.valueOf(value);
			String movies = input.nextLine().trim();
			int no_of_movies = Integer.valueOf(movies);
			
			Float[][] ratings = new Float[user][no_of_movies];
			for(int i = 0; i<user; i++){
				for(int j = 0; j < no_of_movies; j++){
					while(input.hasNextLine()){
						String value1 = input.next().trim();
						ratings[i][j] = Float.valueOf(value1);
						//System.out.println(input.nextLine().trim());
					}
					//System.out.println(input.nextLine());
					//ratings[i][j] = Integer.valueOf(value);
				}
			}

			System.out.println("User: " +user + "Num of movies: " +no_of_movies);
			System.out.println("Ratings obtained: " +ratings);
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
