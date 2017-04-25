package com.publiciteweb.mobile.github;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by sun on 17-04-10.
 */

public class Activity_ficheJournaliere extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbarGestion;
    private Button btnBack;
    protected static final int NOMBRE_PAGES = 14; //The number of pages (wizard steps)

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
        toolbarGestion.setNavigationIcon(R.drawable.logo2);
        setSupportActionBar(toolbarGestion);
        getSupportActionBar().setTitle("GitHub Driver");

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        // Instantiate a ViewPager and a PagerAdapter.
        viewPagerFiches = (ViewPager)findViewById(R.id.viewPagerFiches);
        mPagerAdapter = new ScreenSlidePagerAdapter(super.getSupportFragmentManager());
        viewPagerFiches.setAdapter(mPagerAdapter);
    }

    //Bouton Retour pour retourner au activity Driver
    @Override
    public void onClick(View v) {
        Activity_ficheJournaliere.this.finish();
    }
}
