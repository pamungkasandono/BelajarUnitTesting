package com.example.myunittesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dummyVolume = "504.0"
    private val dummyKeliling = "100.0"
    private val dummyLuasPermukaan = "396.0"
    private val dummyPanjang = "12.0"
    private val dummyLebar = "7.0"
    private val dummyTinggi = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetKeliling() {
        Espresso.onView(withId(R.id.et_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())

        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())

        Espresso.onView(withId(R.id.btn_hit_keliling)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hit_keliling)).perform(click())

        Espresso.onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_hasil)).check(matches(withText(dummyKeliling)))
    }

    @Test
    fun assertGetSurfaceArea() {
        Espresso.onView(withId(R.id.et_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
        Espresso.onView(withId(R.id.btn_hit_luas_permukaan)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hit_luas_permukaan)).perform(click())
        Espresso.onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_hasil)).check(matches(withText(dummyLuasPermukaan)))
    }
    @Test
    fun assertGetVolume() {
        Espresso.onView(withId(R.id.et_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
        Espresso.onView(withId(R.id.btn_hit_volume)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hit_volume)).perform(click())
        Espresso.onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_hasil)).check(matches(withText(dummyVolume)))
    }
    //Pengecekan untuk empty input
    @Test
    fun assertEmptyInput() {
        // pengecekan input untuk lebar
        Espresso.onView(withId(R.id.et_lebar)).perform(typeText(emptyInput), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
        Espresso.onView(withId(R.id.et_lebar)).check(matches(hasErrorText(fieldEmpty)))
        Espresso.onView(withId(R.id.et_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        // pengecekan input untuk panjang
        Espresso.onView(withId(R.id.et_panjang)).perform(typeText(emptyInput), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
        Espresso.onView(withId(R.id.et_panjang)).check(matches(hasErrorText(fieldEmpty)))
        Espresso.onView(withId(R.id.et_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        // pengecekan input untuk tinggi
        Espresso.onView(withId(R.id.et_tinggi)).perform(typeText(emptyInput), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
        Espresso.onView(withId(R.id.et_tinggi)).check(matches(hasErrorText(fieldEmpty)))
        Espresso.onView(withId(R.id.et_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_hitung)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btn_hitung)).perform(click())
    }
}