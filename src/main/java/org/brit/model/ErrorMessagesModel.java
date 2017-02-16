package org.brit.model;

/**
 * Created by brit on 2/6/17.
 */

/**
 * Represents error messages.
 * By default all messages are not present
 */
public class ErrorMessagesModel {
    private boolean isSelectCourseErrorPresent = false;
    private boolean isLastNameErrorPresent = false;
    private boolean isFirstNameErrorPresent = false;
    private boolean isPhoneErrorPresent = false;
    private boolean isEmailErrorPresent = false;
    private boolean isSkypeErrorPresent = false;

    public ErrorMessagesModel() {
    }

    public boolean isSelectCourseErrorPresent() {
        return isSelectCourseErrorPresent;
    }

    public ErrorMessagesModel setSelectCourseErrorPresent(boolean selectCourseErrorPresent) {
        isSelectCourseErrorPresent = selectCourseErrorPresent;
        return this;
    }

    public boolean isLastNameErrorPresent() {
        return isLastNameErrorPresent;
    }

    public ErrorMessagesModel setLastNameErrorPresent(boolean lastNameErrorPresent) {
        isLastNameErrorPresent = lastNameErrorPresent;
        return this;
    }

    public boolean isFirstNameErrorPresent() {
        return isFirstNameErrorPresent;
    }

    public ErrorMessagesModel setFirstNameErrorPresent(boolean firstNameErrorPresent) {
        isFirstNameErrorPresent = firstNameErrorPresent;
        return this;
    }

    public boolean isPhoneErrorPresent() {
        return isPhoneErrorPresent;
    }

    public ErrorMessagesModel setPhoneErrorPresent(boolean phoneErrorPresent) {
        isPhoneErrorPresent = phoneErrorPresent;
        return this;
    }

    public boolean isEmailErrorPresent() {
        return isEmailErrorPresent;
    }

    public ErrorMessagesModel setEmailErrorPresent(boolean emailErrorPresent) {
        isEmailErrorPresent = emailErrorPresent;
        return this;
    }

    public boolean isSkypeErrorPresent() {
        return isSkypeErrorPresent;
    }

    public ErrorMessagesModel setSkypeErrorPresent(boolean skypeErrorPresent) {
        isSkypeErrorPresent = skypeErrorPresent;
        return this;
    }

    public ErrorMessagesModel setAllToTrue() {
        isSelectCourseErrorPresent = true;
        isLastNameErrorPresent = true;
        isFirstNameErrorPresent = true;
        isPhoneErrorPresent = true;
        isEmailErrorPresent = true;
        isSkypeErrorPresent = true;
        return this;
    }
}
