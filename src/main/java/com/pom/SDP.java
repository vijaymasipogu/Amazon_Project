package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SDP {

	public static WebDriver driver;
	private HomePage hp;
	private ProductPage pp;
	private AddToCartPage ad;
	private CartPage cp;
	private ProceedToBuyPage pb;

	public SDP(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public HomePage getHomePage() {
		if (hp == null) {
			hp = new HomePage(driver);

		}
		return hp;
	}

	public ProductPage getProducPage() {
		if (pp == null) {
			pp = new ProductPage(driver);
		}
		return pp;
	}

	public AddToCartPage getAddToCart() {
		if (ad == null) {
			ad = new AddToCartPage(driver);
		}
		return ad;
	}

	public CartPage getCartPage() {
		if (cp == null) {
			cp = new CartPage(driver);
		}
		return cp;
	}

	public ProceedToBuyPage getProccedToBuy() {
		if (pb == null) {
			pb = new ProceedToBuyPage(driver);
		}
		return pb;
	}

}
