package Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationsFile {
	
 	WebDriver driver =null;
 	
	
	
	@Given("Initialize the browser")
	public void initialize_the_browser() {
		System.setProperty("webdriver.chrome.driver", "C:/eclipse/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
	}

	@And("User navigate to {string} website")
	public void user_navigate_to_website(String url) {
		
		driver.get(url);
	  
	}

	@When("User hoovers the mouse on to {string}")
	public void user_hoovers_the_mouse_on_to(String string) {
		
		Actions action = new Actions(driver);
		WebElement we = locator(string, 1);
		action.moveToElement(we).build().perform();
	    
	}

	@Then("User gets text from {string} element and {string} element and compares them")
	public void user_gets_text_from_element(String string1, String string2) {
	    
		String Text_1 = locator(string1, 1).getAttribute("innerHTML");
		System.out.println(Text_1);
		
		String Text_2 = locator(string2, 1).getAttribute("innerHTML");
		System.out.println(Text_2);
		
		 Assert.assertNotEquals(Text_1, Text_2);
		
		
	}
	
	@Then("User validates {string} product is in the basket")
	public void user_validates_product_is_in_the_basket(String string) {
		
		String Text_3 = locator(string, 1).getAttribute("innerHTML");
		WebElement Product = locator(string, 1);
		
		
		if( Product.isEnabled()== true)
		{
			
			
			System.out.println(Text_3 + " is in the basket!");
		
		}
		
		else
		{
			
			System.out.println(Text_3 + " is NOT in the basket!");
		}
	}

	
	
	@Then("User closes the browser")
	public void user_closes_the_browser() {
	    
		driver.close();
	}
	
	
	@And("User clicks to {string} element")
	public void user_clicks_to_element(String string) {
		
		try {
			locator(string, 1).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			locator(string, 1).click();
		}
		
		catch(org.openqa.selenium.ElementClickInterceptedException ex)
		{
			Actions action = new Actions(driver);
			WebElement x = locator(string, 1);
			action.moveToElement(x).click();
			
		
			
		}
		
		catch(java.lang.IndexOutOfBoundsException ex)
		{
			
			driver.findElement(By.xpath("//div[text()='Yarın Teslimat']")).click();
			
		}
		
		
		
	}

	@And("User enters {string} text in {string} textbox")
    public void user_enters_a_text_in_text_box(String text,String inputbox) {
        locator(inputbox,1).sendKeys(text);
    }

	@Then("Verify that user is succesfully logged in with {string}")
	public void verify_that_user_is_succesfully_logged_in(String UserID) {
		
		if(locator(UserID, 1).isDisplayed() == true)
		{
			
			System.out.println("Login is successful.");
			
		}
		
	}
	
	
	public WebElement locator(String element, int index) {
        WebElement myelem=null;

        if(element.startsWith("//")|element.startsWith("(//")){
            myelem=driver.findElements(new By.ByXPath(element)).get(index-1);
        }
        else if(element.startsWith("#")||element.startsWith(".")){
            myelem=driver.findElements(new By.ByCssSelector(element)).get(index-1);
        }
            
        else if(element.startsWith("(")){
            myelem=driver.findElements(new By.ByXPath(element)).get(index-1); 
  
            
        }
        else if(element.contains("=")){
            if(index==0){
                index=1;
            }
            String []array=element.split("=");
            myelem=driver.findElement(new By.ByXPath("(//*[@"+array[0]+"='"+array[1]+"'])["+index+"]"));
        }
        else{
            myelem=driver.findElement(new By.ByXPath("//*[text()='"+element+"' or contains(text(),'"+element+"')]" ));
        }
        return myelem;
    }
	
	@Then("User tab to {string}")
    public void clickKeyboard(String key)
    {
        Actions action = new Actions(driver);
        switch (key)
        {
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                System.out.println(key+ " clicked");
                break;
            case "TAB":
                action.sendKeys(Keys.TAB).build().perform();
                System.out.println(key+ " clicked");
                break;
            case "PAGE_DOWN":
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
                System.out.println(key+ " clicked");
                break;
            case "PAGE_UP":
                action.sendKeys(Keys.PAGE_UP).build().perform();
                System.out.println(key+ " clicked");
                break;
            default:
                System.out.println("");
        }

	

}
}