package Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver intializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
        prop.load(file);
        //String browserName = prop.getProperty("browser");
        String browserName = System.getProperty("browser");
        if(browserName==null){browserName = prop.getProperty("browser");}
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-"+browserName+"-|-|-|-|-|-|-|-|-|-|-|-|-");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("firefox")) {
            // firefox code
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browserName.equals("IE")) {

            // ie code
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer_32.exe");
            driver=new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
        File source =( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }
}
