package Treflo_with_pass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POJO_Class extends baseclass{
	public POJO_Class() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@name='username']")
	//@FindBy(xpath = "//input[@placeholder='Enter here']");
	private WebElement mobil_Num;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	
	public WebElement getMobil_Num() {
		return mobil_Num;
	}
	public WebElement getLogin() {
		return login;
	}
	
}
