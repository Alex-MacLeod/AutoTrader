package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.WaitClass;

import java.util.List;

public class FillSearchNewUsed {

    private WaitClass wait = new WaitClass();

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(css = "#searchVehicles > div > h1")
    private WebElement nothing;

    @FindBy(id = "radius")
    private WebElement distanceInput;

    @FindBy(id = "oneSearchAdUsed")
    private WebElement showUsedInput;

    @FindBy(id = "oneSearchAdNearlyNew")
    private WebElement showNearlyNewInput;

    @FindBy(id = "oneSearchAdBrandNew")
    private WebElement showNewInput;

    @FindBy(id = "searchVehiclesMake")
    private WebElement makeInput;

    @FindBy(id = "searchVehiclesModel")
    private WebElement modelInput;

    @FindBy(id = "searchVehiclesPriceFrom")
    private WebElement minPriceInput;

    @FindBy(id = "searchVehiclesPriceTo")
    private WebElement maxPriceInput;

    @FindBy(id = "search")
    private WebElement searchbuttonInput;

    private void enterPostCode(WebDriver wD, String postCode) {
        wait.waitToLoad(wD, postCodeInput);
        postCodeInput.sendKeys(postCode);
        nothing.click();
    }

    private void chooseDistance(WebDriver wD, String distance) {
        wait.waitToLoad(wD, distanceInput);
        Select selectDistance = new Select(distanceInput);
        if ("30".equals(distance)) {
            selectDistance.selectByValue(distance);
        } else {
            selectDistance.selectByValue("1501");
        }
    }

    private void chooseShowUsedInput (WebDriver wD, String showUsed) {
        wait.waitToLoad(wD, showUsedInput);
        if ("N".equals(showUsed)) {
            showUsedInput.click();
        }
    }

    private void chooseShowNearlyNewInput (WebDriver wD, String showNearlyNew) {
        wait.waitToLoad(wD, showNearlyNewInput);
        if ("N".equals(showNearlyNew)) {
            showNearlyNewInput.click();
        }
    }

    private void chooseShowNewInput (WebDriver wD, String showNew) {
        wait.waitToLoad(wD, showNewInput);
        if ("N".equals(showNew)) {
            showNewInput.click();
        }
    }

    private void chooseMake(WebDriver wD, String make) {
        wait.waitToLoad(wD, makeInput);
        Select selectMake = new Select(makeInput);
        String MAKE = make.toUpperCase();
        selectMake.selectByValue(MAKE);
    }

    private void chooseModel(WebDriver wD, String model) {
        wait.waitToLoad(wD, modelInput);
        Select selectModel = new Select(modelInput);
        String MODEL = model.toUpperCase();
        selectModel.selectByValue(MODEL);
    }

    private void chooseMinPrice(WebDriver wD, String minPrice) {
        wait.waitToLoad(wD, minPriceInput);
        Select selectMinPrice = new Select(minPriceInput);
        selectMinPrice.selectByValue(minPrice);
    }

    private void chooseMaxPrice(WebDriver wD, String maxPrice) {
        wait.waitToLoad(wD, maxPriceInput);
        Select selectMaxPrice = new Select(maxPriceInput);
        selectMaxPrice.selectByValue(maxPrice);
    }

    private void searchNewUsed(WebDriver wD) {
        wait.waitToLoad(wD, searchbuttonInput);
        searchbuttonInput.click();
    }

    public void searchNewUsed(WebDriver wD, List<String> row) {
        enterPostCode(wD, row.get(2));
        wait.pause(100);
        chooseDistance(wD, "30");   //see Test for why this is a String
        chooseShowUsedInput(wD, row.get(4));
        chooseShowNearlyNewInput(wD, row.get(5));
        chooseShowNewInput(wD, row.get(6));
        chooseMake(wD, row.get(7));
        wait.pause(100);
        chooseModel(wD, row.get(8));
        wait.pause(100);
        chooseMinPrice(wD, "11000");    //see Test for why this is a String
        wait.pause(100);
        chooseMaxPrice(wD, "30000");    //see Test for why this is a String
        wait.pause(500);
        searchNewUsed(wD);
    }
}
