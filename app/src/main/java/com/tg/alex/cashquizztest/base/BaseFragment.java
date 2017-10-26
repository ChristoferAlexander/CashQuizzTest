package com.tg.alex.cashquizztest.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tg.alex.cashquizztest.project.managers.ToolbarManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Alex on 10/25/2017.
 */

@EFragment
public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P> {

    protected BaseActivity mBaseActivity;
    protected FragmentManager mFragmentManager;
    private ToolbarManager mToolbarManager;

    /**
     * Main initialize fragment method
     */
    @AfterViews
    public void initBaseFragment() {
        mBaseActivity = (BaseActivity) getActivity();
        mFragmentManager = getChildFragmentManager();
        mToolbarManager = mBaseActivity.getToolbarManager();
        mToolbarManager.reset();
        initToolbar();
        afterViews();
    }

    protected abstract void afterViews();
    public abstract void initToolbar();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(BaseFragment.class.getSimpleName(), "CURRENT FRAGMENT: " + getClass().getSimpleName());
    }

    /**
     * Hide keyboard onPause
     */
    @Override
    public void onPause() {
        super.onPause();
        getBaseActivity().hideSoftKeyboard();
    }

    @NonNull
    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    /**
     * Method to return reference to activity's ToolbarManager
     *
     * @return The ToolbarManager instance
     */
    public ToolbarManager getToolbarManager() {
        return mToolbarManager;
    }

    /**
     * Replace the fragment activity's container with the given fragment
     *
     * @param fragment       the fragment
     * @param addToBackStack whether to add the fragment to the back stack
     */
    public void gotoFragment(@NonNull BaseFragment fragment, boolean addToBackStack) {
        mBaseActivity.goToFragment(fragment, addToBackStack);
    }

    /**
     * Replace the fragment activity's container with the given fragment
     *
     * @param fragment       the fragment
     * @param addToBackStack whether to add the fragment to the back stack
     */
    public void gotoFragmentaAnimated(@NonNull BaseFragment fragment, boolean addToBackStack) {
        mBaseActivity.goToFragmentAnimated(fragment, addToBackStack);
    }

    // ************************************************************************************************************************************************************************
    // * Activity helper methods
    // ************************************************************************************************************************************************************************

    /**
     * Starts activity's ProgressBar
     */
    public void startLoadingAnim() {
        mBaseActivity.startLoadingAnim();
    }

    /**
     * Starts activity's ProgressBar
     */
    public void stopLoadingAnim() {
        mBaseActivity.stopLoadingAnim();
    }

    public void showToast(@Nullable String msg){
        mBaseActivity.showToast(msg);
    }
}