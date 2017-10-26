package com.tg.alex.cashquizztest.project.TournamentCategories.adapters.impl;

import android.view.ViewGroup;

import com.tg.alex.cashquizztest.base.BaseRecyclerAdapter;
import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view.TournamentCategoryItemView;
import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view.TournamentCategoryItemView_;
import com.tg.alex.cashquizztest.project.models.TournamentCategory;

import org.androidannotations.annotations.EBean;


/**
 * Created by Alex on 10/26/2017.
 */

@EBean
public class TournamentCategoriesAdapter extends BaseRecyclerAdapter<TournamentCategory, TournamentCategoryItemView> {

    @Override
    protected TournamentCategoryItemView onCreateItemView(ViewGroup pParent, int pViewType) {
          return TournamentCategoryItemView_.build(pParent.getContext());

    }

    @Override
    public void onBindViewHolder(ViewWrapper<TournamentCategoryItemView> holder, int position) {
         holder.getView().bind(mItems.get(position));
    }
}
