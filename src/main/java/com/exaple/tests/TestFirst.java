package com.exaple.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFirst {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    public TestFirst() {
    }

    @BeforeClass(
            alwaysRun = true
    )
    public void setUp() throws Exception {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffProfile = profile.getProfile("QAAutomation");
        ffProfile.setAcceptUntrustedCertificates(true);
        ffProfile.setAssumeUntrustedCertificateIssuer(false);
        System.setProperty("webdriver.gecko.driver", "C:\\\\drivers\\geckodriver.exe");
        this.driver = new FirefoxDriver(ffProfile);
        this.baseUrl = "https://localhost:8443/HospitalSeeker/";
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.driver.get(this.baseUrl);
        this.wait = new WebDriverWait(this.driver, 10L);
    }

    @Test
    public void testEventCreation() throws Exception {
        Utilits.login(this.driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(this.driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));
        System.out.println(this.driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());
        Utilits.doubleClickJS(By.cssSelector("div.dhx_scale_holder "), this.driver);
        this.driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).clear();
        this.driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).sendKeys(new CharSequence[]{"Test"});
        this.driver.findElement(By.cssSelector("div.dhx_menu_icon.icon_save")).click();
        this.driver.findElement(By.cssSelector("button.btn-success")).click();
        Utilits.logout(this.driver);
        Utilits.login(this.driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(this.driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));
        System.out.println(this.driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());
        Assert.assertEquals(this.driver.findElement(By.cssSelector("div.dhx_body")).getText(), "Test");
        Utilits.logout(this.driver);
        this.deleteFromSceduler();
    }

    public void deleteFromSceduler() {
        Utilits.login(this.driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(this.driver);
        this.driver.findElement(By.cssSelector("div.dhx_event_resize.dhx_footer")).click();
        this.driver.findElement(By.cssSelector("div.dhx_menu_icon.icon_delete")).click();
        this.driver.findElement(By.cssSelector("div.dhtmlx_popup_button.dhtmlx_ok_button > div")).click();
        this.driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        Utilits.logout(this.driver);
        Utilits.login(this.driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(this.driver);
        Assert.assertEquals(this.driver.findElement(By.cssSelector("div.dhx_body")).getText(), "");
    }

    @Test
    public void testLikeUser() throws Exception {
        Utilits.login(this.driver, "doctor.jw@hospitals.ua", "1111");
        this.driver.findElement(By.linkText("Робочий графік")).click();
        Assert.assertEquals(this.driver.findElement(By.cssSelector("div.dhx_scale_holder")).getText(), "Test");
    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDown() throws Exception {
        this.driver.quit();
    }
}