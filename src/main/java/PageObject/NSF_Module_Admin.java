package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(name="module_user_name") WebElement Phonenumber;
	@FindBy(name="module_user_password") WebElement Password;
	@FindBy (name="module_user_cnfpass") WebElement ConfirmPassword;
	@FindBy(xpath="//label[@data-bs-original-title=\"Change Profile Photo\"]") WebElement uploadImage;
	@FindBy(xpath="//a[@data-bs-target=\"#add_permissons_modal\"]") WebElement AddPermission;
	@FindBy(xpath="//button[text()='OK']") WebElement OKButton;
	
	
	

	public void OKb() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		//OKButton.click();
	}
	public void CreatModuleButton() {
		CreateModulebutton.click();
	}
	public void FirtsName(String name) {
		FirstName.sendKeys(name);	
	
	}
	public void email(String Email, String Phone) {
		EmailTest.sendKeys(Email);
		Phonenumber.sendKeys(Phone);
	}
	
	public void Password(String pass, String confirm) {
		Password.sendKeys(pass);
		ConfirmPassword.sendKeys(confirm);
		
	}
	public void uploImage(String img) {
		uploadImage.sendKeys(img);
	}
	
	public void addPermissionbutton(String permission) {
		AddPermission.sendKeys(permission);
	}
	
	
	
}
