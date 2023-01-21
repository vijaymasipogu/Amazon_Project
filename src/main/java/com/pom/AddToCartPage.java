package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	public static WebDriver driver;
//	WebElement clickableLink = driver
//			.findElement(By.xpath("//div[@id='centerCol']//child::div[@id='title_feature_div']"));
	
//	WebElement clickablePdtPrice = driver.findElement(By.xpath(
//			"//div[@id='centerCol']//child::div[@id='title_feature_div']/following::div/following::div[@id='corePriceDisplay_desktop_feature_div']/child::div/span/span[@class='a-offscreen']"));

//	WebElement addtoCart = driver.findElement(By.id("add-to-cart-button"));

	@FindBy(xpath ="//div[@id='centerCol']//child::div[@id='title_feature_div']")
	private WebElement clickableLink;
	
	@FindBy(xpath = "//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]")
	private WebElement clickablePdtPrice;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addtoCart;
	
	public AddToCartPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getClickableLink() {
		return clickableLink;
	}
	
	public WebElement getClickablePdtPrice() {
		return clickablePdtPrice;
	}
	public WebElement getAddtoCart() {
		return addtoCart;
	}
	
	
}
