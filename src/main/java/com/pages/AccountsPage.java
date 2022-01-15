package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;

	//Locators
	private By accountSections = By.cssSelector("div#center_column span");
	
	//Constructor of Account page
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Page Actions
	public String getAccountpageTitle() {
		return driver.getTitle();
	}
	public int getAccountSectionCount() {
	return driver.findElements(accountSections).size()-1;
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountList= new ArrayList<>();
		List<WebElement> accountHeaderList=driver.findElements(accountSections);
		for (WebElement e: accountHeaderList) {
			String text=e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}
}
