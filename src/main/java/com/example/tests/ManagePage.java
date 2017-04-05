package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by radga on 05.04.2017.
 */
public class ManagePage extends PageObject{
    @FindBy(id="workWeekSize")
    private WebElement workWeekSize;

    @FindBy(id="workDayBeginAt")
    private WebElement workWeekBeginAt;

    @FindBy(id="workDayEndAt")
    private WebElement workDayEndAt;

    @FindBy(id="appointmentTime")
    private WebElement appointmenSize;

    @FindBy(className = "button.btn-success")
    private WebElement saveButton;

    @FindBy(name = "day_tab")
    private WebElement dayTabButton;

    @FindBy(name = "week_tab")
    private WebElement weekTabButton;

    @FindBy(name = "month_tab")
    private WebElement monthTabButton;

    @FindBy(id="dhx_minical_icon")
    private WebElement calendarMinimalIcon;

    @FindBy(className = "div.dhx_cal_date")
    private WebElement dateText;

    @FindBy(className = "dhx_cal_today_button")
    private WebElement todayButton;

    @FindBy(className = "dhx_cal_prev_button")
    private WebElement previousWeekButton;

    @FindBy(className = "dhx_cal_next_button")
    private WebElement nextWeekButton;

   @FindBy(className = "div.dhx_scale_holder ")
   private WebElement row;
    public ManagePage(WebDriver driver){
        super(driver);
    }



}
