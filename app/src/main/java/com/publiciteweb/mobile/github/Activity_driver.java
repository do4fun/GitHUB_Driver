package com.publiciteweb.mobile.github;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
    private final int buttonColorBlueClair = rgb(0, 172, 230);
    private static final String STATE_BUTTON = "buttonPressed";
    private static int NAME_BUTTON = 0;

    private String username;
    private String passw;
    private String sessionid;
    private String userid;

    private final String OFFDUTTY = "1";
    private final String SLEEPER = "2";
    private final String DRIVING = "3";
    private final String ONDUTY = "4";

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
                    btnRepos.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                    break;
                case R.id.btnCouchette:
                    btnCouchette.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                    break;
                case R.id.btnConduite:
                    btnConduite.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                    break;
                case R.id.btnTravail:
                    btnTravail.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                    break;
                default:
                    break;
            }
        }
    }

    //pour sauvegarder l'etat de boutons (presse ou normal)
    //et re-initialiser après le changement screen orientation ou la pause
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_BUTTON, NAME_BUTTON);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        switch (NAME_BUTTON){
            case R.id.btnRepos:
                btnRepos.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                break;
            case R.id.btnCouchette:
                btnCouchette.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                break;
            case R.id.btnConduite:
                btnConduite.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                break;
            case R.id.btnTravail:
                btnTravail.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                break;
            default:
                break;
        }
    }

    protected void readContenApp(){
        toolbarGestion = (Toolbar)findViewById(R.id.toolbarGestion);
        toolbarGestion.setNavigationIcon(R.drawable.logo2);
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

        username = getIntent().getStringExtra("username");
        passw = getIntent().getStringExtra("passw");
        sessionid = getIntent().getStringExtra("sessionid");
        userid = getIntent().getStringExtra("userid");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRepos:
                btnRepos.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                NAME_BUTTON = R.id.btnRepos;
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                registrerTempsActivitie(OFFDUTTY);
                break;
            case R.id.btnCouchette:
                btnCouchette.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                NAME_BUTTON = R.id.btnCouchette;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                registrerTempsActivitie(SLEEPER);
                break;
            case R.id.btnConduite:
                btnConduite.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                NAME_BUTTON = R.id.btnConduite;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnTravail.setBackgroundColor(buttonColorBlue);
                registrerTempsActivitie(DRIVING);
                break;
            case R.id.btnTravail:
                btnTravail.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_press, null));
                NAME_BUTTON = R.id.btnTravail;
                btnRepos.setBackgroundColor(buttonColorBlue);
                btnCouchette.setBackgroundColor(buttonColorBlue);
                btnConduite.setBackgroundColor(buttonColorBlue);
                registrerTempsActivitie(ONDUTY);
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

    public void registrerTempsActivitie(String activitie) {
        //creation requete Volley avec méthode GET
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlForConnection = Driver.URL_DISPATCH + "logbook.php?username=" + username
                + "&passw=" + passw
                + "&sessionid=" + sessionid
                + "&userid=" + userid
                + "&activity=" + activitie;
        Log.d("RESULTAT_ACTIVITIE", urlForConnection);
        StringRequest getRequest = new StringRequest(Request.Method.GET, urlForConnection,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                Log.d("REPONSE_ACTIVITIE", response);
                    if (!response.equals("OK")) {
                        Log.d("REPONSE_ACTIVITE_ERREUR", "------"+response);
                        Toast.makeText(getApplicationContext(),
                                "Problème de connexion. Essayez plus tard"+response, Toast.LENGTH_SHORT).show();
                    }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                "ERREUR CONNEXION", Toast.LENGTH_SHORT).show();
                        Log.d("REPONSE ERREUR", error.toString());
                    }
                }
        );
        // add it to the RequestQueue
        queue.add(getRequest);
    }
}
