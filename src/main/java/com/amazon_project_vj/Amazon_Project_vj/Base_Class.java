package com.amazon_project_vj.Amazon_Project_vj;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) {
		element.click();

	}

	public static void clearTheElement(WebElement element) {
		element.clear();

	}

	public static String getAttributePlaceHolder(WebElement element) {
		String attribute = element.getAttribute("placeholder");
		System.out.println(attribute);
		return attribute;

	}

	public static void getAttributeValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}

	public static String getText(WebElement element) {
		String text = element.getText();
//		System.out.println(text);
		return text;

	}

	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);

	}

	public static void isEnable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}

	public static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);

	}

	public static WebDriver browserLaunch(String browsers) {
		if (browsers.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browsers.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browsers.equalsIgnoreCase("gecko")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");

		}
		return driver;

	}

	public static void windowMaxi() {
		driver.manage().window().maximize();
	}

	public static void windowFullscreen() {
		driver.manage().window().fullscreen();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String title = driver.getTitle();
		return title;
	}

	public static void windowClose() {
		driver.close();

	}

	public static void windowQuit() {
		driver.quit();
	}

	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	public static Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	public static void navigate() {
		driver.navigate();

	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void robotActionDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	public static void robotActionUp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);

	}

	public static void robotActionEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void alertSimple() {
		driver.switchTo().alert().accept();

	}

	public static void alertConfirm() {
		driver.switchTo().alert().dismiss();

	}

	public static void alertPrompt(String value) {
		driver.switchTo().alert().sendKeys(value);

	}

	public static void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void frameDefault() {
		driver.switchTo().defaultContent();

	}

	public static void frameParent() {
		driver.switchTo().parentFrame();
	}

	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;

	}

	public static void mouseAction(WebDriver driver, String option, WebElement element) {
		Actions a = new Actions(driver);
		if (option.equalsIgnoreCase("movetoelement")) {
			a.moveToElement(element).build().perform();

		} else if (option.equalsIgnoreCase("click")) {
			a.click(element).build().perform();

		} else if (option.equalsIgnoreCase("rightclick")) {
			a.contextClick(element).build().perform();

		} else if (option.equalsIgnoreCase("doubleclick")) {
			a.doubleClick(element).build().perform();

		}

	}

	public static void mouseDragDrop(WebDriver driver, WebElement element, WebElement element1) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element1).build().perform();
	}

	public static void selectDropDown(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		} else if (option.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);

		}
	}

	public static void deselectDropDown(WebElement element, String value, String option) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("devalue")) {
			s.deselectByValue(value);

		} else if (option.equalsIgnoreCase("detext")) {
			s.deselectByVisibleText(value);
		} else if (option.equalsIgnoreCase("deindex")) {
			int parseInt = Integer.parseInt(value);
			s.deselectByIndex(parseInt);

		}

	}

	public static List<WebElement> selectGetOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
//		System.out.println(options);
		return options;

	}

	public static void selectGetAllSelOpt(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		System.out.println(allSelectedOptions);

	}
	public static void selectGetFirSelOpt(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
		

	}
	public static void selectIsMul(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);


	}

}


