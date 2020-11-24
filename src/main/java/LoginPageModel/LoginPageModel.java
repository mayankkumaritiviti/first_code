package LoginPageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageModel {
    public WebDriver driver;
    By LableLogintoFIXConductor =  By.xpath("//span[contains(text(),'Login to Itiviti Conductor')]");
    By ButtonLogin =  By.xpath("//button[contains(text(),'Login')]");
    By LinkForgotpassword =  By.xpath("//a[contains(text(),'Forgot password?')]");
    By TextUsername =  By.xpath("//input[@id='j_username']");
    By TextPassword =  By.xpath("//input[@id='j_password']");
    public LoginPageModel(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }
    public WebElement getLableLogintoFIXConductor() {
        return driver.findElement(LableLogintoFIXConductor);
    }
    public WebElement getButtonLogin() {
        return driver.findElement(ButtonLogin);
    }
    public WebElement getLinkForgotpassword() {
        return driver.findElement(LinkForgotpassword);
    }
    public WebElement getTextUsername() {
        return driver.findElement(TextUsername);
    }
    public WebElement getTextPassword() {
        return driver.findElement(TextPassword);
    }

}
