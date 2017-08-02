import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Test;



public class Template extends TemplateComman {

	
	/**
	 * This Test Case enters URL. Fill security authorizations. And checks for the login Button availability.
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@Test(priority  = 1, description = "Enter URL >> Ensure that Login button is available")
	 public void checkLoginBtn() throws IOException, InterruptedException
	{
		System.out.println();
		Thread.sleep(1000);
		System.out.println("Enter URL and Enter Valid Authentications");
		//Runtime.getRuntime().exec(System.getProperty("user.dir") +"\\AutoIT\\fish.exe");
		getDriver().get("https://ffME:ffMEpass2015@staging.www.fishfishme.com/partners/");
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoIT\\fish.exe");
		getDriver().navigate().refresh();
		System.out.println("Check Login Button is Displaying or not");
		
		Assert.assertTrue(getDriver().findElement(By.xpath("//button[@type ='submit']")).isDisplayed(),
				"Login Button is not Displayed");
		System.out.println("==========Login Button is Displayed===========");
		
	}
	
	/**
	 * This Test Case enters Credentials, click login and check whether it is successfully login or not
	 * @throws InterruptedException 
	 */
	@Test(priority  = 2, description = "Enter Valid Credentials >> Ensure that User shoul Login")
	public void loginProcess() throws InterruptedException
	{
		System.out.println();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//input[@name='_username']")).sendKeys("admin");
		System.out.println("Enter Valid username");
		getDriver().findElement(By.xpath("//input[@name='_password']")).sendKeys("admin_Fishme2016");
		System.out.println("Enter Valid Password");
		getDriver().findElement(By.xpath("//button[@type ='submit']")).click();
		System.out.println("Click Submit");
		Assert.assertTrue(getDriver().getTitle().contains("Admin Business Partner Agent Dashboard"),
				"Unsuccessfull Login");
		System.out.println("=========Successfully Logged in============");
		Thread.sleep(10000);
	}
	
	@Test(priority  = 3, description = "Enter in valid Search")
	public void invalidSearch() throws InterruptedException
	{
		System.out.println();
		System.out.println("Enter Invalid Search option");
		getDriver().findElement(By.id("autocomplete")).sendKeys("xyzabc");
		Thread.sleep(2000);
		System.out.println("Check any suggestion is displayed or not");
		System.out.println("========No suggestions displyed========");
		Assert.assertEquals(getDriver().findElement(By.className("autocomplete-suggestions")).isDisplayed(),
				"No suggestions displyed");
		
	}
	
	@Test(priority  = 4, description = "Enter Valid Credentials >> Ensure that User shoul Login")
	public void getPlansWithCost() throws InterruptedException
	{
		System.out.println();
		Thread.sleep(6000);
		System.out.println("Clear old Input and Enter Dubai in search");
		getDriver().findElement(By.id("autocomplete")).clear();
		getDriver().findElement(By.id("autocomplete")).sendKeys("Dubai");
		Thread.sleep(2000);
		System.out.println("Select from  suggestions");
		getDriver().findElement(By.className("autocomplete-suggestions")).click();
		Thread.sleep(2000);
		System.out.println("Click on 'impersonate' button");
		getDriver().findElement(By.id("emulate_user_button")).click();
		Thread.sleep(2000);
		System.out.println("========Showing Texts of Plans and there Cost======= ");System.out.println();
		List<WebElement> li = getDriver().findElements(By.xpath("//div[@id='currentTrips']/div/div[1]/p[1]"));
		
		for (WebElement webElement : li) {
			System.out.println(webElement.getText());
			Thread.sleep(2000);
			
		}
	}
	
	
	
}
