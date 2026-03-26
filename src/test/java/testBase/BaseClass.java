package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	public static WebDriver driver;
	public Properties p;
	@BeforeClass(groups= {"Sanity"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);	
	
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equals("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equals("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equals("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Invalid os..");
			}
			
			

           switch(br.toLowerCase())
           {
           case "chrome": cap.setBrowserName("chrome");break;
           case "edge":cap.setBrowserName("MicrosoftEdge");break;
           case "firefox":cap.setBrowserName("firefox");break;
           default:System.out.println("invalid browser name..");return;
           }
           driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equals("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equals("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equals("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Invalid os..");
			}
			
			
			
			
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver();break;
			
			case "edge": driver = new EdgeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			default:System.out.println("Invalid browser..");return;
			
			}
		}
		
	
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		// Pass the app url through config properties
		driver.get(p.getProperty("appURL"));
	//	driver.get("https://app.datainspiredliving.co.uk/");
	}
	
	@AfterClass(groups= {"Sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	
	// Capture screenshot method
	/*
	public String captureScreen(String tname) throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyymmddyyhhmmss").format(new Date());
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourceFile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\"+tname+"-"+ timestamp +".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	*/
	
	
	public String captureScreen(String tname) throws IOException
{
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    TakesScreenshot ts = (TakesScreenshot) driver;
    File sourceFile = ts.getScreenshotAs(OutputType.FILE);

    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timestamp + ".png";

    File targetFile = new File(targetFilePath);

    FileUtils.copyFile(sourceFile, targetFile);

    return targetFilePath;
}


}
