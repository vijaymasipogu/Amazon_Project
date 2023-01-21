package com.pom_sdp;

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

import com.amazon_project_vj.Amazon_Project_vj.Base_Class;
import com.pom.SDP;

public class Sdp_Pom extends Base_Class {

	public static WebDriver driver; // null

	public static void main(String[] args) throws InterruptedException, IOException {

		driver = browserLaunch("chrome"); // chrome
		launchUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String s = "baby";

		SDP sdp = new SDP(driver); // null - chrome

		sleep();
		List<WebElement> options = selectGetOption(sdp.getHomePage().getDropdown());
		for (int i = 0; i < options.size(); i++) {
			WebElement getoption = options.get(i);
			String text = getText(getoption);

			if (text.equalsIgnoreCase(s)) {

				selectDropDown(sdp.getHomePage().getDropdown(), "text", text);
			}

		}
		String s1 = "soft toys";
		userInput(sdp.getHomePage().getSearchbox(), s1);
		sleep();

		for (int i = 1; i <= sdp.getHomePage().getRelevant().size(); i++) {

			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div[" + i + "]/div/div[@role='button']"));

			String text = getText(eachProduct);

			if (text.equalsIgnoreCase(s1)) {
				eachProduct.click();
				break;

			}

		}
		sleep();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", sdp.getProducPage().getFirstPdtTitle());
		String text = getText(sdp.getProducPage().getFirstPdtTitle());
		System.out.println(text);

		sleep();
		String text2 = getText(sdp.getProducPage().getFirstPdtPrice());
		System.out.println(text2);
		String parentid = windowHandle();
		Thread.sleep(1000);

		clickOnElement(sdp.getProducPage().getFirstPdtPrice());

		String title = getTitle();
		System.out.println(title);

		Set<String> windowHandles = windowHandles();
		System.out.println(windowHandles.size());
		for (String id : windowHandles) {
			if (!id.equals(parentid)) {
				driver.switchTo().window(id);

			}

		}

		String text3 = getText(sdp.getAddToCart().getClickableLink());
		if (text3.equalsIgnoreCase(text)) {
			System.out.println("link match same");

		} else {
			System.out.println("link doesn't match");
		}
		String text4 = getText(sdp.getAddToCart().getClickablePdtPrice());
		if (text4.equalsIgnoreCase(text2)) {
			System.out.println("Price match same");
		} else {
			System.out.println("Price doesn't match");
		}
		clickOnElement(sdp.getAddToCart().getAddtoCart());

		clickOnElement(sdp.getCartPage().getClickCart());

		clickOnElement(sdp.getProccedToBuy().getPToCart());

		TakesScreenshot t = (TakesScreenshot) driver;

		File s2 = t.getScreenshotAs(OutputType.FILE);

		File f1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\Amazon_Project_vj\\screenshots\\Proceedtopay.png");
		FileUtils.copyFile(s2, f1);

		windowClose();
		windowQuit();
	}

}
