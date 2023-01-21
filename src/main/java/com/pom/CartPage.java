package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public static WebDriver driver;
//	WebElement clickCart = driver.findElement(By.id("nav-cart-count"));
	
	@FindBy(id ="nav-cart-count")
	private WebElement clickCart;
	
	public CartPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getClickCart() {
		return clickCart;
	}

}
