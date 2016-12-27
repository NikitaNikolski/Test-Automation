package com.epam.ta.steps;

import java.util.concurrent.TimeUnit;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.ta.pages.MainPage;
import com.epam.ta.pages.ProductDetailsPage;
import com.epam.ta.pages.DocumentationPage;
import org.openqa.selenium.support.FindBy;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void changeLanguage(String languageValue)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.changeCulture(languageValue);
	}

	public void changeCurrency(String currencyValue)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.changeCurrency(currencyValue);
	}

	public void showAllProducts()
	{
		MainPage mainPage = new MainPage(driver);

		mainPage.showAllProducts();
	}

	public void showdetailsPageOfTheProduct(String productLink)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.showAllProducts();
		mainPage.clickOnTheProduct(productLink);
	}

	public String getCurrentCurrency()
	{
		MainPage mainPage = new MainPage(driver);

		return mainPage.getCurrentCurrency();
	}

	public void loadDocumentationPage()
	{
		MainPage mainPage = new MainPage(driver);

		mainPage.loadDocumantationTab();
	}

	public void useDocumentationFilter(String filterOption)
	{
		DocumentationPage documentationPage = new DocumentationPage(driver);

		documentationPage.clickOnFilterItem(filterOption);
	}

	public void isLanguageChanged(String urlWithSelectedLanguage)
	{
		return driver.getCurrentUrl().equals(urlWithSelectedLanguage);
	}

	public void isCurrencyChanged(String currency)
	{
		String newCurrency = getCurrentCurrency();

		return newCurrency.equals(currency);
	}

	public boolean isAllProductsShownUp(int countOfTheProducts)
	{
		MainPage mainPage = new MainPage(driver);

		return mainPage.getCountOfTheAllProducts() == countOfTheProducts;
	}

	public boolean isShowdetailsPageOfTheProductLoaded(String title)
	{
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

		return productDetailsPage.isPageLoaded(title);
	}

	public boolean isDocumentationPageLoaded()
	{
		DocumentationPage documentationPage = new DocumentationPage(driver);

		return documentationPage.isDocumentationPageLoaded();
	}

	public boolean isFilterApplied(String cardText)
	{
		DocumentationPage documentationPage = new DocumentationPage(driver);

		return documentationPage.checkIsCardExist(cardText);
	}
}
