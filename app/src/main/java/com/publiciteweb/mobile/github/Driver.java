package com.publiciteweb.mobile.github;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Driver extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbarGestion;
    private EditText input_nameUser;
    private EditText input_password;
    private Button btnConnexion;
    private String urlForConnection;
    protected static final String URL_DISPATCH =
            "http://10.0.2.2:80/GitHub/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        readContenApp();
    }

    protected void readContenApp(){
        toolbarGestion = (Toolbar)findViewById(R.id.toolbarGestion);
        toolbarGestion.setNavigationIcon(R.drawable.logo2);
        setSupportActionBar(toolbarGestion);
        getSupportActionBar().setTitle("GitHub Dispatch");

        input_nameUser = (EditText)findViewById(R.id.input_nameUser);
        input_password = (EditText)findViewById(R.id.input_password);

        btnConnexion = (Button)findViewById(R.id.btn_login);
        btnConnexion.setOnClickListener(this);
    }

    //clique sur Connexion
    @Override
    public void onClick(View v) {
        connection();
    }

    public void connection() {
        //sauvegarde les données entrées pas l'utilisateur Dispatch
        String username = input_nameUser.getText().toString().trim();
        String passw = input_password.getText().toString().trim();
        //creation requete Volley avec méthode GET
        RequestQueue queue = Volley.newRequestQueue(this);
        urlForConnection = URL_DISPATCH + "session.php?username=" + username
                + "&passw=" + passw + "&sessionid=";
        Log.d("RESULTAT ", urlForConnection);
        StringRequest getRequest = new StringRequest(Request.Method.GET, urlForConnection,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("REPONSE+1", response);
                        try {
                            if (!response.contains("Error:") && !response.contains("NOK") ) {
                                JSONArray jsonReponseArray = new JSONArray(response);
                                JSONObject jsonReponse = jsonReponseArray.getJSONObject(0);

                                Intent intentDriver = new Intent(Driver.this, Activity_driver.class);
                                intentDriver.putExtra("username", input_nameUser.getText().toString().trim());
                                intentDriver.putExtra("passw", input_password.getText().toString().trim());
                                intentDriver.putExtra("sessionid", jsonReponse.getString("sessionid"));
                                intentDriver.putExtra("userid", jsonReponse.getString("userid"));
                                startActivity(intentDriver);
                            } else {
                                Log.d("REPONSE+2",response);
                                Toast.makeText(getApplicationContext(),"Verifier les données", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException ex){
                            ex.printStackTrace();
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
