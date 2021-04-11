package com.example.registration

import org.junit.Test

import org.junit.Assert.*

class ValidationTest {
    private  var email = "okezi002@gmail.com"
    private  var email2 = "okezigmail.com"
    private  var phone = "08102232012"
    private  var phone2 = "2348077650980"
    private  var name = "okezino"
    private  var name2 = "okezi09"
    private  var sex = "MALE"
    private  var sex1 = "Gender"
    private  var password = "123"
    private  var invalidConfirmPassword = "abc"
    private  var validConfirmPassword = "123"

    var validationInstance = Validation()

    @Test
    fun emailValidator() {

        assertTrue(validationInstance.emailValidator(email))
        assertFalse(validationInstance.emailValidator(email2))
    }

    @Test
    fun phoneNumberValidator() {
        assertTrue(validationInstance.phoneNumberValidator(phone))
        assertTrue(validationInstance.phoneNumberValidator(phone2))
    }

    @Test
    fun fullNameValidator() {
        assertTrue(validationInstance.fullNameValidator(name))
        assertFalse(validationInstance.fullNameValidator(name2))
    }

    @Test
    fun genderValidator() {
        assertTrue(validationInstance.genderValidator(sex))
        assertFalse(validationInstance.genderValidator(sex1))
    }

    @Test
    fun passwordValidation() {
        assertTrue(validationInstance.passwordValidation(password, validConfirmPassword))
        assertFalse(validationInstance.passwordValidation(password,invalidConfirmPassword))
    }
}