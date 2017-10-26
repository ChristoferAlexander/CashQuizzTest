package com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.inter;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tg.alex.cashquizztest.project.models.TournamentCategory;

import java.util.List;

/**
 * Created by Alex on 10/25/2017.
 */

public interface ITournamentCategoriesFragment extends MvpView{
    void onTournamentCategoriesProvided(List<TournamentCategory> pTournamentCategories);
    void onError(int pErrorCode);
}
