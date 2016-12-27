package com.epam.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DocumentationPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://azure.microsoft.com/en-us/";

	@FindBy(xpath = "//[@class='pivotTabs']//li[@class='selected']//a and text()='Services'")
    private List<WebElement> servicesTab;

    @FindBy(xpath = "//[@class='pivotTabs']//li[@class='selected']//a and text()='SDKs/Tools'")
    private List<WebElement> SDKsAndToolsTab;

    @FindBy(xpath = "//[@class='pivotTabs']//li[@class='selected']//a and text()='Architecture'")
    private List<WebElement> architectureTab;

    @FindBy(xpath = "//ul[@id='services']")
    private WebElement services;

	public DocumentationPage(WebDriver driver)
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

	public boolean isDocumentationPageLoaded()
	{
        return servicesTab.size() != 0
        	&& SDKsAndToolsTab.size() != 0
        	&& architectureTab.size() != 0;
	}

	public void clickOnFilterItem(String filterOption)
	{
		WebElement selectedOption = services.findElement(By.xpath("/li[@class='panelItem'] and text()=" + filterOption + "]"));
		selectedOption.click();
	}

	public boolean checkIsCardExist(String cardText)
	{
		return services.findElements(By.xpath("/li//div[@class='card']//div[@class='cardText']/h3 and text()=" + cardText + "]")).size() != 0;
	}
}
