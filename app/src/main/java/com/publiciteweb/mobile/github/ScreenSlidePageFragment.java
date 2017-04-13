package com.publiciteweb.mobile.github;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sun on 17-04-11.
 */

public class ScreenSlidePageFragment extends Fragment {
    private WebView viewFicheJournaliere;
    private TextView txtDate;
    private ViewGroup rootView;
    private String urlFicheJournaliere = "http://10.0.2.2:80/ProjetFinal/fichejournaliere.html";
    private static int differenceDayInDate;

    public static ScreenSlidePageFragment newInstance(int differenceInDate){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        differenceDayInDate = differenceInDate;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.view_rapport, container, false);

        txtDate = (TextView) rootView.findViewById(R.id.txtDateFiche);
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        txtDate.setText(currentDateTimeString);

        viewFicheJournaliere = (WebView)rootView.findViewById(R.id.viewFicheJournaliere);
        viewFicheJournaliere.getSettings().setJavaScriptEnabled(true);
        viewFicheJournaliere.getSettings().setBuiltInZoomControls(true);
        viewFicheJournaliere.getSettings().setSupportZoom(true);
        viewFicheJournaliere.loadUrl(urlFicheJournaliere);
        return rootView;
    }

}
