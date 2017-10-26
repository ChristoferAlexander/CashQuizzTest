package com.tg.alex.cashquizztest.project.TournamentCategories.adapters.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tg.alex.cashquizztest.project.models.Tournament;
import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import me.grantland.widget.AutofitTextView;

/**
 * Created by Alex on 10/26/2017.
 */
@EViewGroup(R.layout.rv_item_tournament)
public class TournamentCardView extends LinearLayout {

    @ViewById(R.id.img)
    ImageView img;

    @ViewById(R.id.date)
    TextView date;

    @ViewById(R.id.desc)
    AutofitTextView desc;

    public TournamentCardView(@NonNull Context context) {
        super(context);
    }

    public TournamentCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TournamentCardView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TournamentCardView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(Tournament tournament) {
        if (tournament.getDesc() != null)
            desc.setText(tournament.getDesc());

        if(tournament.getEndDate() != null)
            date.setText(tournament.getEndDate());

        Glide.with(getContext()).load(tournament.getImgUrl()).into(img);
    }
}
