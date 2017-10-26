package com.tg.alex.cashquizztest.project.managers;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Alex on 10/18/2017.
 */

@EBean
public class ToolbarManager {

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @ViewById(R.id.start_icon)
    ImageView mStartIcon;

    @ViewById(R.id.title)
    TextView mTitle;

    private StartIconClickListener mStartIconClickListener;
    private Context mContext;

    public void setToolbar(View v) {
        mToolbar = (Toolbar) v;
    }

    public ToolbarManager() {
    }

    public void setContext(Context pContext) {
        mContext = pContext;
    }

    public void reset() {
        if ( mToolbar != null) {
            resetIconStart();
            resetTitle();
            mContext = null;
        }
    }

    public void setBackgroundColor(int color) {
        mToolbar.setBackgroundColor(mContext.getResources().getColor(color));
    }
    // ************************************************************************************************************************************************************************
    // * Title
    // ************************************************************************************************************************************************************************

    public ToolbarManager setTitle(String text) {
        mTitle.setVisibility(View.VISIBLE);
        mTitle.setText(text);
        return this;
    }

    private void resetTitle() {
        mTitle.setVisibility(View.GONE);
        mTitle.setOnClickListener(null);
        mTitle.setText(null);
    }

    // ************************************************************************************************************************************************************************
    // * Start Icon
    // ************************************************************************************************************************************************************************

    public ToolbarManager setIconStart(int resource, final StartIconClickListener pStartIconClickListener) {
        this.mStartIconClickListener = pStartIconClickListener;
        mStartIcon.setVisibility(View.VISIBLE);
        mStartIcon.setImageResource(resource);
        if (mStartIconClickListener != null)
            mStartIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mStartIconClickListener.onStartIconClick();
                }
            });
        return this;
    }

    private void resetIconStart() {
        mStartIcon.setVisibility(View.INVISIBLE);
        mStartIcon.setOnClickListener(null);
        mStartIconClickListener = null;
    }

    public interface StartIconClickListener {
        void onStartIconClick();
    }
}
