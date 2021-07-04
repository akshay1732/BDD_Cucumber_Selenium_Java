package Utilities;

import io.cucumber.datatable.DataTable;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CommonFunctions {

    public WebDriver driver;

    public CommonFunctions(WebDriver driver_instance){
        this.driver=driver_instance;
    }

    public Select getdropdownwithID(String ID){
        WebElement testDropDown = driver.findElement(By.id(ID));
        return new Select(testDropDown);
    }

    public Select getdropdownwithXpath(String xpath){
        WebElement testDropDown = driver.findElement(By.xpath(xpath));
        return new Select(testDropDown);
    }

    public WebElement getelementwithID(String ID){
        return driver.findElement(By.id(ID));
    }

    public WebElement getelementwithXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }


    public void clickonelementwithID(String ID){
        WebElement element = driver.findElement(By.id(ID));
        element.click();
    }

    public void clickonelementwithXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

            }
    public void savescreenshot() throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
        // capturing screen shot as output type file
        File screenshotSRC= ts.getScreenshotAs(OutputType.FILE);
        // Defining path and extension of image
        String path=System.getProperty("user.dir")+"/ScreenCapturesPNG/"+System.currentTimeMillis()+".png";
        // copying file from temp folder to desired location
        File screenshotDest= new File(path);
       // FileUtils.copyFile(screenshotSRC, screenshotDest);
    }

    public void entertextininputwithID(String ID,String text){
        WebElement element = driver.findElement(By.id(ID));
        element.sendKeys(text);
    }

    public void entertextininputwithXpath(String xpath,String text){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    public WebElement getelementcontainingvalue(String text){
        String temp = "*[text()='"+text+"']";
        return driver.findElement(By.xpath(temp));

    }

    public WebElement getelementwithcss(String selector){
        return driver.findElement(By.cssSelector(selector));
    }

    public void clickonelementwithcss(String selector){
        Wait wait = new WebDriverWait(driver,15);
       // wait.until(ExpectedConditions.)
        DataTable t = null;

        WebElement element = driver.findElement(By.cssSelector(selector));
        element.click();
    }

    public Select getdropdownwithcss(String selector){
        WebElement testDropDown = driver.findElement(By.cssSelector(selector));
        return new Select(testDropDown);
        //dropdown.selectByIndex(5);/deselectByIndex(5);
        //dropdown.selectByValue("Database");/deselectByValue("Database")
        //dropdown.selectByVisibleText("Database Testing");/deselectByVisibleText("Database Testing");
        //deselectall()/ismultiple()
    }

    public void entertextininputwithcss(String selector,String text){
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys(text);
    }

    //radio button
    //<input type="radio" name="group1" value="Mango">Mango<br>


    public void PerformAction(WebDriver driver){
        Actions actions = new Actions(driver);
        Action action = actions.build();
        action.perform();
        
    }
}
