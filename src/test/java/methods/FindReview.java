package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.WaitClass;

import java.util.List;

public class FindReview {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#js-header-nav > ul > li:nth-child(3) > a")
    private WebElement reviewsTabInput;

    @FindBy(css = "#top-nav__reviews > li:nth-child(1) > a")
    private WebElement carReviewsTabInput;

    @FindBy(css = "form > div:nth-child(1) > select")
    private WebElement makeInput;

    @FindBy(css = "form > div:nth-child(2) > select")
    private WebElement modelInput;

    @FindBy(css = "div.content__search-bar > div > form > button")
    private WebElement searchButtonInput;

    @FindBy(css = "section.content-page__main.cf > article > span.review-page--review-all-text.cf > h2 > a")
    private WebElement reviewInput;

    private void toReviewSearch(WebDriver wD, Actions action) {
        wait.waitToLoad(wD, reviewsTabInput);
        action.moveToElement(reviewsTabInput);
        wait.waitToLoad(wD, carReviewsTabInput);
        carReviewsTabInput.submit();        //test fails here TODO: diagnose and fix issue
    }

    private void chooseMakeModel(WebDriver wD, String make, String model) {
        wait.waitToLoad(wD, makeInput);
        Select selectMake = new Select(makeInput);
        String MAKE = make.toUpperCase();
        selectMake.selectByValue(MAKE);

        wait.waitToLoad(wD, modelInput);
        Select selectModel = new Select(modelInput);
        String MODEL = model.toUpperCase();
        selectModel.selectByValue(MODEL);
    }

    private void searchReview(WebDriver wD) {
        wait.waitToLoad(wD, searchButtonInput);
        searchButtonInput.click();
    }

    private void accessReview(WebDriver wD) {
        wait.waitToLoad(wD, reviewInput);
        reviewInput.click();

    }

    public void findReview(WebDriver wD, Actions action, List<String> row) {
        toReviewSearch(wD, action);
        chooseMakeModel(wD, row.get(2), row.get(3));
        searchReview(wD);
        accessReview(wD);
    }
}
