package packfay;


public class ArrayL {

	public static void main(String[] args) {

try {
	int c = 10 / 0;
	System.out.println("c ="+c);
} catch (Exception e) {
	System.out.println(e.getMessage());
	System.out.println(e.getLocalizedMessage());
	System.out.println(e.getCause());
	//e.printStackTrace();
	//System.out.println(e.getStackTrace());
	//e.notify();
	
}
	}
}