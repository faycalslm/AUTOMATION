package packfay;

public class Parameters {

	public static void main(String[] args) {
		 
		   int intIdD[][] = new int [2][2] ;
		 
		   intIdD[0][0]= 1;
		   intIdD[0][1]= 2;
		   intIdD[1][0]= 3;
		   intIdD[1][1]= 4;
		 
		 
		   int length2 = intIdD.length;
		   System.out.println("nmbre : "+length2);
		   
		   int i=0;
		   int y=0;
		while (i<length2) {
			  
			  System.out.println("list elements : "+intIdD[i][y]);
			  i++;
			  y++;
			  
		}
				   }
	}

	