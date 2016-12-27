package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class MicrosoftAzureAutomationTest
{
	private Steps steps;
	private final String LANGUAGE_VALUE = "ru-ru";
	private final String CURRENCY_VALUE = "RUB";
	private final String MAIN_PAGE_WITH_RUSSIAN_LANGUAGE = "https://azure.microsoft.com/ru-ru/";
	private final int COUNT_OF_ALL_THE_PRODUCTS = 67;
	private final String PRODUCT_LINK_FOR_GETTING_DETAILS = "/en-us/services/virtual-machines/";
	private final String VIRTUALS_MACHINES_HEADER_TITLE = "Virtual Machines";
	private final String FILTER_ITEM_FOR_DOCUMENTATION_PAGE = "Intelligence + Analytics";
	private final String CARD_TEXT_FOR_CHECKING_IS_FILTER_APPLIED = "Machine Learning";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Change application language")
	public void changeApplicationLanguage()
	{
		steps.changeLanguage(LANGUAGE_VALUE);
		Assert.assertTrue(steps.isLanguageChanged(MAIN_PAGE_WITH_RUSSIAN_LANGUAGE));
	}

	@Test(description = "Change application currency")
	public void changeApplicationCurrency()
	{
		String currency = steps.getCurrentCurrency();
		steps.changeCurrency(CURRENCY_VALUE);
		Assert.assertFalse(steps.isCurrencyChanged(currency));
	}

	@Test(description = "Show all the products")
	public void showAllTheProducts()
	{
		steps.showAllProducts();
		Assert.assertTrue(steps.isAllProductsShownUp(COUNT_OF_ALL_THE_PRODUCTS));
	}

	@Test(description = "Show details page of the product")
	public void showDetailsPageOfTheProduct()
	{
		steps.showDetailsPageOfTheProduct(PRODUCT_LINK_FOR_GETTING_DETAILS);
		Assert.assertTrue(steps.isShowdetailsPageOfTheProductLoaded(VIRTUALS_MACHINES_HEADER_TITLE));
	}

	@Test(description = "Load documentation page")
	public void loadDocumentationPage()
	{
		steps.loadDocumentationPage();
		Assert.assertTrue(steps.isDocumentationPageLoaded());
	}

	@Test(description = "Use filter on documentaion page")
	public void useDocumentaionFilter()
	{
		steps.useDocumentationFilter(FILTER_ITEM_FOR_DOCUMENTATION_PAGE);
		Assert.assertTrue(steps.isFilterApplied(CARD_TEXT_FOR_CHECKING_IS_FILTER_APPLIED));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
