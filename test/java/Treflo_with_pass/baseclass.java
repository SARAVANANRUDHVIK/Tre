package Treflo_with_pass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.it.Date;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class baseclass {
	static WebDriver driver;
//	//1
	public static void browserchrome() {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();     
	}
	//2

	public void browserconfigedge() {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
	     }
	//3
	public void firefox() {
			WebDriverManager.firefoxdriver().setup();
			driver =(WebDriver) new GeckoDriverInfo();
	}
	public  void waits() throws InterruptedException {
		Thread.sleep(3000);

	}
	//4
	public void configIE() {
			WebDriverManager.iedriver().setup();
	    	driver=new InternetExplorerDriver();
	     
	}
	//5
	public static void OpenUrl(String Url) {
		driver.get(Url);


	}
	//6
	public static void maximizewindow() {
		driver.manage().window().maximize();


	}
	//7
	public  WebElement locatebyid(String id) {
	WebElement findElement = driver.findElement(By.id(id));
	return findElement;
		

	}
	//8
	public static WebElement locatebyname(String name) {
	WebElement findElement = driver.findElement(By.id(name));
	return findElement;
	}
	//9
	public static WebElement locatebyXPATH(String xpath) {
	WebElement findElement = driver.findElement(By.xpath(xpath));
	return findElement;
	}
	//10
	public static void textinput(WebElement element, String value) {
		element.sendKeys(value);
		

	}//11
	public  Actions acc(WebElement source, WebElement target) {
		Actions acc= new Actions(driver);
	return acc;
	}
	//12
	public static Alert A(WebElement element) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		alert.accept();
		alert.sendKeys("saravana");
	return alert;
	}

	//13
	public static Alert B(WebElement element2) {
		Alert B = driver.switchTo().alert();
		B.dismiss();
	return B;
	}
	//14
	public static Alert C(WebElement element3) {
			Alert C = driver.switchTo().alert();
		C.sendKeys("saravnan");
	return C;


	}
	//15
	public static void click (WebElement element) {
	element.click();	


	}
	public  String getTheAttribute(WebElement element,String value) {
	String attribute = element.getAttribute(value);

	return attribute;
	}
	public  String gettext(WebElement element) {
	String text2 = element.getText();
	System.out.println(text2);
	return text2;
	}





	//16-20
	public static  Select dropdown() {
		Select s=new Select(null);
	Object element;
	return dropdown();
		
		
	}
	//21
	public static void JavascriptExecutor() {
	JavascriptExecutor jk=  (JavascriptExecutor)driver;
	jk.executeScript("", "");
	}
	//22
	public  String screenshot(String path) throws Throwable {
	TakesScreenshot tk = (TakesScreenshot)driver;
	File src=tk.getScreenshotAs(OutputType.FILE);
	File des =new File(path);
	FileUtils.copyFile(src, des);
	 return File.pathSeparator;


	}
	public Screenshot fullpagescreenshot() throws IOException {

	Screenshot Screenshot = new AShot().shootingStrategy
	(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

	ImageIO.write(Screenshot.getImage(), "jpg", new File
	(""));
	return Screenshot;

	}






	public  String read(String path,String Sheet,int rowno,int cellno) throws Exception {
		String value =null;
		File f=new File(path);
		
		FileInputStream FIN =new FileInputStream(f);
		Workbook w=new XSSFWorkbook(FIN);
		Sheet s = w.getSheet(Sheet);
		//for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row row = s.getRow(rowno);
		//for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		Cell cell = row.getCell(cellno);
		System.out.println(cell);
		
		int cellType = cell.getCellType();
		
		if (cellType==1) {
			value = cell.getStringCellValue();
			System.out.println(value);
		}
		else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = (Date) cell.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd/mm/yyyy");
				value= sim.format(dateCellValue);
				System.out.println(value);
				}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l= (long)numericCellValue;
				 value = String.valueOf(l);
				System.out.println(value);
			}
			
			
		}
		return value;	
		
		
		
			
		
		
		
		
		
		
		}

	//23 
	public  Actions actiontest(WebElement element) {
	Actions acc  =	new Actions(driver);
	acc.doubleClick(element).perform();
	acc.contextClick(element).perform();
	return (Actions) element;

	}


	//18


		

	//23 
	public void Closebrowser() {
	driver.close();

	}
	//20

	public void quitBrowser() {
		driver.quit();





	}
	public void refresh() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(" ")));
		Wait w= new FluentWait(driver).
		withTimeout(Duration.ofSeconds(5)).
		pollingEvery(Duration.ofSeconds(3)).
		ignoring(NoSuchElementException.class);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("")));
	}
	public static void Sendkeys(WebElement element,String data) {
element.sendKeys(data);

	}
}
