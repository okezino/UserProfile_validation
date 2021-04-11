package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

        var gender : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Decleration of spinner and Spinner List
         */

        var mySpinner : Spinner = sex
//        var spinnerList = arrayListOf("GENDER","FEMALE","MALE","LGBT")
        var spinnerList = resources.getStringArray(R.array.Sex)

        /**
         * initialization of Spinner Adapter and Spinner onItemselected Listener Object
         */

        mySpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinnerList)
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                gender = spinnerList.get(p2)


            }
        }

        /**
         * Registration Button call for the  registration function
         */

        registrationButton.setOnClickListener {
            registrationButton()
        }


    }

    /**
     * Registration function
     *   it takes up all input field and set them to a variable
     *   Calls Instance of the Validation Class
     *   Verify all Input Variable and send an error Message or Call the Database Activity if all Case is passed
     *
     */


    fun registrationButton(){

         var nameField = firstName.text.toString()
         var emailField  = email.text.toString()
         var phoneNumberField = phoneNumber.text.toString()
         var password = passWord.text.toString()
         var confirmedPassword = confirmPassword.text.toString()



         var validation = Validation()

         var emailCheck =  validation.emailValidator(emailField)
         var nameCheck = validation.fullNameValidator(nameField)
         var phoneCheck = validation.phoneNumberValidator(phoneNumberField)
         var genderCheck = validation.genderValidator(gender)
         var passwordCheck = validation.passwordValidation(password,confirmedPassword)




         if(emailCheck && nameCheck && phoneCheck && genderCheck && passwordCheck){

             var formData : ArrayList<String> = arrayListOf(nameField,emailField,phoneNumberField,gender)
             var intent = Intent(this, DataBaseActivity::class.java)
             intent.putExtra("DATABASE",formData)
             startActivity(intent)

         }else {

             if(!emailCheck) {
                 email.text?.clear()
                 email.setError("invalid email")
             }
             if(!nameCheck) {
                 firstName.text?.clear()
                 firstName.setError("Invalid Name character")
             }
             if(!phoneCheck) {
                 phoneNumber.text?.clear()
                 phoneNumber.setError("Invalid PhoneNumber")
                             }
             if(!passwordCheck) {
                 confirmPassword.text?.clear()
                 confirmPassword.setError("must be same with password")
             }




    }




}
}