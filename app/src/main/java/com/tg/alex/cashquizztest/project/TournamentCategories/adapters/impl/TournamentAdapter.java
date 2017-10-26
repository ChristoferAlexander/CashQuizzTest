package com.tg.alex.cashquizztest.project.TournamentCategories.adapters.impl;

import android.view.ViewGroup;

import com.tg.alex.cashquizztest.base.BaseRecyclerAdapter;
import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view.TournamentCardView;
import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view.TournamentCardView_;
import com.tg.alex.cashquizztest.project.models.Tournament;

import org.androidannotations.annotations.EBean;


/**
 * Created by Alex on 10/26/2017.
 */

@EBean
public class TournamentAdapter extends BaseRecyclerAdapter<Tournament, TournamentCardView> {

    @Override
    protected TournamentCardView onCreateItemView(ViewGroup pParent, int pViewType) {
          return TournamentCardView_.build(pParent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewWrapper<TournamentCardView> holder, int position) {
         holder.getView().bind(mItems.get(position));
    }
}
