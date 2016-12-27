package com.epam.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends AbstractPage
{
    private final String BASE_URL = "https://azure.microsoft.com/en-us/";

    @FindBy(xpath = "//h1")
    private WebElement headerTitle;

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isPageLoaded(String title)
    {
        return headerTitle.getText().equals(title);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
