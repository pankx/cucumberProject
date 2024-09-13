package hellocucumber;

import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Then;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Stepdefs {

	private WebDriver driver;
	int listSize = 0;

	@Given("user navigates to the website {string}")
	public void user_navigates_to_the_website(String url) {
		driver.get(url);
	}

	@Given("click on Add Button")
	public void click_on_Add_Button() {
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
		listSize = list.size();
		driver.findElement(By.xpath("//button[@type='add']")).click();

	}

	@Given("user enter the {string} {string}")
	public void user_enter_the(String string, String string2) {
		sendKeys(string, string2);
	}

	@Given("user enter the LastName {string} {string}")
	public void user_enter_the_LastName(String string, String string2) {
		sendKeys(string, string2);

	}

	@Given("user enter the UserName {string} {string}")
	public void user_enter_the_UserName(String string, String string2) {
		sendKeys(string, string2);
	}

	@Given("user enter the Password {string} {string}")
	public void user_enter_the_Password(String string, String string2) {
		sendKeys(string, string2);

	}

	@Given("user Select the Customer {string}")
	public void user_Select_the_Customer(String string) {
		clickButton(string);
	}

	@Given("user Select the Role {string}")
	public void user_Select_the_Role(String string) {
		selectFromDrobDown(string);

	}

	@Given("user enter the Email {string} {string}")
	public void user_enter_the_Email(String string, String string2) {
		sendKeys(string, string2);

	}

	@Given("user enter the Phone {string} {string}")
	public void user_enter_the_Phone(String string, String string2) {
		sendKeys(string, string2);

	}

	@Given("user clicks {string}")
	public void user_clicks(String string) {
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
	}

	@Then("check user {string} is created")
	public void check_user_is_created(String string) {
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[position()='1']"));
		boolean b = false;
		for (WebElement el : list) {
			if (el.getText().equals(string)) {
				b = true;
				break;
			}
		}
		assertEquals(b, true);
	}

	@Given("click the user {string}")
	public void click_the_user(String string) {
		deleteUser(string);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	}

	@Then("check user {string} is deleted")
	public void check_user_is_deleted(String string) {
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[position()='2']"));
		boolean b = false;
		for (WebElement el : list) {
			if (el.getText().equals(string)) {
				b = true;
				break;
			}
		}
		assertEquals(b, false);
	}
	
	
	@Given("browser is initialized")
	public void browser_is_initialized() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	public void sendKeys(String xpath, String string) {

		driver.findElement(By.xpath("//input[@name='" + xpath + "']")).sendKeys(string);
	}

	private void clickButton(String string) {

		driver.findElement(By.xpath("//label[contains(.,'" + string + "')]")).click();

	}

	public void selectFromDrobDown(String string) {

		Select select = new Select(driver.findElement(By.name("RoleId")));
		select.selectByVisibleText(string);

	}

	public void deleteUser(String string) {

		driver.findElement(By.xpath("//tbody/tr[contains(.,'" + string + "')]/td/button/i[@class='icon icon-remove']"))
				.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("error");
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
	}

	@Then("close driver")
	public void close_driver() {
	   driver.close();
	}
	
	
	
	
	
	
	
	
	
	

}