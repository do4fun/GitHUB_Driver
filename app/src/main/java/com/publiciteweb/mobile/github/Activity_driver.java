package com.publiciteweb.mobile.github;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
    private static final String STATE_REPOS = "buttonRepos";
    private static final String STATE_COUCHETTE = "buttonCouchette";
    private static final String STATE_CONDUIT = "buttonConduit";
    private static final String STATE_TRAVAIL = "buttonTravail";
    private static int NAME_BUTTON = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        readContenApp();
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            /*btnRepos.setBackgroundColor(savedInstanceState.getInt(STATE_REPOS));
            btnCouchette.setBackgroundColor(savedInstanceState.getInt(STATE_COUCHETTE));
            btnConduite.setBackgroundColor(savedInstanceState.getInt(STATE_CONDUIT));
            btnTravail.setBackgroundColor(savedInstanceState.getInt(STATE_TRAVAIL));*/
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_BUTTON, NAME_BUTTON);
        /*savedInstanceState.putInt(STATE_REPOS, ((ColorDrawable)btnRepos.getBackground()).getColor());
        savedInstanceState.putInt(STATE_COUCHETTE, ((ColorDrawable)btnCouchette.getBackground()).getColor());
        savedInstanceState.putInt(STATE_CONDUIT, ((ColorDrawable)btnConduite.getBackground()).getColor());
        savedInstanceState.putInt(STATE_TRAVAIL, ((ColorDrawable)btnTravail.getBackground()).getColor());*/
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       /* btnRepos.setBackgroundColor(savedInstanceState.getInt(STATE_REPOS));
        btnCouchette.setBackgroundColor(savedInstanceState.getInt(STATE_COUCHETTE));
        btnConduite.setBackgroundColor(savedInstanceState.getInt(STATE_CONDUIT));
        btnTravail.setBackgroundColor(savedInstanceState.getInt(STATE_TRAVAIL));*/
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
                Intent intentFicheJournaliere = new Intent(Activity_driver.this, Activity_ficheJournaliere.class);
                startActivity(intentFicheJournaliere);
                break;
            default:
                break;
        }
    }
}
