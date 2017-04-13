package com.publiciteweb.mobile.github;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.graphics.Color.rgb;
import static com.publiciteweb.mobile.github.R.drawable.button_press;

/**
 * Created by sun on 17-04-10.
 */

public class Activity_driver extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbarGestion;
    private Button btnRepos;
    private Button btnCouchette;
    private Button btnConduite;
    private Button btnTravail;
    private Button btnFicheJournaliere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        readContenApp();
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_driver);
            linearLayoutHaut.setOrientation(LinearLayout.VERTICAL);
            linearLayoutFoot.setOrientation(LinearLayout.VERTICAL);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            linearLayoutHaut.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutFoot.setOrientation(LinearLayout.HORIZONTAL);
        }
    }*/

    protected void readContenApp(){
        toolbarGestion = (Toolbar)findViewById(R.id.toolbarGestion);
        toolbarGestion.setNavigationIcon(R.drawable.logo_old);
        setSupportActionBar(toolbarGestion);
        getSupportActionBar().setTitle("GitHub Driver");

        btnRepos = (Button)findViewById(R.id.btnRepos);
        btnRepos.setOnClickListener(this);
        btnCouchette = (Button)findViewById(R.id.btnCouchette);
        btnCouchette.setOnClickListener(this);
        btnConduite = (Button)findViewById(R.id.btnConduite);
        btnConduite.setOnClickListener(this);
        btnTravail = (Button)findViewById(R.id.btnTravail);
        btnTravail.setOnClickListener(this);
        btnFicheJournaliere = (Button)findViewById(R.id.btnFicheJournaliere);
        btnFicheJournaliere.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRepos:
                btnRepos.setBackground(getDrawable(R.drawable.button_press));
                btnCouchette.setBackgroundColor(rgb(0,102,153));
                btnConduite.setBackgroundColor(rgb(0,102,153));
                btnTravail.setBackgroundColor(rgb(0,102,153));
                break;
            case R.id.btnCouchette:
                btnCouchette.setBackground(getDrawable(R.drawable.button_press));
                btnRepos.setBackgroundColor(rgb(0,102,153));
                btnConduite.setBackgroundColor(rgb(0,102,153));
                btnTravail.setBackgroundColor(rgb(0,102,153));
                break;
            case R.id.btnConduite:
                btnConduite.setBackground(getDrawable(R.drawable.button_press));
                btnRepos.setBackgroundColor(rgb(0,102,153));
                btnCouchette.setBackgroundColor(rgb(0,102,153));
                btnTravail.setBackgroundColor(rgb(0,102,153));
                break;
            case R.id.btnTravail:
                btnTravail.setBackground(getDrawable(R.drawable.button_press));
                btnRepos.setBackgroundColor(rgb(0,102,153));
                btnCouchette.setBackgroundColor(rgb(0,102,153));
                btnConduite.setBackgroundColor(rgb(0,102,153));
                break;
            case R.id.btnFicheJournaliere:
                Intent intentFicheJournaliere = new Intent(Activity_driver.this, Activity_ficheJournaliere.class);
                startActivity(intentFicheJournaliere);
                break;
            default:
                break;
        }
    }
}
