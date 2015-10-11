package com.lukaville.hw1;

import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.lukaville.hw1.ui.ListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.lukaville.hw1.Util.byIndex;
import static com.lukaville.hw1.Util.withBackgroundColor;

/**
 * Created by nickolay on 11.10.15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListActivityTest {

    public static final int WHITE_COLOR = Color.parseColor("#ffffff");
    public static final int GRAY_COLOR = Color.parseColor("#aaaaaa");

    @Rule
    public ActivityTestRule<ListActivity> mActivityRule = new ActivityTestRule<>(ListActivity.class);

    @Test
    public void oddElementWhite() {
        onView(byIndex(withId(R.id.recycler_view), 0)).check(matches(withBackgroundColor(GRAY_COLOR)));
        onView(byIndex(withId(R.id.recycler_view), 2)).check(matches(withBackgroundColor(WHITE_COLOR)));
    }

    @Test
    public void evenElementGray() {
        onView(byIndex(withId(R.id.recycler_view), 1)).check(matches(withBackgroundColor(WHITE_COLOR)));
        onView(byIndex(withId(R.id.recycler_view), 3)).check(matches(withBackgroundColor(GRAY_COLOR)));
    }
}