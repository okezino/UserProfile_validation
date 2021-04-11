package com.example.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_data_base.*
import kotlinx.android.synthetic.main.activity_main.*

class DataBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)

        /**
         * Declare Instance of Intent to retrieve data sent from the Intent
         * Cast the Data to InputList as ArrayList
         */

        var intent  = getIntent()
        var  inputList = intent.getSerializableExtra("DATABASE")  as ArrayList<String>

        /**
         * Set all input Data to their respective textView Field
         */

        nameField.text = inputList .get(0)
        emailField.text = inputList .get(1)
        phoneField.text  = inputList .get(2)
        genderField.text = inputList .get(3)


    }


}