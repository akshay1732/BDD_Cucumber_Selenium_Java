package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
    WebDriver driver;

    @FindBy(name="btnK")
    WebElement searchbutton;

    @FindBy(name="btnI")
    WebElement iamfeelingbutton;

    @FindBy(name="q")
    WebElement searchbox;

    public Searchpage(WebDriver instance){
        this.driver=instance;
        PageFactory.initElements(driver,this);

    }

    public void clicksearchbutton(){
        searchbutton.click();
    }

    public String entersearchvalue(String searchterm){
        searchbox.sendKeys(searchterm);
        String value=searchbox.getAttribute("value");
        return value;

    }


    public void clickimfeelingbutton(){
        iamfeelingbutton.click();
    }

    public String getpagetitle(){
        String title = driver.getTitle();
        return title;
    }





}
