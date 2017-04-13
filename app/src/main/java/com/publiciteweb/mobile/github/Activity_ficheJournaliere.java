package com.publiciteweb.mobile.github;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by sun on 17-04-10.
 */

public class Activity_ficheJournaliere extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbarGestion;
    private Button btnBack;
    protected static final int NOMBRE_PAGES = 14; //The number of pages (wizard steps)
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager viewPagerFiches;
    private PagerAdapter mPagerAdapter; //The pager adapter, which provides the pages to the view pager widget.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport);
        readContenApp();
    }

    protected void readContenApp(){
        toolbarGestion = (Toolbar)findViewById(R.id.toolbarGestion);
        toolbarGestion.setNavigationIcon(R.drawable.logo_old);
        setSupportActionBar(toolbarGestion);
        getSupportActionBar().setTitle("GitHub Driver");

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        // Instantiate a ViewPager and a PagerAdapter.
        viewPagerFiches = (ViewPager)findViewById(R.id.viewPagerFiches);
        mPagerAdapter = new ScreenSlidePagerAdapter(super.getSupportFragmentManager());
        viewPagerFiches.setAdapter(mPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        Activity_ficheJournaliere.this.finish();
    }

    /*@Override
    public void onBackPressed() {
        if (viewPagerFiches.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPagerFiches.setCurrentItem(viewPagerFiches.getCurrentItem() - 1);
        }
    }*/

}
