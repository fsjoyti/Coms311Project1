
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashFunction test1 = new HashFunction(4);
		System.out.println(test1.getP());
		System.out.println(test1.getA());
		System.out.println(test1.getB());
		
		HashFunction test2 = new HashFunction(8);
		System.out.println(test2.getP());
		System.out.println(test2.getA());
		System.out.println(test2.getB());
	}

}
