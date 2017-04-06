package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by radga on 06.04.2017.
 */
public class AddNewDoctorPage extends PageObject {

    @FindBy(className = "h1.text-center")
    private WebElement headerTextLabel;

    @FindBy(id = "firstName")
    private WebElement firstNameTextField;

    @FindBy(id = "lastName")
    private WebElement lastNameTextField;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[1]/div[2]/div/figure/a")
    private WebElement imageHolder;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[2]/div[1]/div[1]")
    private WebElement specializationLabel;

    @FindBy(id = "specialization")
    private WebElement specializtionSelector;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[2]/div[1]/div[2]")
    private WebElement categoryLabel;

    @FindBy(id="category")
    private WebElement categorySelector;

    @FindBy(id = "education")
    private WebElement educationTextField;

    @FindBy(id="address")
    private WebElement addressTextField;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[4]/div[1]/div[1]")
    private WebElement hospitalNameLabel;

    @FindBy(id = "hospital")
    private WebElement hospitalSelector;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[4]/div[1]/div[2]")
    private WebElement departmentNameLabel;

    @FindBy(id="departmen")
    private WebElement departmentSelector;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[5]/div[1]/div")
    private WebElement genderLabel;

    @FindBy(css = "input[value=\"MALE\"]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[5]/div[2]/div/label")
    private WebElement maleRadioButtonLabel;

    @FindBy(css = "input[value=\"FEMALE\"]")
    private WebElement femaleRadioButton;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[5]/div[3]/div/label")
    private WebElement femaleRadioButtonLabel;

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[7]/div[1]/div")
    private WebElement dayOfBirthLabel;

    @FindBy(id = "datepicker")
    private WebElement dadePicker;
    //Ask about calendr

    @FindBy(xpath = "//*[@id=\"registerNewUser\"]/div[7]/div[3]/div")
    private WebElement phoneLabel;

    @FindBy(id="phone")
    private WebElement phoneInput;

    @FindBy(id="newUserSubmit")
    private WebElement newUserSubmit;

    @FindBy(id="cancel")
    private WebElement cancleButton;

    @FindBy(xpath = "/html/body/section/a")
    private WebElement backToTopButton;



    public AddNewDoctorPage(WebDriver driver){
        super(driver);
    }
}
