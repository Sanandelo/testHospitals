package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by radga on 06.04.2017.
 */
public class ModerationFeedBackPage extends PageObject{
    @FindBy(css = "input[value=\"remove\"]")
    private WebDriver removeAfterDecideButton;

    @FindBy(css = "input[value=\"NEW\"]")
    private WebDriver newButton;

    @FindBy(css = "input[value=\"OK\"]")
    private WebDriver okButton;

    @FindBy(css = "input[value=\"BAD\"]")
    private WebDriver badButton;

    @FindBy(id = "searchButton")
    private WebDriver searchButton;

    //Feedback 1

    @FindBy(xpath = "//*[@id=\"2\"]/div[1]/span")
    private WebDriver patientOneName;

    @FindBy(xpath = "//*[@id=\"2\"]/div[1]/div/span")
    private WebDriver patienOneDateOfCreation;

    @FindBy(xpath = "//*[@id=\"2\"]/div[2]")
    private WebDriver patientOneFeedbackBody;

    @FindBy(xpath = "//*[@id=\"2\"]/div[3]/div/label[1]")
    private WebDriver patientOneOkButton;

    @FindBy(xpath = "//*[@id=\"2\"]/div[3]/div/label[2]")
    private WebDriver patientOneBlockButton;

    @FindBy(xpath = "//*[@id=\"2\"]/div[3]/span")
    private WebDriver patientOneDoctorName;

    //Feedback 2

    @FindBy(xpath = "//*[@id=\"5\"]/div[1]/span")
    private WebDriver patientTwoName;

    @FindBy(xpath = "//*[@id=\"5\"]/div[1]/div/span")
    private WebDriver patienTwoDateOfCreation;

    @FindBy(xpath = "//*[@id=\"5\"]/div[2]")
    private WebDriver patientTwoFeedbackBody;

    @FindBy(xpath = "//*[@id=\"5\"]/div[3]/div/label[1]")
    private WebDriver patientTwoOkButton;

    @FindBy(xpath = "//*[@id=\"5\"]/div[3]/div/label[2]")
    private WebDriver patientTwoBlockButton;

    @FindBy(xpath = "//*[@id=\"5\"]/div[3]/span")
    private WebDriver patientTwoDoctorName;


    @FindBy(xpath = "/html/body/section/a")
    private WebElement backToTopButton;

    public ModerationFeedBackPage(WebDriver driver){
        super(driver);
    }
}
