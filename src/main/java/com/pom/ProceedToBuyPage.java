package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToBuyPage {
	public static WebDriver driver;
//	WebElement pToCart = driver.findElement(By.name("proceedToRetailCheckout"));
	
	@FindBy(name ="proceedToRetailCheckout")
	private WebElement pToCart;
	
	public ProceedToBuyPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getPToCart() {
		return pToCart;
	}

}
