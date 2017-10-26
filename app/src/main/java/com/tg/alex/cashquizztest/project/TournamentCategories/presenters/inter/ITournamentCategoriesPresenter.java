package com.tg.alex.cashquizztest.project.TournamentCategories.presenters.inter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.inter.ITournamentCategoriesFragment;

/**
 * Created by Alex on 10/26/2017.
 */

public interface ITournamentCategoriesPresenter extends MvpPresenter<ITournamentCategoriesFragment> {
    void getTournamentCategories();
}
