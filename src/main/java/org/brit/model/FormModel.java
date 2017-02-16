package org.brit.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by brit on 2/6/17.
 */

/**
 * Holds all data for form elements
 */
public class FormModel {
    //Default values
    String course = "";
    String firstName = "";
    String lastName = "";
    String phone = "";
    String email = "";
    String skype = "";
    String comment = "";
    //---------------------

    public FormModel(String course, String firstName, String lastName, String phone, String email, String skype, String comment) {
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.comment = comment;
    }

    public FormModel() {
    }

    public String getCourse() {
        return course;
    }

    public FormModel setCourse(String course) {
        this.course = course;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public FormModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public FormModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public FormModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FormModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSkype() {
        return skype;
    }

    public FormModel setSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public FormModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("course", course)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("phone", phone)
                .append("email", email)
                .append("skype", skype)
                .append("comment", comment)
                .toString();
    }
}

