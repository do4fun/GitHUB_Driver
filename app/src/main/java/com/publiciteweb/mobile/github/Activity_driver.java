package com.publiciteweb.mobile.github;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.rgb;

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
    private final int buttonColorBlue = rgb(0,102,153);
    private static final String STATE_BUTTON = "buttonPressed";
    private static int NAME_BUTTON = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        readContenApp();
        if (savedInstanceState != null) {
            //pour re-initialiser l'etat de boutons (presse ou normal)
            // en changement screen orientation ou après la pause
            switch (NAME_BUTTON){
                case R.id.btnRepos:
                    btnRepos.setBackground(getDrawable(R.drawable.button_press));
                    break;
                case R.id.btnCouchette:
                    btnCouchette.setBackground(getDrawable(R.drawable.button_press));
                    break;
                case R.id.btnConduite:
                    btnConduite.setBackground(getDrawable(R.drawable.button_press));
                    break;
                case R.id.btnTravail:
                    btnTravail.setBackground(getDrawable(R.drawable.button_press));
                    break;
                default:
                    break;
            }
        }
    }

    //pour sauvegarder l'etat de boutons (presse ou normal)
    //pour re-initialiser après le changement screen orientation ou la pause
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_BUTTON, NAME_BUTTON);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        switch (NAME_BUTTON){
            case R.id.btnRepos:
                btnRepos.setBackground(getDrawable(R.drawable.button_press));
                break;
            case R.id.btnCouchette:
                btnCouchette.setBackground(getDrawable(R.drawable.button_press));
                break;
            case R.id.btnConduite:
                btnConduite.setBackground(getDrawable(R.drawable.button_press));
                break;
            case R.id.btnTravail:
                btnTravail.setBackground(getDrawable(R.drawable.button_press));
                break;
            default:
                break;
        }
    }

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
                NAME_BUTTON = R.id.btnRepos;
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                break;
            case R.id.btnCouchette:
                btnCouchette.setBackground(getDrawable(R.drawable.button_press));
                NAME_BUTTON = R.id.btnCouchette;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                break;
            case R.id.btnConduite:
                btnConduite.setBackground(getDrawable(R.drawable.button_press));
                NAME_BUTTON = R.id.btnConduite;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                break;
            case R.id.btnTravail:
                btnTravail.setBackground(getDrawable(R.drawable.button_press));
                NAME_BUTTON = R.id.btnTravail;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                break;
            case R.id.btnFicheJournaliere:
                //ouvrir la fenetre avec Fiche Journalière
                Intent intentFicheJournaliere = new Intent(Activity_driver.this, Activity_ficheJournaliere.class);
                startActivity(intentFicheJournaliere);
                break;
            default:
                break;
        }
    }
}
