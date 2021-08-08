package test_cases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard_Page {
WebDriver driver= null;
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","chromedriver1.exe");
	 driver = new ChromeDriver();
	 driver.get("file:///C:/Users/DELL/Downloads/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
	 driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void verifyTitle() {
		String title = driver.findElement(By.xpath("//a/span[2]/b")).getText();
		Assert.assertEquals(title, "Java By Kiran");
	}
	@Test(priority=2)
	public void verifyImg() {
		boolean logo = driver.findElement(By.xpath("//img"))!=null;
		  Assert.assertTrue(logo);
		}
	@Test(priority=3)
	public void vefirySubTitle() {
		String title = driver.findElement(By.xpath("//div/div[2]/p")).getText();
		Assert.assertEquals(title, "Kiran");
	}	
	
	@Test(priority=4)
	public void verifyCourseClr() {
		List<WebElement> course = driver.findElements(By.xpath("//div//parent::div[contains(@class,'small-box ')]"));
		for(WebElement text:course) {
			String colourText = text.getAttribute("class");
			System.out.println(colourText);
			String colour =colourText.substring(colourText.lastIndexOf('-')+1);
			System.out.println(colour);
		}
	}
	
	@Test(priority=4)
	public void verifyUsers() {
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
      }
	@Test(priority=5)
	public void verifyOperators() {
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
	}
	@Test(priority=6)
	public void verifyUsefulLink() {
	driver.findElement(By.xpath("//ul/li[5]/a/span")).click();
		
	}
	
	@Test(priority=7)
	public void verifyDownloads() {
	driver.findElement(By.xpath("//ul/li[6]/a/span")).click();
	}
	
	@Test(priority=8)
	public void getCourses() {
		ArrayList<String> actualCourses = new ArrayList<String>();
		List<WebElement> courses = driver.findElements(By.xpath("//h3"));
		for(WebElement course : courses) {
			String text = course.getText();
			actualCourses.add(text);
		}
		
		ArrayList<String> expectedCourses = new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		
		Assert.assertEquals(actualCourses, expectedCourses);
	}
	@Test(priority=9)
	public void verifyMoreInfo() {
	 driver.findElement(By.linkText("More info")).click();
	 String mainWindow = driver.getWindowHandle();
	 Set<String> windows = driver.getWindowHandles();
	 for(String ChildWin : windows) {
		 if(!ChildWin.equals(mainWindow)) {
			 driver.switchTo().window(ChildWin);
			 if(driver.getCurrentUrl().contains("Selenium"))
				 driver.close();
		 }
	 }
	}
	
	@Test(priority=10)
	public void verifyLogOut() {
		driver.findElement(By.linkText("Logout")).click();
		String title = driver.getTitle();
		String exp = "JavaByKiran | Log in";
       	Assert.assertEquals(title, exp);
	}
	}

		
	
	
	

