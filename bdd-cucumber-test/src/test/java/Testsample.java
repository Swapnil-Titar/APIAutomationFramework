import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Testsample {

	public static void main(String[] args) {
		
		int A=2;
		
		//method
		//Testsample test = new Testsample();
         Cude(A);
		//Cube(A);
         /*
          * TC1- Valid cube results
          * Tc2 - Negative 
          */
         
	
	}
	
	static int  Cude(int a)
	{
		int result= a* a * a ;
		System.out.println(result);
		return result;
		
	}
	
	@Test(description = "Validate the input range")
	public int Test_cube()
	{
		int arr[] = {1,-2,2,3,4,5};
		int  var = Cude(arr[0]);
		assert.assertEquals(var, 1);
	}
	


}
