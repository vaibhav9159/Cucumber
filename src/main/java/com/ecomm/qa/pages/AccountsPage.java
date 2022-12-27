package com.ecomm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections= By.cssSelector("#center_column span");
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public int getAccountSectionsCount()
	{
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionsList()
	{
		List<String> accountsList = new	<String> ArrayList();
		List<WebElement> accountSectionList = driver.findElements(accountSections);
		for(WebElement e:accountSectionList)
		{
			String text = e.getText();
			accountsList.add(text);
		}
		return accountsList;
	}
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	
}
