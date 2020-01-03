package packfay;

public class ArrayList {

	public static void main(String[] args) {
		 
		   int intIdD[][] = new int [2][2] ;
		 
		   intIdD[0][0]= 1;
		   intIdD[0][1]= 2;
		   intIdD[1][0]= 3;
		   intIdD[1][1]= 4;
		   
		 
		 
		   int length2 = intIdD.length;
		   //System.out.println("nmbre : "+length2);
		   
		 try {
			 for(int i = 0 ; i<=length2 ; i++) {
				   for (int j = 0; j < length2; j++) {
					System.out.println("les elements :"+intIdD[i][j]);
				}
			   }
		} catch (Exception e) {
		System.out.println("exception :"+e.getMessage());
		}
		   
		
				   }
	}

	