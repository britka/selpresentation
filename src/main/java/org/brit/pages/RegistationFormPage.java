package org.brit.pages;

import org.brit.model.ErrorMessagesModel;
import org.brit.model.FormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by brit on 2/6/17.
 */

/**
 * This is implementation of PageObject pattern for representation of
 * registration form.
 */
public class RegistationFormPage {

    // WebDriver for internal use.
    WebDriver driver;

    // ------------------------------------------------------
    // Representation of all fields and control elements of the form

    @FindBy(css = ".wpcf7-response-output.wpcf7-mail-sent-ok")
    private WebElement registrationSuccessMessage;

    @FindBy(css = ".wpcf7-form-control.wpcf7-submit")
    private WebElement submitLink;

    @FindBy(css = ".submit-wrap > input")
    private WebElement clearLink;

    @FindBy(id = "comment")
    private WebElement commentArea;

    @FindBy(css = "input[name='text-71']")
    private WebElement skypeField;

    @FindBy(css = "input[name='your-email']")
    private WebElement emailField;

    @FindBy(css = "input[name='text-297']")
    private WebElement phoneField;

    @FindBy(css = "input[name='text-68']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='your-name']")
    private WebElement lastNameField;

    @FindBy(css = "select[name='menu-11']")
    private WebElement selectCourse;

    //-----------------------------------------------------


    /**
     * Constructor. Uses {@link PageFactory}
     * @param webDriver
     */
    public RegistationFormPage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //-------------------------------------------------------------
    // Setters for different web elements

    public RegistationFormPage setCommentArea(String commentText) {
        setText(this.commentArea, commentText);
        return this;
    }

    public RegistationFormPage setSkypeField(String skypeFieldText) {
        setText(skypeField, skypeFieldText);
        return this;
    }

    public RegistationFormPage setEmailField(String emailFieldText) {
        setText(emailField, emailFieldText);
        return this;
    }

    public RegistationFormPage setPhoneField(String phoneFieldText) {
        setText(phoneField, phoneFieldText);
        return this;
    }

    public RegistationFormPage setFirstNameField(String firstNameFieldText) {
        setText(firstNameField, firstNameFieldText);
        return this;
    }

    public RegistationFormPage setLastNameField(String lastNameFieldText) {
        setText(lastNameField, lastNameFieldText);
        return this;
    }

    public RegistationFormPage setSelectCourse(String selectCourseText) {
        new Select(selectCourse).selectByValue(selectCourseText);
        return this;
    }
    //-------------------------------------------------------------


    //--------------------------------------------------------------
    // private method to unified setting text to text field

    /**
     * Set text to text field
     * @param element {@link WebElement} to set text to
     * @param text text value to set
     */
    private void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Method to fill all fields in form
     * @param formModel {@link FormModel} instance witch holds all data for form
     * @return {@link RegistationFormPage}  instance
     */
    public RegistationFormPage fillForm(FormModel formModel) {
        return setCommentArea(formModel.getComment())
                .setEmailField(formModel.getEmail())
                .setSkypeField(formModel.getSkype())
                .setFirstNameField(formModel.getFirstName())
                .setLastNameField(formModel.getLastName())
                .setPhoneField(formModel.getPhone())
                .setSelectCourse(formModel.getCourse());
    }

    /**
     * Submits the form and waits some time
     * @return {@link RegistationFormPage} instance
     */
    public RegistationFormPage submitForm() {
        submitLink.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new RegistationFormPage(driver);
    }

    /**
     * Clears all fields
     * @return {@link RegistationFormPage} instance
     */
    public RegistationFormPage clearForm() {
        clearLink.click();
        return new RegistationFormPage(driver);
    }

    /**
     * Private method to check if error present for proper {@link WebElement}
     * @param element  {@link WebElement} with error
     * @return true if error present and false otherwise
     */
    private boolean isErrorPresent(WebElement element) {
        By errorElement = By.xpath("./../span[@class='wpcf7-not-valid-tip-no-ajax']");
        return element.findElement(errorElement).isDisplayed();
    }

    /**
     * Checks all errors in the form
     * @param errorMessagesModel {@link ErrorMessagesModel} instance
     */
    public void isErrorMessagesDisplay(ErrorMessagesModel errorMessagesModel) {
        Assert.assertEquals(isErrorPresent(selectCourse), errorMessagesModel.isSelectCourseErrorPresent());
        Assert.assertEquals(isErrorPresent(firstNameField), errorMessagesModel.isFirstNameErrorPresent());
        Assert.assertEquals(isErrorPresent(lastNameField), errorMessagesModel.isLastNameErrorPresent());
        Assert.assertEquals(isErrorPresent(emailField), errorMessagesModel.isEmailErrorPresent());
        Assert.assertEquals(isErrorPresent(phoneField), errorMessagesModel.isPhoneErrorPresent());
        Assert.assertEquals(isErrorPresent(skypeField), errorMessagesModel.isSkypeErrorPresent());
    }

    /**
     * Checks if refistration is successful. Confirmation message should be visible
     * @return true if message is visible and false otherwise
     */
    public boolean isRegistrationSuccess(){
        return registrationSuccessMessage.isDisplayed();
    }

}
