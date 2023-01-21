package com.baseclass_script;

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

import com.amazon_project_vj.Amazon_Project_vj.Base_Class;
import com.pom.AddToCartPage;
import com.pom.CartPage;
import com.pom.HomePage;
import com.pom.ProceedToBuyPage;
import com.pom.ProductPage;
import com.pom.SDP;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_BaseClass_Script extends Base_Class {
	public static WebDriver driver; // null

	public static void main(String[] args) throws InterruptedException, IOException {

		driver = browserLaunch("chrome"); // chrome
		launchUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String s = "baby";

		HomePage hp = new HomePage(driver);

		sleep();
		List<WebElement> options = selectGetOption(hp.getDropdown());
		for (int i = 0; i < options.size(); i++) {
			WebElement getoption = options.get(i);
			String text = getText(getoption);

			if (text.equalsIgnoreCase(s)) {

				selectDropDown(hp.getDropdown(), "text", text);
			}

		}
		String s1 = "soft toys";
		userInput(hp.getSearchbox(), s1);
		sleep();

		for (int i = 1; i <= hp.getRelevant().size(); i++) {

			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div[" + i + "]/div/div[@role='button']"));

			String text = getText(eachProduct);

			if (text.equalsIgnoreCase(s1)) {
				eachProduct.click();
				break;

			}

		}
		sleep();
		ProductPage pp = new ProductPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pp.getFirstPdtTitle());
		String text = getText(pp.getFirstPdtTitle());
		System.out.println(text);

		sleep();
		String text2 = getText(pp.getFirstPdtPrice());
		System.out.println(text2);
		String parentid = windowHandle();
		Thread.sleep(1000);

		clickOnElement(pp.getFirstPdtPrice());

		String title = getTitle();
		System.out.println(title);

		Set<String> windowHandles = windowHandles();
		System.out.println(windowHandles.size());
		for (String id : windowHandles) {
			if (!id.equals(parentid)) {
				driver.switchTo().window(id);

			}

		}
		AddToCartPage ad = new AddToCartPage(driver);
		String text3 = getText(ad.getClickableLink());
		if (text3.equalsIgnoreCase(text)) {
			System.out.println("link match same");

		} else {
			System.out.println("link doesn't match");
		}
		String text4 = getText(ad.getClickablePdtPrice());
		if (text4.equalsIgnoreCase(text2)) {
			System.out.println("Price match same");
		} else {
			System.out.println("Price doesn't match");
		}

		clickOnElement(ad.getAddtoCart());
		CartPage cp = new CartPage(driver);

		clickOnElement(cp.getClickCart());

		ProceedToBuyPage pb = new ProceedToBuyPage(driver);
		clickOnElement(pb.getPToCart());

		TakesScreenshot t = (TakesScreenshot) driver;

		File s2 = t.getScreenshotAs(OutputType.FILE);

		File f1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\Amazon_Project_vj\\screenshots\\Proceedtopay.png");
		FileUtils.copyFile(s2, f1);

		windowClose();
		windowQuit();
	}

}
