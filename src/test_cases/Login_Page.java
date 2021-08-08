package test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Page {
	WebDriver driver= null;
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","chromedriver1.exe");
	  driver = new ChromeDriver();
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/index.html");
	 driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void verifyLogo() {
	 boolean logo = driver.findElement(By.xpath("//img"))!=null;
	  Assert.assertTrue(logo);
	}
	
	@Test(priority=2)
	public void verifyTitle(){
		String title = driver.findElement(By.tagName("b")).getText();
		Assert.assertEquals(title, "Java By Kiran");
		}

	@Test(priority=3)
	public void verifyLoginBoxTitle() {
	 String str = driver.findElement(By.className("login-box-msg")).getText();
	  Assert.assertEquals(str, "Sign in to start your session");

}
	@Test(priority=4)
	public void verifysubTitle() {
		String heading = driver.findElement(By.xpath("//h4")).getText();
		Assert.assertEquals(heading,"JAVA | SELENIUM |PYTHON");	
	}
	
	@Test(priority=5)
	public void verifyBlankUname() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		String actErrorMsg = driver.findElement(By.id("email_error")).getText();
		String expErrorMsg = "Please enter email.";
       	Assert.assertEquals(actErrorMsg, expErrorMsg);
	}
	
	@Test(priority=6)
	public void verifyBlankPass() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		String actErrorMsg = driver.findElement(By.id("password_error")).getText();
		String expErrorMsg = "Please enter password.";
		Assert.assertEquals(actErrorMsg, expErrorMsg);
   }
	
	@Test(priority=7)
	public void verifyInvalidUname() {
		driver.findElement(By.id("email")).sendKeys("shaheen@gmail.com");
		driver.findElement(By.xpath("//button")).click();
		String actErrorMsg = driver.findElement(By.id("email_error")).getText();
		String expErrorMsg = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(actErrorMsg, expErrorMsg);
   }
	
	@Test(priority=8)
	public void verifyInvalidPass() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.xpath("//button")).click();
		String actErrorMsg = driver.findElement(By.id("password_error")).getText();
		String expErrorMsg = "Please enter password 123456";
		Assert.assertEquals(actErrorMsg, expErrorMsg);
   }
	@Test(priority=9)
	public void verifycorrectUnameAndPass() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String actUrl = "file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/dashboard.html";
		String expUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl);
		
   }
	
	@Test(priority=10)
	public void verifyRegLink() {
		String heading =driver.findElement(By.className("text-center")).getText();
		 Assert.assertEquals(heading, "Register a new membership");
	   }
	
	 @Test(priority=11)
	 public void checkRegLinkClickable() {
		 driver.findElement(By.className("text-center")).click();
		 String actUrl = "file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html";
		 String expUrl = driver.getCurrentUrl();
		 Assert.assertEquals(actUrl, expUrl); 
		 
	 }
	 
	 @Test(priority=12)
	 public void verifyBlankNameInReGLink() {
		 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
			driver.findElement(By.id("name")).sendKeys("");
			driver.findElement(By.xpath("//button")).click();
			String actErrorMsg = driver.findElement(By.id("name_error")).getText();
			String expErrorMsg = "Please enter Name.";
			Assert.assertEquals(actErrorMsg, expErrorMsg);
		}
	 @Test(priority=13)
	 public void verifyBlankMobNoInReGLink() {
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
	 driver.findElement(By.id("name")).sendKeys("shaheen");
     driver.findElement(By.id("mobile")).sendKeys("");
	 driver.findElement(By.xpath("//button")).click();
	 String actErrorMsg = driver.findElement(By.id("mobile_error")).getText();
	 String expErrorMsg = "Please enter Mobile.";
	 Assert.assertEquals(actErrorMsg, expErrorMsg);

	 }
	 @Test(priority=14)
	 public void verifyBlankEmailInReGLink() {
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
	 driver.findElement(By.id("name")).sendKeys("shaheen");
     driver.findElement(By.id("mobile")).sendKeys("9876543215");
     driver.findElement(By.id("email")).sendKeys("");
	 driver.findElement(By.xpath("//button")).click();
	 String actErrorMsg = driver.findElement(By.id("email_error")).getText();
	 String expErrorMsg = "Please enter Email.";
	 Assert.assertEquals(actErrorMsg, expErrorMsg);
	 }
	 @Test(priority=14)
	 public void verifyBlankPassInReGLink() {
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
	 driver.findElement(By.id("name")).sendKeys("shaheen");
     driver.findElement(By.id("mobile")).sendKeys("9876543215");
     driver.findElement(By.id("email")).sendKeys("shaheen@gmail.com");
     driver.findElement(By.id("password")).sendKeys("");
	 driver.findElement(By.xpath("//button")).click();
	 String actErrorMsg = driver.findElement(By.id("password_error")).getText();
	 String expErrorMsg = "Please enter Password.";
	 Assert.assertEquals(actErrorMsg, expErrorMsg);
	 }
	 @Test(priority=14)
	 public void verifyRegNewMember() {
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
	 driver.findElement(By.id("name")).sendKeys("shaheen");
     driver.findElement(By.id("mobile")).sendKeys("9876543215");
     driver.findElement(By.id("email")).sendKeys("shaheen@gmail.com");
     driver.findElement(By.id("password")).sendKeys("qwerty");
	 driver.findElement(By.xpath("//button")).click();
	 driver.switchTo().alert().accept();
	String heading = driver.findElement(By.tagName("b")).getText();
	Assert.assertEquals(heading, "Java By Kiran");
	} 
	 
	 @Test(priority=15)
	   public void VerifyIAlreadyHaveaMembershipClick() {
		 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/register.html");
		 driver.findElement(By.className("text-center")).click();
		 String actUrl = "file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/index.html";
		  String expUrl = driver.getCurrentUrl();
		    Assert.assertEquals(actUrl, expUrl);
		}
	 @AfterMethod
	 public void closeSetup() {
	 driver.close();
}   
	
}	

	

