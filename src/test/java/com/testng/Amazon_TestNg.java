package com.testng;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_TestNg {
	WebDriver driver = null;

	private static ChromeOptions desiredOption() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		return option;

	}

	@BeforeTest
	private void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(desiredOption());

	}

	@BeforeClass
	private void launchUrl() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = -1)
	private void dropDown() {
		String s = "baby";
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select sel = new Select(dropdown);
		List<WebElement> options = sel.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement getoption = options.get(i);
			String text = getoption.getText();
			if (text.equalsIgnoreCase(s)) {
				sel.selectByVisibleText(text);

			}
		}

	}

	@Test(dependsOnMethods = "dropDown")
	private void searchinput() throws InterruptedException {
		String s1 = "soft toys";
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(s1);
		Thread.sleep(2000);

//			List<WebElement> relevant = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		List<WebElement> relevant = driver
				.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div/div"));

		for (int i = 1; i <= relevant.size(); i++) {

//				WebElement eachProduct = driver.findElement(By.xpath(
//						"//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));
			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div[" + i + "]/div/div[@role='button']"));

			String eachProductText = eachProduct.getText();

			if (eachProductText.equalsIgnoreCase(s1)) {
				eachProduct.click();
				break;

			}

		}
	}

	@Test(priority = 1)
	private void clickable() throws InterruptedException {
		Thread.sleep(1000);
//      WebElement firstPdtTitle = driver.findElement(By.xpath("//div[@class='s-no-outline']/following::div/following::div/h2"));
		WebElement firstPdtTitle = driver.findElement(
				By.xpath("//span[text()='RESULTS']//following::div[@class='sg-col-inner'][1]//descendant::h2//a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstPdtTitle);
		String text = firstPdtTitle.getText();
		System.out.println(text);

		Thread.sleep(1000);
		WebElement firstPdtPrice = driver.findElement(By.xpath(
				"//div[@class='s-no-outline']/following::div/following::div/h2/following::span[1][@class='a-price']"));
		String text2 = firstPdtPrice.getText();
		System.out.println(text2);
		String parentid = driver.getWindowHandle();
		Thread.sleep(1000);
//     WebElement firstPdt = driver.findElement(By.xpath("//span[text()='RESULTS']//following::div[@class='sg-col-inner'][1]//descendant::h2//a"));
//     WebElement firstPdt = driver.findElement(By.xpath("//div[@class='s-no-outline']/following::div/following::div/h2"));
		firstPdtPrice.click();

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		for (String id : windowHandles) {
			if (!id.equals(parentid)) {
				driver.switchTo().window(id);

			}

		}
		WebElement clickableLink = driver
				.findElement(By.xpath("//div[@id='centerCol']//child::div[@id='title_feature_div']"));
		String text3 = clickableLink.getText();
		if (text3.equalsIgnoreCase(text)) {
			System.out.println("link match same");

		} else {
			System.out.println("link doesn't match");
		}
		WebElement clickablePdtPrice = driver.findElement(By.xpath(
				"//div[@id='centerCol']//child::div[@id='title_feature_div']/following::div/following::div[@id='corePriceDisplay_desktop_feature_div']/child::div/span/span[@class='a-offscreen']"));
		String text4 = clickablePdtPrice.getText();
		if (text4.equalsIgnoreCase(text2)) {
			System.out.println("Price match same");
		} else {
			System.out.println("Price doesn't match");
		}
	}

	@Test(priority = 2,invocationCount = 2)
	private void addtoCart() {
		WebElement addtoCart = driver.findElement(By.id("add-to-cart-button"));
		addtoCart.click();
		WebElement clickCart = driver.findElement(By.id("nav-cart-count"));
		clickCart.click();
		WebElement pToCart = driver.findElement(By.name("proceedToRetailCheckout"));
		pToCart.click();
	}

	@AfterClass
	private void screenShot() throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;

		File s2 = t.getScreenshotAs(OutputType.FILE);

		File f1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\Amazon_Project_vj\\screenshots\\testng.png");
		FileUtils.copyFile(s2, f1);
	}

	@AfterTest@Ignore
	private void browserClose() {
		driver.close();
	}
}
