
public class Tuple {
	private int key;
	private float value;
	
	public Tuple(int keyP, float valueP){
		this.key = keyP;
		this.value = valueP;
	}
	
	public int getKey(){
		return key;
	}
	
   public float getValue(){
	   return value;
   }
   
  
   public boolean equals(Tuple t){
	   if(t==null){
		   return false;
	   }
	   return key == t.key && value == t.value;
   }
}
