package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	WebElement userNameElement = driver.findElement(By.id("username")); 
	userNameElement.sendKeys("Demosalesmanager");
	WebElement passwordElement = driver.findElement(By.id("password"));
	passwordElement.sendKeys("crmsfa");
	WebElement loginElement = driver.findElement(By.className("decorativeSubmit"));
	loginElement.click();	
	
	WebElement crmLinkElement = driver.findElement(By.linkText("CRM/SFA"));
	crmLinkElement.click();
	WebElement leadsElement = driver.findElement(By.linkText("Leads"));
	leadsElement.click();
	WebElement createLeadElement = driver.findElement(By.linkText("Create Lead"));
	createLeadElement.click();
	
	
	WebElement companyNameElement = driver.findElement(By.id("createLeadForm_companyName"));
	companyNameElement.sendKeys("TESTLEAF");
	WebElement firstNameElement = driver.findElement(By.id("createLeadForm_firstName")); 
	firstNameElement.sendKeys("Lavanya");
	WebElement lastNameElement = driver.findElement(By.id("createLeadForm_lastName")); 
	lastNameElement.sendKeys("B");
	WebElement firstNameLocalElement = driver.findElement(By.id("createLeadForm_firstNameLocal")); 
	firstNameLocalElement.sendKeys("B");
	WebElement departmentNameElement = driver.findElement(By.id("createLeadForm_departmentName")); 
	departmentNameElement.sendKeys("Automation");
	WebElement descriptionElement = driver.findElement(By.id("createLeadForm_description")); 
	descriptionElement.sendKeys("Creation of lead through selenium automation");
	WebElement emailAddressElement = driver.findElement(By.id("createLeadForm_primaryEmail")); 
	emailAddressElement.sendKeys("test123@gmail.com");
    
	WebElement stateProvinceElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));	
	Select state = new Select (stateProvinceElement);
	state.selectByVisibleText("New York"); 
	
		
	WebElement createLeadButtonElement = driver.findElement(By.name("submitButton"));
	createLeadButtonElement.click();
	
	String title = driver.getTitle();
	System.out.println("The title of the page after create Lead is " + title);
	
	//duplicate Lead
	
	WebElement duplicateLeadElement = driver.findElement(By.linkText("Duplicate Lead"));
	duplicateLeadElement.click();
	
	
	WebElement companyNameDuplicateLeadElement = driver.findElement(By.id("createLeadForm_companyName"));
	companyNameDuplicateLeadElement.clear();
	companyNameDuplicateLeadElement.sendKeys("TESTLEAFNEW");
	
	WebElement firstNameDuplicateLeadElement = driver.findElement(By.id("createLeadForm_firstName")); 
	firstNameDuplicateLeadElement.clear();
	firstNameDuplicateLeadElement.sendKeys("NewFirstName");
	
	WebElement createLeadDuplicateLeadButtonElement = driver.findElement(By.name("submitButton"));
	createLeadDuplicateLeadButtonElement.click();
	
	String title1 = driver.getTitle();
	System.out.println("The title of the page after duplicate lead is " + title1);
	
	driver.close();
}
}
