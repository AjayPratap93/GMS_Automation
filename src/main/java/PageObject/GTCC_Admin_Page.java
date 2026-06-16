package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
public class GTCC_Admin_Page {
	
	WebDriver driver;
	public GTCC_Admin_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="email") WebElement UserName;
	@FindBy(name="password") WebElement Password;
	@FindBy(xpath="//button[normalize-space()='Log In']") WebElement LoginButton;
	
	public void loginAdmin() throws InterruptedException {
		ConfigReader config = new ConfigReader();
		Thread.sleep(3000);
		UserName.sendKeys(config.getUsername());
		Thread.sleep(3000);
		Password.sendKeys(config.getPassword());
		Thread.sleep(3000);
		LoginButton.click();
		}
}
