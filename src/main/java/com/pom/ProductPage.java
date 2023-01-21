package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public static WebDriver driver;

//	WebElement firstPdtTitle = driver.findElement(
//			By.xpath("//span[text()='RESULTS']//following::div[@class='sg-col-inner'][1]//descendant::h2//a"));

//	WebElement firstPdtPrice = driver.findElement(By.xpath(
//			"//div[@class='s-no-outline']/following::div/following::div/h2/following::span[1][@class='a-price']"));

	@FindBy(xpath = "//span[text()='RESULTS']//following::div[@class='sg-col-inner'][1]//descendant::h2//a")
	private WebElement firstPdtTitle;

	@FindBy(xpath = "//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']")
	private WebElement firstPdtPrice;

	public ProductPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstPdtTitle() {
		return firstPdtTitle;
	}

	public WebElement getFirstPdtPrice() {
		return firstPdtPrice;
	}

}
