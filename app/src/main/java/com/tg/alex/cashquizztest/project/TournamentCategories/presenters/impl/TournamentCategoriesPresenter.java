package com.tg.alex.cashquizztest.project.TournamentCategories.presenters.impl;

import com.tg.alex.cashquizztest.network.pojo.TournamentCategoriesPojo;
import com.tg.alex.cashquizztest.network.pojo.TournamentsPojo;
import com.tg.alex.cashquizztest.project.TournamentCategories.presenters.inter.ITournamentCategoriesPresenter;
import com.tg.alex.cashquizztest.project.TournamentCategories.providers.impl.TournamentCategoriesProvider;
import com.tg.alex.cashquizztest.project.TournamentCategories.providers.impl.TournamentsProvider;
import com.tg.alex.cashquizztest.project.TournamentCategories.providers.inter.IDataListener;
import com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.inter.ITournamentCategoriesFragment;
import com.tg.alex.cashquizztest.project.models.Tournament;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Alex on 10/26/2017.
 */

@EBean
public class TournamentCategoriesPresenter implements ITournamentCategoriesPresenter {

    // TournamentCategories Provider
    @Bean
    TournamentCategoriesProvider mTournamentCategoriesProvider;

    // Tournaments Provider
    @Bean
    TournamentsProvider mTournamentsProvider;

    // ref to Fragments interface
    private ITournamentCategoriesFragment mView;

    @Override
    public void attachView(ITournamentCategoriesFragment view) {
        mView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (!retainInstance)
            mView = null;
    }

    @Override
    public void getTournamentCategories() {
        // call first Provider to get categories
        mTournamentCategoriesProvider.provide(new IDataListener<TournamentCategoriesPojo>() {
            // first provider onComplete()
            @Override
            public void onComplete(final TournamentCategoriesPojo pTournamentCategories) {
                // call second Provider to get tournaments
                mTournamentsProvider.provide(new IDataListener<TournamentsPojo>() {
                    // second Provider onComplete()
                    @Override
                    public void onComplete(TournamentsPojo pTournaments) {
                        // sort tournaments in each category by endDate
                        for (int i = 0; i < pTournamentCategories.getTournamentCategories().size(); i++) {
                            for (Tournament tournament : pTournaments.getTournaments()) {
                                if (tournament.getCategoryId().equals(pTournamentCategories.getTournamentCategories().get(i).getId())) {
                                    pTournamentCategories.getTournamentCategories().get(i).setTournament(tournament);
                                }
                            }
                        }
                        // callback to Fragment
                        mView.onTournamentCategoriesProvided(pTournamentCategories.getTournamentCategories());
                    }
                    // second Provider onError()
                    @Override
                    public void onError(int pError) {
                        mView.onError(pError);
                    }
                });
            }
            // first Provider onError()
            @Override
            public void onError(int pError) {
                mView.onError(pError);
            }
        });
    }


}
