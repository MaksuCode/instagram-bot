package tr.instagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    WebDriver driver ;
    String BASE_URL = "https://www.instagram.com/";

    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[type='submit']");
    By instagramLogoLocator = By.className("s4Iyt");
    By infoLocator = By.className("g47SY");

    By postImageLocator = By.className("_9AhH0");
    By htmlTag = By.tagName("html");
    By likeButtonLocator = new By.ByCssSelector("span.fr66n");

    public App(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    public void loginWith(String username , String password){
        waitFor(usernameLocator);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        waitFor(instagramLogoLocator);
    }

    public void navigateToTargetProfile(String profileName){
        driver.navigate().to(BASE_URL.concat(profileName));
    }

    public void clickFirstPost(){
        driver.findElements(postImageLocator).get(0).click();
    }

    public int getPostCount(){
        String count = driver.findElements(infoLocator).get(0).getText();
        return Integer.parseInt(count);
    }

    public void likePosts(int count){
        while (count > 0){
            waitFor(likeButtonLocator);
            driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
            count -- ;
        }
    }

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver , 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }






}
