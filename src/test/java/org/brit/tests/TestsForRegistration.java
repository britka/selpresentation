package org.brit.tests;

import org.brit.driver.DriverFactory;
import org.brit.driver.WebDriverType;
import org.brit.model.ErrorMessagesModel;
import org.brit.model.FormModel;
import org.brit.pages.RegistationFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by brit on 2/6/17.
 */
public class TestsForRegistration {
    final String BASE_URL = "http://old.qalight.com/zapisatsya-na-kurs/";
    WebDriver driver = null;
    RegistationFormPage registationFormPage;


    @BeforeClass
    public void beforeClassMethod() {
        driver = DriverFactory.initDriver(WebDriverType.CHROME);
        driver.get(BASE_URL);
        registationFormPage = new RegistationFormPage(driver);
    }

    @Test
    public void registrationSuccessfulTest(){
        FormModel formModel = new FormModel();
        registationFormPage.fillForm(formModel).submitForm().isErrorMessagesDisplay(new ErrorMessagesModel().setAllToTrue());
    }

    @AfterClass
    public void afterClassMethod(){
        if (driver != null){
            driver.quit();
        }
    }


}
