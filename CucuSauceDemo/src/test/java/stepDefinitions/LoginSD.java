//package stepDefinitions;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginSD {
//	WebDriver driver=new ChromeDriver();
//	@Given("I am in the sauceDemo login page")
//	public void i_am_in_the_sauce_demo_login_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		    driver.get("https://www.saucedemo.com/v1/");
//		    driver.manage().window().maximize();
//		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//
//	@When("The user provides a valid user name")
//	public void the_user_provides_a_valid_user_name() {
//	    // Write code here that turns the phrase above into concrete actions
//	    WebElement ele=driver.findElement(By.xpath("(//input[@class=\"form_input\"])[1]"));
//	    ele.sendKeys("standard_user");
//	}
//
//	@When("user provides a valid password")
//	public void user_provides_a_valid_password() {
//	    // Write code here that turns the phrase above into concrete actions
//		 WebElement ele1=driver.findElement(By.xpath("(//input[@class=\"form_input\"])[2]"));
//		    ele1.sendKeys("secret_sauce");
//	}
//
//	@When("user clicks the login button")
//	public void user_clicks_the_login_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	   WebElement ele2=driver.findElement(By.xpath("//input[@class=\"btn_action\"]"));
//	   ele2.click();
//	}
//
//	@Then("the user can see the dashboard")
//	public void the_user_can_see_the_dashboard() {
//	    // Write code here that turns the phrase above into concrete actions
//		String k=driver.findElement(By.xpath("//div[@class=\"product_label\"]")).getText();
//	    String m="Products";
//	    Assert.assertEquals(k,m);
//	    System.out.println("success");
//	}
//	    
//	    @When("user provides a {string} password")
//	    public void user_provides_a_password(String string) {
//	        // Write code here that turns the phrase above into concrete actions
//	    	WebElement user=driver.findElement(By.xpath("(//input[@class=\"form_input\"])[1]"));
//	    	user.sendKeys("");
//	       
//	    }
//
//	    @Then("the user can see the Username is required message")
//	    public void the_user_can_see_the_username_is_required_message() {
//	        // Write code here that turns the phrase above into concrete actions
//	    	String k1=driver.findElement(By.xpath("(//input[@class=\"form_input\"])[1]")).getText();
//		    String m1="Username is required";
//		    Assert.assertEquals(k1,m1);
//		    System.out.println("Username is required");
//	    }
//
//	    @When("The user provides a {string} user name")
//	    public void the_user_provides_a_user_name(String string) {
//	        // Write code here that turns the phrase above into concrete actions
//	    	
//	       
//	    }
//
//	    @Then("the user can see the Password is required")
//	    public void the_user_can_see_the_password_is_required() {
//	        // Write code here that turns the phrase above into concrete actions
//	        
//	    }
//
//	    @When("The user provides a invalid user name")
//	    public void the_user_provides_a_invalid_user_name() {
//	        // Write code here that turns the phrase above into concrete actions
//	        
//	    }
//
//	    @When("user provides a invalid password")
//	    public void user_provides_a_invalid_password() {
//	        // Write code here that turns the phrase above into concrete actions
//	        
//	    
//	}
//}

package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {
	
	public WebDriver driver ;
	@Given("the user in on Login page")
	public void the_user_in_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@When("the user provides the valid username")
	public void the_user_provides_the_valid_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
	}

	@When("the user provides the valid password")
	public void the_user_provides_the_valid_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
	}

	@Then("the user is able to visible the ProductText in the same page")
	public void the_user_is_able_to_visible_the_product_text_in_the_same_page() {
		WebElement productPage = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div"));
		String productPageTxt = productPage.getText();
		String expectedProductPageTxt = "Products";
		Assert.assertTrue(productPageTxt.contains(expectedProductPageTxt));
		System.out.println("Loggedin successfully");
		driver.quit();
	}

	@When("the user provides the blank username")
	public void the_user_provides_the_blank_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("");
	}

	@Then("the user is able to visible the error message")
	public void the_user_is_able_to_visible_the_error_message() {
		WebElement error = driver.findElement(By.xpath("//div[@id=\"login_button_container\"]/div/form/h3"));
		System.out.println("---------------"+error.getText()+"---------------");
		driver.quit();
	}

	@When("the user provides the blank password")
	public void the_user_provides_the_blank_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
	}

	@When("the user provides the invalid username")
	public void the_user_provides_the_invalid_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_users");
	}

	@When("the user provides the invalid password")
	public void the_user_provides_the_invalid_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_saucess");
	}


}
