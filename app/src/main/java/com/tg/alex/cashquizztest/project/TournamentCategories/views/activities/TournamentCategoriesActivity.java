package com.tg.alex.cashquizztest.project.TournamentCategories.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tg.alex.cashquizztest.base.BaseActivity;
import com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.impl.TournamentCategoriesFragment_;
import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.EActivity;

/**
 * Created by Alex on 10/25/2017.
 */

@EActivity(R.layout.activity_tournament_categories)
public class TournamentCategoriesActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create and place Fragment to container
        goToFragment(TournamentCategoriesFragment_.builder().build(), false);
    }

    @Override
    public int getFragmentContainerResource() {
        return R.id.main_container;
    }

}
