package com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tg.alex.cashquizztest.project.TournamentCategories.adapters.impl.TournamentAdapter;
import com.tg.alex.cashquizztest.project.models.TournamentCategory;
import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Alex on 10/26/2017.
 */

@EViewGroup(R.layout.rv_item_tournament_category)
public class TournamentCategoryItemView extends LinearLayout {

    @ViewById(R.id.frame)
    LinearLayout frame;

    @ViewById(R.id.category_title)
    TextView title;

    @ViewById(R.id.tournament_list)
    RecyclerView list;

    @Bean
    TournamentAdapter mAdapter;

    public TournamentCategoryItemView(@NonNull Context context) {
        super(context);
    }

    public TournamentCategoryItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TournamentCategoryItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TournamentCategoryItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(TournamentCategory category) {
        if (category.getTournaments() == null || category.getTournaments().isEmpty()) {
            frame.setVisibility(GONE);
            return;
        }

        if (category.getTitle() != null)
            title.setText(category.getTitle());

        list.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        mAdapter.setItems(category.getTournamentsSortedByEndDate());
        list.setAdapter(mAdapter);
    }
}
