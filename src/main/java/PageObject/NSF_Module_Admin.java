package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NSF_Module_Admin {
	
	WebDriver driver;
	public NSF_Module_Admin(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
				}
	
	// Create Module Admin
	@FindBy(xpath="//a[normalize-space()='Create Module User']") WebElement CreateModulebutton;
	// Create Module Users
	
	@FindBy(name="module_user_name" ) WebElement FirstName;
	@FindBy (name="module_user_email") WebElement EmailTest;
	@FindBy(xpath="//input[@placeholder=\"Enter Phone Number\"]") WebElement Phonenumber;
	@FindBy(name="module_user_password") WebElement Password;
	@FindBy (name="module_user_cnfpass") WebElement ConfirmPassword;
	@FindBy(xpath="//input[@type=\"file\"]") WebElement uploadImage;
	@FindBy(xpath="//a[@data-bs-target=\"#add_permissons_modal\"]") WebElement AddPermission;
	@FindBy(xpath="(//span[contains(text(),'Select User Type')])[2]") WebElement SelectUserType;
	@FindBy(xpath="//li[@class=\"select2-results__option select2-results__option--selectable\"]") List<WebElement> chooseUserType;
	@FindBy(xpath="//li[.='Athlete']") WebElement Athelet_UserType;
	@FindBy(xpath="//li[normalize-space()='Andhra Pradesh']") WebElement Select_State;
	@FindBy(xpath="//span[@id=\"select2-user_states-container\"]") WebElement Click_State_Button;
	@FindBy(xpath="//span[@id=\"select2-user_sports-container\"]") WebElement Select_Sports;
	@FindBy(xpath="//li[@class=\"select2-results__option select2-results__option--selectable\"]") List<WebElement> Send_Sports;
	@FindBy(xpath="//span[normalize-space()='Select Gender']/ancestor::span[@class=\"select2-selection__rendered\"]") WebElement Select_Gender;
	@FindBy(xpath="//li[@class=\"select2-results__option select2-results__option--selectable\"]") WebElement Send_Gender_Femal;
	@FindBy(xpath="//li[normalize-space()='Male']") WebElement Send_Gender_Male;
	@FindBy(xpath="//a[@class=\"btn custom-btn add_user_permissions\"]") WebElement AddPermission_Button;
	@FindBy(xpath="//button[text()='Confirm']") WebElement Confirm_Button;
	@FindBy(xpath="//button[text()='Close']") WebElement Close_Button;
	@FindBy(xpath="(//span[normalize-space()='Create Module Users'])[3]") WebElement Final_Createbutton;
	@FindBy(xpath="//button[normalize-space()='Confirm']") WebElement Fin_Confirm_But;
	public void clickOK() {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement okBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]"))
	    );

	    okBtn.click();
	}
	public void CreatModuleButton() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateModulebutton);
		CreateModulebutton.click();
	}
	public void FirtsName(String name) {
		FirstName.sendKeys(name);	
	}
	public void email(String Email) throws InterruptedException {
		EmailTest.sendKeys(Email);
		Thread.sleep(1000);
		
	}
	public void phonenumber(String Phone) {
		Phonenumber.sendKeys(Phone);
	}
	public void Password(String pass, String confirm) {
		Password.sendKeys(pass);
		ConfirmPassword.sendKeys(confirm);	
	}
	public void uploImage(String img) throws InterruptedException {
		Thread.sleep(1000);
		uploadImage.sendKeys(img);
	}
	
	public void addPermissionbutton() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", AddPermission);
		Thread.sleep(1000);
		AddPermission.click();
	}
	
	public void chooseUSerTYpe() throws InterruptedException {
		Thread.sleep(2000);
		SelectUserType.click();
		String name="Athlete";
		Thread.sleep(2000);
		Athelet_UserType.click();
		
		/*
		 * for(WebElement type:chooseUserType ) {
		 * if(type.getText().equalsIgnoreCase(name)) { type.click(); return; } }
		 */
	}
	
	public void selectState() throws InterruptedException {
		Thread.sleep(2000);
		Click_State_Button.click();
		Thread.sleep(2000);
		Select_State.click();
	}
	public void SelectSports() throws InterruptedException {
		Select_Sports.click();
		Thread.sleep(2000);
		String SportsName="Badminton";
		for(WebElement spo:Send_Sports) {
			if(spo.getText().equals(SportsName)) {
				spo.click();
				return;
			}
		}
	}
	
	public void selectGender() throws InterruptedException {
		Thread.sleep(2000);
		
		Select_Gender.click();
		Send_Gender_Male.click();
		//Send_Gender_Femal.click();
	}
	public void addPermissionButton() throws InterruptedException
	{
		Thread.sleep(2000);
		AddPermission_Button.click();
		Thread.sleep(2000);
		Confirm_Button.click();
		Thread.sleep(2000);
		Close_Button.click();
	}
	
	public void finalCreateButton() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", Final_Createbutton);
		Thread.sleep(4000);
		Final_Createbutton.click();
		 Fin_Confirm_But.click();
		
	}
}
