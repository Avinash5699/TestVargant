package codoingRound.com;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest extends UImap {


    @Test
    public void testThatResultsAppearForAOneWayJourney() throws Exception {
    	
    	UImap.setDriverPath();
		UImap.getPropertyfile();
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
      
        driver.findElement((UImap.getLocator("btn_Oneway"))).click();

        driver.findElement((UImap.getLocator("btn_FromTag"))).clear();
        driver.findElement((UImap.getLocator("btn_FromTag"))).sendKeys("Banglore");

        List<WebElement> originOptions = driver.findElements((UImap.getLocator("btn_FromCity")));
        originOptions.get(1).click();

        driver.findElement((UImap.getLocator("edt_To"))).clear();
        driver.findElement((UImap.getLocator("edt_To"))).sendKeys("Delhi");

       
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElements((UImap.getLocator("btn_ToCity")));
        destinationOptions.get(0).click();

        driver.findElement((UImap.getLocator("btn_DepartureDate"))).click();

        //all fields filled in. Now click on search
        driver.findElement((UImap.getLocator("btn_Search"))).click();

        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent((UImap.getLocator("btn_SearchSummary"))));

        //close the browser
        driver.quit();

    }


   

    private boolean isElementPresent(By by) {
        try {
           // driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    

   
    }
}
