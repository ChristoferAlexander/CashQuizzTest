package com.tg.alex.cashquizztest.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tg.alex.cashquizztest.project.managers.ToolbarManager;
import com.tg.alex.casjquizztest.R;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Alex on 10/25/2017.
 */

@EActivity
public abstract class BaseActivity extends AppCompatActivity {

    @Bean
    protected ToolbarManager mToolbarManager;

    @ViewById(R.id.loading)
    public ProgressBar mProgressBar;

    //container ID is missing
    private int NOT_SET = -1;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbarManager.setContext(getBaseContext());
    }

    /**
     * Method to get the resource ID for the fragment container.
     *
     * @return The resource ID for the activity's fragment container
     */
    public abstract int getFragmentContainerResource();

    /**
     * Method to return reference to activity's ToolbarManager
     *
     * @return The ToolbarManager's instance
     */
    public ToolbarManager getToolbarManager() {
        return mToolbarManager;
    }

    /**
     * Method to add a fragment to the fragment container of the activity.
     *
     * @param pFragment       the fragment to add
     * @param pAddToBackstack whether to add the fragment to the back stack
     */
    public void goToFragment(@NonNull BaseFragment pFragment, boolean pAddToBackstack) {
        // Check if there is a container in the activity for the fragment
        if (getFragmentContainerResource() == NOT_SET) {
            Log.e(getClass().getSimpleName(),
                    getString(R.string.error_add_fragment_container)
                            + " " + pFragment.getClass().getSimpleName()
                            + " " + getClass().getSimpleName()
            );
            return;
        }

        FragmentManager manager = getSupportFragmentManager();
        // Check if the current fragment is the one we are trying to go to
        int count = manager.getBackStackEntryCount();
        if (count > 0 && manager.getBackStackEntryAt(count - 1).getName().equals(pFragment.getClass().getName())) {
            // If so, return & don't add a new instance
            return;
        }

        // Begin the transaction, add the fragment to the activity's container
        FragmentTransaction transaction = manager.beginTransaction()
                .replace(getFragmentContainerResource(), pFragment);

        // Add to the backstack if true
        if (pAddToBackstack) {
            transaction.addToBackStack(pFragment.getClass().getName());
        }

        // Commit the transaction
        transaction.commit();
    }

    /**
     * Method to add a fragment to the fragment container of the activity with fragment animation.
     *
     * @param pFragment       the fragment to add
     * @param pAddToBackstack whether to add the fragment to the back stack
     */
    public void goToFragmentAnimated(@NonNull BaseFragment pFragment, boolean pAddToBackstack) {
        // Check if there is a container in the activity for the fragment
        if (getFragmentContainerResource() == NOT_SET) {
            Log.e(getClass().getSimpleName(),
                    getString(R.string.error_add_fragment_container)
                    + " " + pFragment.getClass().getSimpleName()
                    + " " + getClass().getSimpleName()
                    );
            return;
        }

        FragmentManager manager = getSupportFragmentManager();
        // Check if the current fragment is the one we are trying to go to
        int count = manager.getBackStackEntryCount();
        if (count > 0 && manager.getBackStackEntryAt(count - 1).getName().equals(pFragment.getClass().getName())) {
            // If so, return & don't add a new instance
            return;
        }

        // Begin the transaction, add the fragment to the activity's container
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.swipe_right_fragment_transaction, R.anim.swipe_left_fragment_transaction)
                .replace(getFragmentContainerResource(), pFragment);

        // Add to the backstack if true
        if (pAddToBackstack) {
            transaction.addToBackStack(pFragment.getClass().getName());
        }

        // Commit the transaction
        transaction.commit();
    }

    /**
     * Method to clear the backstack of the current activity.
     */
    public void clearBackstack() {
        FragmentManager manager = getSupportFragmentManager();
        for (int count = manager.getBackStackEntryCount(); count > 0; count--) {
            manager.popBackStack();
        }
    }

    // ************************************************************************************************************************************************************************
    // * Activity helper methods
    // ************************************************************************************************************************************************************************

    /**
     * Method to hide the soft keyboard.
     */
    public void hideSoftKeyboard() {
        hideSoftKeyboardFrom(getCurrentFocus());
    }

    /**
     * Method to hide the soft keyboard from View.
     */
    public void hideSoftKeyboardFrom(@Nullable View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Starts activity's ProgressBar
     */
    public void startLoadingAnim() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Starts activity's ProgressBar
     */
    public void stopLoadingAnim() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    public void showToast(@Nullable String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG);
    }
}

