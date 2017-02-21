import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecSys {
	
	Float[][] ratings_arr;
	
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
			
		   ratings_arr = new Float[user][no_of_movies];
		   for(int i = 0; i<user; i++){
				for(int j = 0; j < no_of_movies; j++){
					
					ratings_arr[i][j] = (float) 0;
				}
		   }
			for(int i = 0; i<user; i++){
				for(int j = 0; j < no_of_movies; j++){
					while(input.hasNextLine()){
						String value1 = input.next().trim();
						//System.out.println("Value obtained: " +Float.valueOf(value1));
						ratings_arr[i][j] = Float.valueOf(value1);
						//System.out.println(input.nextLine().trim());
					 System.out.println("Ratings obtained: " +ratings_arr[i][j]);
					}
					//System.out.println(input.nextLine());
					//ratings[i][j] = Integer.valueOf(value);
				}
				
				
			}

			
			for(int i = 0; i<user; i++){
				for(int j = 0; j < no_of_movies; j++){
				
						
						//System.out.println("Value obtained: " +Float.valueOf(value1));
						System.out.println(ratings_arr[i][j]);
						//System.out.println(input.nextLine().trim());
						//System.out.println("Ratings obtained: " +ratings[i][j]);
					
					//System.out.println(input.nextLine());
					//ratings[i][j] = Integer.valueOf(value);
				}
				
				
			}
			//System.out.println("User: " +user + "Num of movies: " +no_of_movies);
			
		}
		
	}
	/**
	 * If the user u has rated movie m, then it returns that rating; otherwise
	 * it will predict the rating, 
	 * and returns the predicted rating.
	 * @param u
	 * User
	 * @param m
	 * Movie
	 * @return
	 * The rating
	 */
	public Float ratingOf(int u, int m){
		System.out.println(u);
		System.out.println(m);
		if(ratings_arr[u][m] != 0){
			return ratings_arr[u][m];
		}
		ArrayList<Float> usr_pts = null;
		for(int row = 0; row < ratings_arr.length; row++){
				
			usr_pts  = new ArrayList<Float>();
			usr_pts.add(ratings_arr[row][0]);
				
		}	
			
		NearestPoints np = new NearestPoints(usr_pts);
		ArrayList<Float> myArr = np.npHashNearestPoints(ratings_arr[u-1][0]);  
		System.out.println("My closest users: " +myArr);
	/*	for(int i = 0; i<ratings_arr.length; i++){
			if(myArr[i] == ratings_arr[i][0]){
				
			}
			
		}*/
		
		return 0f;
	}
	
}
