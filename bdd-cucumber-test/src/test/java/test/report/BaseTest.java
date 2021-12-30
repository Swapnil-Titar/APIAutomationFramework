package test.report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {
		
		@Test
		public void test1() {
			Assert.assertEquals(2, 3);
		//	WebDriver d = new ChromeDriver();
			
			
		}
		
		@Test
		public void test2() {
			Assert.assertEquals(2, 2);
		}
		
		@Test
		public void test3() {
			Assert.assertTrue(true, "This test should be failed");
		}
		
		@Test
	    public void test4() {
	        Assert.fail("This test should be failed");
	    }

	    @Test(dependsOnMethods = "test4")
	    public void skippedByDependencyTest() {
	    	
	    }

	}
	
