package com.tau.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tau.base.BaseUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps extends BaseUtil {
	
	private BaseUtil baseUtil;
	public Steps(BaseUtil util ) {
		this.baseUtil = util;
	}
	
	
	
	private WebDriver driver;
	
		
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("I am in the login page of the para bank application")
	public void i_am_in_the_login_page_of_the_para_bank_application() {
	//	System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver_win32 (3)\\chromedriver.exe");
	//	driver = new ChromeDriver();
		
	   driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials(String username, String password, String userFullName1)  {
	
       // List<String> loginform = table.asList();	
		
		baseUtil.userFullNmae = userFullName1;
		
        driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("username")).submit();
	   
	}

	@Then("I should be taken to the overview page.")
	public void i_should_be_taken_to_the_overview_page() throws InterruptedException {
		Thread.sleep(2000);
		String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
		System.out.println(baseUtil.userFullNmae.toString());
		assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullNmae) );
		
		
		driver.findElement(By.linkText("Log Out")).click();
		//driver.quit();
	   
	}
	
	@After()
	public void quitBrowser() {
		driver.quit();
	}
	
}
