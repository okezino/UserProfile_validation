package com.example.registration

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    /**
     * Instance of valid input
     */
    private val testName = "Alhaji Okezi"
    private val testEmail = "okezi002@gmail.com"
    private val testNumber = "07060409290"
    private val password = "123"
    private val confirmPassword = "123"



    /**
     * Instance of invalid input
     */
    private val failedTestName = "Okezi002 Alex123"
    private val failedTestEmail = "okezi002@gmailcom"
    private val failedTestNumber = "0706040929"
    private val failedTestPassword = "abc"



    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun registrationButton() {

        /**
         * Check validation  with invalid Input parameters
         */
        onView(withId(R.id.firstName)).perform(typeText(failedTestName))
        onView(withId(R.id.email)).perform(typeText(failedTestEmail), closeSoftKeyboard())
        onView(withId(R.id.phoneNumber)).perform(typeText(failedTestNumber), closeSoftKeyboard())
        onView(withId(R.id.passWord)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.confirmPassword)).perform(typeText(failedTestPassword), closeSoftKeyboard())
        onView(withId(R.id.registrationButton)).perform(click())

        /**
         * Run with Valid Details
         */

        onView(withId(R.id.firstName)).perform(typeText(testName))
        onView(withId(R.id.email)).perform(typeText(testEmail), closeSoftKeyboard())
        onView(withId(R.id.phoneNumber)).perform(typeText(testNumber), closeSoftKeyboard())
        onView(withId(R.id.sex)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("MALE"))).perform(click())
        onView(withId(R.id.confirmPassword)).perform(typeText(confirmPassword), closeSoftKeyboard())
        onView(withId(R.id.registrationButton)).perform(click())

        /**
         * Check ViewGroup  of the Database Activity
         */
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.nameTextField)).check(matches(isDisplayed()))
        onView(withId(R.id.emailTextField)).check(matches(isDisplayed()))
        onView(withId(R.id.phoneTextField)).check(matches(isDisplayed()))
        onView(withId(R.id.genderTextField)).check(matches(isDisplayed()))


        /**
         * Ascertain the value from the Main Activity is Same Value Sent to the Database
         * Activity
         */
        onView(withId(R.id.nameField)).check(matches(withText(testName)))
        onView(withId(R.id.emailField)).check(matches(withText(testEmail)))
        onView(withId(R.id.phoneField)).check(matches(withText(testNumber)))
        onView(withId(R.id.genderField)).check(matches(withText("MALE")))




    }

    /**
     * Ascertain that all ViewGroup from the activity_main layout are visible on the screen
     */

    @Test
    fun Profile_Page_View_Content_Visibility(){


        onView(withId(R.id.firstName)).check(matches(isDisplayed()))
        onView(withId(R.id.email)).check(matches(isDisplayed()))
        onView(withId(R.id.phoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.sex)).check(matches(isDisplayed()))
        onView(withId(R.id.passWord)).check(matches(isDisplayed()))
        onView(withId(R.id.confirmPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.registrationButton)).check(matches(isDisplayed()))

    }




}