package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity
        implements Step0Fragment.OnNextStep0Listener, Step1Fragment.OnNextStep1Listener {

    private String mCurrentFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentFragmentTag = savedInstanceState.getString("currentFragmentTag");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // replace Step0Fragment in containerFrameLayout
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(mCurrentFragmentTag);
        if (currentFragment == null) {
            mCurrentFragmentTag = Step0Fragment.class.getName();
            currentFragment = new Step0Fragment();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, currentFragment, mCurrentFragmentTag)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("currentFragmentTag", mCurrentFragmentTag);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onNextStep0() {
        // replace Step1Fragment in containerFrameLayout
        mCurrentFragmentTag = Step1Fragment.class.getSimpleName();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, new Step1Fragment(), mCurrentFragmentTag)
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onNextStep1(String s) {
        mCurrentFragmentTag = Step2Fragment.class.getSimpleName();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, Step2Fragment.newInstance(s), mCurrentFragmentTag)
                .addToBackStack(mCurrentFragmentTag)
                .commit();
    }
}
