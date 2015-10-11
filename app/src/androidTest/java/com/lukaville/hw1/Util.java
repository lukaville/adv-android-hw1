package com.lukaville.hw1;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by nickolay on 11.10.15.
 */

public class Util {
    public static Matcher<View> withBackgroundColor(final int color) {
        Checks.checkNotNull(color);
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getBackground() instanceof ColorDrawable)) {
                    return false;
                }

                return color == ((ColorDrawable) view.getBackground()).getColor();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("background color");
            }
        };
    }

    public static Matcher<View> byIndex(final Matcher<View> parentMatcher, final int index) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("child by index");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }
                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(index).equals(view);

            }
        };
    }
}
