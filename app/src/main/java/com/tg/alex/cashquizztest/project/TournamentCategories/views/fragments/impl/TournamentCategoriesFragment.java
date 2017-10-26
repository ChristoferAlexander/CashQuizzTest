package com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.impl;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tg.alex.cashquizztest.base.BaseFragment;
import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.impl.TournamentCategoriesAdapter;
import com.tg.alex.cashquizztest.project.TournamentCategories.presenters.impl.TournamentCategoriesPresenter;
import com.tg.alex.cashquizztest.project.TournamentCategories.presenters.inter.ITournamentCategoriesPresenter;
import com.tg.alex.cashquizztest.project.TournamentCategories.views.fragments.inter.ITournamentCategoriesFragment;
import com.tg.alex.cashquizztest.project.managers.ToolbarManager;
import com.tg.alex.cashquizztest.project.models.TournamentCategory;
import com.tg.alex.cashquizztest.project.utils.Constants;
import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by Alex on 10/25/2017.
 */

@EFragment(R.layout.fragment_display_tournament_categories)
public class TournamentCategoriesFragment
        extends
        BaseFragment<ITournamentCategoriesFragment,
                ITournamentCategoriesPresenter>
        implements
        ITournamentCategoriesFragment,
        ToolbarManager.StartIconClickListener {

    @ViewById(R.id.frame)
    RecyclerView mTournamentCategoriesList;

    @Bean
    TournamentCategoriesPresenter mPresenter;

    @Bean
    TournamentCategoriesAdapter mAdapter;

    /**
     * Initializes fragment
     */
    @Override
    protected void afterViews() {
        mTournamentCategoriesList.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mPresenter.getTournamentCategories();
        startLoadingAnim();
    }

    /**
     * Initializes Toolbar
     */
    @Override
    public void initToolbar() {
        getToolbarManager().setIconStart(R.drawable.ic_close, this).setTitle(getString(R.string.tournament_categories_title));
    }

    /**
     * Needed for gosby MVP structure
     *
     * @return our Presenter instance
     */
    @Override
    public ITournamentCategoriesPresenter createPresenter() {
        return mPresenter;
    }

    /**
     * Callback from presenter when data is ready
     *
     * @param pTournamentCategories a list of categories with tournaments
     */
    @Override
    public void onTournamentCategoriesProvided(List<TournamentCategory> pTournamentCategories) {
        mAdapter.setItems(pTournamentCategories);
        mTournamentCategoriesList.setAdapter(mAdapter);
        stopLoadingAnim();
    }

    /**
     * Callback from Presenter when error
     *
     * @param pErrorCode the error code
     */
    @Override
    public void onError(int pErrorCode) {
        stopLoadingAnim();
        switch (pErrorCode) {
            case Constants.NOT_FOUND:
                showToast(getString(R.string.error_msg));
                break;
        }
    }

    /**
     * Implementation of Toolbars start icon click interface
     */
    @Override
    public void onStartIconClick() {
        getBaseActivity().finish();
    }
}
