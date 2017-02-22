import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecSys {
	
	int[][] ratings_arr;
	int user;
	int no_of_movies;
	ArrayList <Float> userPoint;
	NearestPoints np;
	
	
	/**
	 * The string mrMatrix is contains the absolute path name of the file that
	 * contains the mapped ratings matrix.
	 * @param mrMatrix
	 * @throws FileNotFoundException 
	 */
	public RecSys(String mrMatrix) throws FileNotFoundException{
		
		//Access file and parse the movies and ratings
		userPoint = new ArrayList<Float>();
		 String[] strNums;
		File f = new File(mrMatrix);
		Scanner input = new Scanner(f);
		String value = input.next().trim();
		 user = Integer.valueOf(value);
		String movies = input.nextLine().trim();
		 no_of_movies = Integer.valueOf(movies);
		 //System.out.println(user);
		 //System.out.println( no_of_movies);
		 ratings_arr = new int[user][no_of_movies];
		 for(int i = 0; i<user; i++){
				for(int j = 0; j < no_of_movies; j++){
					
					ratings_arr[i][j] =  0;
				}
		   }
		 int count = 0;
		 while(input.hasNextLine()){
			 String first = input.next().trim();
			 
			 float item = Float.valueOf(first);
			 userPoint.add(item);
			 String second = input.nextLine().trim();
			
			 int j = 0;
			 strNums = second.split("\\s");
			 for(int i=0; i<strNums.length; i++) {
		           int rating = Integer.parseInt(strNums[i]);
		          
		           ratings_arr[count][i]=rating;
		        }
			count++;
			 
		 }
		 //System.out.println(userPoint.size());
			
		 np = new NearestPoints(userPoint);
		 np.buildDataStructure();
		 
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
		//System.out.println(u);
		//System.out.println(m);
		
		if(m>0 && u>0 && ratings_arr[u-1][m-1] != 0){
			return (float)ratings_arr[u-1][m-1];
		}
		System.out.println(userPoint.size());
		
		ArrayList<Float> myArr = np.npHashNearestPoints(u-1);  
		System.out.println("My closest users: " +myArr.size());
		
		return 0f;
	}
	
}
