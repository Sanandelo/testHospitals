package com.example.tests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

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
        driver = new FirefoxDriver(ffProfile);
        baseUrl = "https://localhost:8443/HospitalSeeker/";
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 20L);
    }

   @Test
    public void testEventCreation() throws Exception {
        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(driver);
        Thread.sleep(5000);

        Utilits.choseNextWeek(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());

        Utilits.doubleClickJS(By.cssSelector("div.dhx_scale_holder"), driver);
        driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).clear();
        driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).sendKeys("Test");
        driver.findElement(By.cssSelector("div.dhx_menu_icon.icon_save")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();

        Utilits.logoutManager(driver);

        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");

        Utilits.choseDoctor(driver);
        Thread.sleep(5000);

        Utilits.choseNextWeek(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());

        Assert.assertEquals(driver.findElement(By.cssSelector("div.dhx_body")).getText(), "Test");
        Utilits.logoutManager(driver);
    }
    @Test
    public void testEventCreation1() throws Exception {
        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(driver);
        Thread.sleep(5000);
        Utilits.choseNextWeek(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());

        Utilits.doubleClickJS(By.cssSelector("div.dhx_scale_holder"), driver);
        driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).clear();
        driver.findElement(By.cssSelector("textarea.dhx_cal_editor")).sendKeys("Test");
        driver.findElement(By.cssSelector("div.dhx_menu_icon.icon_save")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();

        Utilits.logoutManager(driver);

        Utilits.login(driver, "doctor.jw@hospitals.ua", "1111");
        driver.findElement(By.linkText("Робочий графік")).click();
        Thread.sleep(5000);

        Utilits.choseNextWeek(driver);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"scheduler_here\"]/div[1]/div[4]")).getText());

        Assert.assertEquals(driver.findElement(By.cssSelector("div.dhx_scale_holder")).getText(), "Test");
        Utilits.logoutDoctor(driver);
    }

    @Test(dataProvider = "DayOfWeeks")
    public void testDaysOfWeekLikeManager(String day, int number) throws Exception {
        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(driver);

        new Select(driver.findElement(By.id("workWeekSize"))).selectByVisibleText(day);
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        Utilits.logoutManager(driver);

        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(driver);

        Assert.assertEquals(driver.findElements(By.cssSelector("div.dhx_scale_holder")).size(),number);
        Utilits.logoutManager(driver);
    }
    @Test//(dataProvider = "DayOfWeeks")
    //String day, int number
    public void testDaysOfWeekLikeDoctor() throws Exception {
        Utilits.login(driver, "manager.jh@hospitals.ua", "1111");
        Utilits.choseDoctor(driver);

        Thread.sleep(5000);

        new Select(driver.findElement(By.id("workWeekSize"))).selectByVisibleText("7 днів");
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        Utilits.logoutManager(driver);

        Thread.sleep( 5000);

        Utilits.login(driver, "doctor.jw@hospitals.ua", "1111");
        driver.findElement(By.linkText("Робочий графік")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_scale_holder")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dhx_scale_holder")));

        //System.out.println(driver.findElements(By.cssSelector("div.dhx_scale_holder")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("div.dhx_scale_holder")).size(),7);
        Thread.sleep(3000);
        Utilits.logoutDoctor(driver);
    }



    @DataProvider(name ="DayOfWeeks")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"7 днів", 7},
                {"6 днів", 6},
                {"5 днів", 5}

        };
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}