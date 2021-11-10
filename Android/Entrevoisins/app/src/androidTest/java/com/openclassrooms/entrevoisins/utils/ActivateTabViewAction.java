package com.openclassrooms.entrevoisins.utils;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Matcher;

public class ActivateTabViewAction implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Activate Favorite Tab";
    }

    @Override
    public void perform(UiController uiController, View view) {
        ViewPager container = view.findViewById(R.id.container);
        container.setCurrentItem(1);

    }
}
