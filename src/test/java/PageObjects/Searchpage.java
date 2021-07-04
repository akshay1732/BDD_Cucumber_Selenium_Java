package PageObjects;

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

    // XPath- Using Single Attribute
    //<HTML tag>[@attribute_name='attribute_value']

    //Using Multiple Attribute
    //<HTML tag>[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2]

    //XPath- Using And
    //<HTML tag>[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2]

    //XPath- Using Or
    //<HTML tag>[@attribute_name1='attribute_value1' or @attribute_name2='attribute_value2]

    //XPath- contains()
    // <HTML tag>[contains(@attribute_name,'attribute_value')]

    //XPath- starts-with()
    //<HTML tag>[starts-with(@attribute_name,'attribute_value')]

    //XPath- text()
    //<HTML tag>[text()='Google offered in']

    //XPath- last()
    //<HTML tag>[@type='text'])[last()]

    //CSS- Tag and ID
    //Tag#Value of id attribute

    //CSS-Tag and Class
    //Tag.Value of Class attribute

    //Tag and Attribute
    //Tag[Attribute=value]

    //Tag, ID/Class and Attribute
    //tag.class[attribute=value]
    //tag.#ID[attribute=value]

    //CSS- Sub-String Matches
    //1. Starts with (^):   //Tag[attribute^=prefix of the string]
    //2. Ends with ($): //Tag[attribute$=suffix of the string]
    //3. Contains (*):< //Tag[attribute*=sub-string]
    // button:contains("Log In")














}
