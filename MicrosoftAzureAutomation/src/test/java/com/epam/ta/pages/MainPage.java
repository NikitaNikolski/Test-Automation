package com.epam.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://azure.microsoft.com/en-us/";

    @FindBy(xpath = "//div[@id='dropdown-cultures']/select[@class='wa-dropdown']")
    private WebElement cultureSelect;

    @FindBy(className = "wa-dropdown-currency")
    private WebElement currencySelect;

    @FindBy(xpath = "//option[@value='ru-ru']")
    private Webelement optionWithRussianValueOfCulture;

    @FindBy(xpath = "//option[@value='RUB']")
    private Webelement optionWithRussianValueOfCurrency;

    @FindBy(className = "home-show-all-services")
    private Webelement showAllProductsButton;

    @FindBy(className = "price-data")
    private Webelement currencyBlock;

    @FindBy(xpath = "//a[@title='Documentation']")
    private Webelement documentationLink;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Main page opened");
	}

	public void changeCulture(String culture)
	{
        cultureSelect.click();
        driver.findElement(By.cssSelector("#dropdown-cultures > select > option[value=" + culture + "]")).click();
		logger.info("Change culture performed");
	}

	public void changeCurrency(String currency)
	{
        currencySelect.click();
        driver.findElement(By.cssSelector("#dropdown-cultures > select > option[value=" + currency + "]")).click();
		logger.info("Change currency performed");
	}

	public String getCurrentCurrency()
	{
		return currencyBlock.getText();
	}

	public void showAllProducts()
	{
		showAllProductsButton.click();
		logger.info("Show all products performed");
	}

	public int getCountOfTheAllProducts()
	{
		Webelement allProducts = driver.findElements(By.cssSelector("//a[@data-event]='global-clicked-popularproduct'");

		return allProducts.size();
	}

	public void clickOnTheProduct(String productLink)
	{
        driver.findElement(By.cssSelector("a[href=" + productLink + "]")).click();
		logger.info("Click on the product performed");
	}

	public void loadDocumentationTab()
	{
		documentationLink.click();
	}
}
