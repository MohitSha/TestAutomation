package com.cleartrip.qa.pages;

import com.cleartrip.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HotelBookingPage extends TestBase {
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(id = "ResultContainer_1_1")
    private WebElement resultContainer;

    @FindBy(xpath = "//nav[@class='hotelsList']/ul/li")
    private List<WebElement> resultList;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li[2]/a")
    private WebElement firstElementsOfTheSugeestedList;

    public HotelBookingPage() {
        PageFactory.initElements(driver, this);
    }

    public int searchForHotels() throws InterruptedException {
        int resultCount = 0;
        hotelLink.click();
        localityTextBox.sendKeys("Indiranagar, Bangalore");

        firstElementsOfTheSugeestedList.click();
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();
        if (resultContainer.isDisplayed()) {
            resultCount = resultList.size();
        }

        return resultCount;
    }
}
