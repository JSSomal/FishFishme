import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public class TemplateComman {
	
	private WebDriver driver;
	String browser = "MF";
	private static Capabilities caps;
	String chromeExecutable = "/BrowserExecutables/chromedriver_win32.exe";
	String ieExecutable = "/BrowserExecutables/IEDriverServer_Win32_2.53.1.exe";

	@BeforeClass(groups = {"Smoke", "Regression"}, enabled = true)
	protected WebDriver initDriver() throws IOException {
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("iLookProfile");
		
		System.out.println("Browser select : "+browser);
		//extentTest.log(LogStatus.INFO, "Browser select : "+browser);
		switch (browser) {
		
		case "MF":
			System.out.println("Mozilla firefox selected");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserNameAndVersionMF = caps.getBrowserName() + " " + caps.getVersion() + " running on "
					+ System.getProperty("os.name");
			System.out.println(browserNameAndVersionMF);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;

		case "GC":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + chromeExecutable);
			System.out.println("Google chrome selected");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserNameAndVersionGC = caps.getBrowserName() + " " + caps.getVersion() + " running on "
					+ System.getProperty("os.name");
			System.out.println(browserNameAndVersionGC);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + ieExecutable);
			System.out.println("Internet explorer selected");
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserNameAndVersionIE = caps.getBrowserName() + " " + caps.getVersion() + " running on "
					+ System.getProperty("os.name");
			System.out.println(browserNameAndVersionIE);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;

		default:
			System.out.println("Mozilla firefox selected");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserNameAndVersionDefault = caps.getBrowserName() + " " + caps.getVersion() + " running on "
					+ System.getProperty("os.name");
			System.out.println(browserNameAndVersionDefault);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		}
		return driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	@AfterSuite
	void exit()
	{
		driver.quit();
	}
	
}
