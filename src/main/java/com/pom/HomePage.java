package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
//	WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
//	WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
//	List<WebElement> relevant = driver
//			.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div/div"));

	@FindBy(id = "searchDropdownBox")
	private WebElement dropdown;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(xpath ="//div[@id='nav-flyout-searchAjax']/child::div[2]/child::div/div")
	private List<WebElement> relevant;
	
	public HomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	public WebElement getSearchbox() {
		return searchbox;
	}
	
	public List<WebElement> getRelevant() {
		return relevant;
	}

}
