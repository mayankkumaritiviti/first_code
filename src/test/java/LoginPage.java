import LoginPageModel.LoginPageModel;
import Resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginPage extends Base {
    public WebDriver driver;
    LoginPageModel lpn;

    //System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");
    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initalize() throws IOException {
        driver = intializeDriver();
        driver.get(prop.getProperty("url"));
        lpn = new LoginPageModel(driver);
        log.info("Driver is intialized");
    }

    @Test
    public void TC_1(){
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(lpn.getLableLogintoFIXConductor().isDisplayed());
        System.out.println("Label Verified");

        assertion.assertTrue(lpn.getTextUsername().isDisplayed());
        System.out.println("Text Username verified");

        assertion.assertTrue(lpn.getTextPassword().isDisplayed());
        System.out.println("Text Password verified");

        assertion.assertTrue(lpn.getLinkForgotpassword().isDisplayed());
        System.out.println("Forgot Password link verified");

        assertion.assertTrue(lpn.getButtonLogin().isDisplayed());
        System.out.println("Login Button Verified");

        assertion.assertAll();
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
