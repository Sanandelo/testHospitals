package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ManagePage extends PageObject{
    @FindBy(className = "h1.text-center")
    private WebElement hospitalName;

    //maybe no work
    @FindBy(className = "label[for=\"doctorPerPage\"]")
    private WebElement showDoctorsLabel;

    @FindBy(id = "doctorPerPage")
    private WebElement doctorPerPageSelector;

    @FindBy(className = "label[for=\"pref-specializationBy\"]")
    private WebElement specializationLabel;

    @FindBy(id = "pref-specializationBy")
    private WebElement SpecializationSelector;

    @FindBy(className = "label[for=\"searchBy\"]")
    private WebElement searchByLabel;

    @FindBy(id = "searchBy")
    private WebElement searchBySelector;

    @FindBy(id = "search")
    private WebElement searchTextFild;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "clearButton")
    private WebElement clearButton;


    //change to page refernce
    @FindBy(css = "a[href=\"/HospitalSeeker/manager/manageDepartments/2\"]")
    private WebElement labaratoryButton;
    //too
    @FindBy(css = "a[href=\"/HospitalSeeker/manager/manageDepartments/2\"]")
    private WebElement departmentButton;
    //too
    @FindBy(className = "a[href=\"/HospitalSeeker/newDoctor\"]")
    private WebElement newDoctorButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[1]")
    private WebElement hashLabel;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[2]/i")
    private WebElement emailLabel;


    //Header row in table

    @FindBy(id = "email")
    private WebElement sortByEmailButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[4]/i")
    private WebElement nameLabel;

    @FindBy(id="firstName")
    private WebElement sortByFistNameButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[4]/i")
    private WebElement surname;

    @FindBy(id="lastName")
    private WebElement sortBySurnameButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[5]/i")
    private WebElement specializtionLabel;

    @FindBy(id="specialization")
    private WebElement sortBySpecializationButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[6]/i")
    private WebElement categoryLabel;

    @FindBy(id="category")
    private WebElement getSortByCategoryButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/thead/tr/th[7]/i")
    private WebElement actionLabel;

    //Rows

    //First row
    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[1]")
    private WebElement firstRowNumber;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[2]")
    private WebElement firstRowEmail;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[3]")
    private WebElement firstRowName;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[4]")
    private WebElement firstRowSurname;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[5]")
    private WebElement firstRowSpecialization;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[1]/td[6]")
    private WebElement firstRowCategory;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]/span[1]/a")
    private WebElement firstRowShowDoctorsDetailButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]/span[2]/a")
    private WebElement firstRowEditDoctorsDetailButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]/span[3]/a")
    private WebElement firstRowShowSchedulerButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]/span[4]/a")
    private WebElement firstRowDeleteDoctorButton;

    //Second Row

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[1]")
    private WebElement secondRowNumber;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[2]")
    private WebElement secondRowEmail;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[3]")
    private WebElement secondRowName;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[4]")
    private WebElement secondRowSurname;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[5]")
    private WebElement secondRowSpecialization;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[6]")
    private WebElement secondRowCategory;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[7]/span[1]/a")
    private WebElement secondRowShowDoctorsDetailButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[7]/span[2]/a")
    private WebElement secondRowEditDoctorsDetailButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[7]/span[3]/a")
    private WebElement secondRowShowSchedulerButton;

    @FindBy(xpath = "//*[@id=\"allDoctors\"]/tbody/tr[2]/td[7]/span[4]/a")
    private WebElement secondRowDeleteDoctorButton;

    @FindBy(xpath = "//html/body/section/a[2]")
    private WebElement backToTopButton;

    //Popups??

    public ManagePage(WebDriver driver) {
        super(driver);
    }



}
