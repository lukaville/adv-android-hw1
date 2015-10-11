package com.lukaville.hw1;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.lukaville.hw1.ui.ListActivity;
import com.lukaville.hw1.ui.SplashScreenActivity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Created by nickolay on 11.10.15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityRule = new ActivityTestRule<>(SplashScreenActivity.class);

    @BeforeClass
    public static void init() {
        Intents.init();
    }

    @Test
    public void openListActivity() {
        intended(hasComponent(ListActivity.class.getName()));
    }

    @AfterClass
    public static void release() {
        Intents.release();
    }
}