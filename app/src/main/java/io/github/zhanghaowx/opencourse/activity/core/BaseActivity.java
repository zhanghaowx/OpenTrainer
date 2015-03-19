package io.github.zhanghaowx.opencourse.activity.core;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

/**
 * This is the base class for any activity that contains
 * one fragment
 */
public abstract class BaseActivity extends ActionBarActivity {

    protected Toolbar mToolbar;

    /**
     * Create a fragment for this activity.
     *
     * @return created fragment
     */
    protected abstract Fragment getFragment();

    /**
     * Get the ID for above fragment
     *
     * @return
     */
    protected abstract int getFragmentId();

    /**
     * Returns the layout resource identifier for this activity
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * Returns resource id for tool bar
     *
     * @return
     */
    protected abstract int getToolbarId();

    /**
     * Returns resource id for the enter transition of this activity
     *
     * @return
     */
    protected abstract int getEnterTransition();

    /**
     * Returns resource id for the exit transition for this activity
     *
     * @return
     */
    protected abstract int getExitTransition();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // because getWindow().requestFeature() needs to be called first
        // so setupTransition() needs to be put before super.onCreate()
        setupTransition();

        super.onCreate(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getFragmentId());

        if (fragment == null) {
            fragment = getFragment();
            if (fragment != null) {
                fm.beginTransaction()
                        .add(getFragmentId(), fragment)
                        .commit();
            }
        }

        setContentView(getLayoutId());
        setToolbar(getToolbarId());
    }

    /**
     * Setup exit transition of the activity
     */
    private void setupTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition enterTransition = inflater.inflateTransition(getEnterTransition());
            Transition exitTransition = inflater.inflateTransition(getExitTransition());

            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(enterTransition);
            getWindow().setExitTransition(exitTransition);
        }
    }

    /**
     * Setup action tool bar
     *
     * @param toolbarId
     */
    private void setToolbar(int toolbarId) {
        mToolbar = (Toolbar) findViewById(toolbarId);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}
