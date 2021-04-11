package com.example.registration

class Validation() {

    /**
     * Using Regex to check and confirm the email format for @ and period sign (.)
     */

    fun emailValidator(email: String) : Boolean{

        val regex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return email.matches(regex)
    }

    /**
     * Validating phone number to Nigeria phone number format
     */

    fun phoneNumberValidator(phone: String) : Boolean {

        return if((phone.take(3) == "070" ||
                  phone.take(3) == "080" ||
                  phone.take(3) == "090" ||
                  phone.take(3) == "081" )&&
                  phone.length == 11) true

            else  (phone.take(5) == "23470" ||
                   phone.take(5) == "23480"||
                   phone.take(5) == "23490"||
                   phone.take(5) == "23481" )
                && phone.length == 13
        return true
    }

    /**
     * Validation to confirm numbers on the name
     */


    fun fullNameValidator(fullName: String) : Boolean {
        var valid = true
        if(fullName.isEmpty()) valid = false
        for(i in fullName) if (i.isDigit()) valid = false
        return valid
    }

    /**
     * Validation to confirm a Gender was chosen
     */

    fun genderValidator(gender: String) : Boolean {
        return gender == "MALE" || gender == "FEMALE" || gender == "LGBT"
    }

    /**
     * Validation to confirm both password and confirm password is same
     */

    fun passwordValidation(password: String, confirmPassword : String) : Boolean{
        return  password == confirmPassword
    }

}