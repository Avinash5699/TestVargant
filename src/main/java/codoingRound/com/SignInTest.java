package codoingRound.com;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends UImap {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws Exception {

		UImap.setDriverPath();
		UImap.getPropertyfile();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Click the lnktxt_signIN.YourTrips element
		WebElement lnktxtYourTrips = driver.findElement(UImap.getLocator("lnktxt_signIN.YourTrips"));
		System.out.println(lnktxtYourTrips.getText());
		lnktxtYourTrips.click();
		
		driver.findElement((UImap.getLocator("btn_signIN.SignIn"))).click();
		WebElement SignIn = driver.findElement((UImap.getLocator("btn_signIN.signInButton")));
		
		wait.until(ExpectedConditions.visibilityOf(SignIn)).click();
		
		String errors1 = driver.findElement((UImap.getLocator("txt_SignIn.error"))).getText();
		
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		driver.quit();
	}
	// Creating a custom function
		public static void highLighterMethod(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}

}
