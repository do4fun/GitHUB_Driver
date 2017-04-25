package com.publiciteweb.mobile.github;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by sun on 17-04-11.
 */

public class ScreenSlidePageFragment extends Fragment {
    private WebView viewFicheJournaliere;
    private TextView txtDate;
    private ViewGroup rootView;

    public static ScreenSlidePageFragment newInstance(int differenceInDate){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        //sauvegarde le nombre des jours precedents de jour courant
        Bundle args = new Bundle();
        args.putInt("differenceInDate", (-1)*differenceInDate);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = (ViewGroup) inflater.inflate(
                R.layout.view_rapport, container, false);
        //affichage la date
        txtDate = (TextView) rootView.findViewById(R.id.txtDateFiche);
        Calendar dateCurrent = Calendar.getInstance();
        dateCurrent.add(Calendar.DATE,getArguments().getInt("differenceInDate"));
        String currentDateTimeString =
                DateFormat.getDateInstance().format(dateCurrent.getTime());
        txtDate.setText(currentDateTimeString);

        //affichage Fiche Journaliere
        viewFicheJournaliere = (WebView)rootView.findViewById(R.id.viewFicheJournaliere);
        viewFicheJournaliere.getSettings().setJavaScriptEnabled(true);
        viewFicheJournaliere.getSettings().setBuiltInZoomControls(true);
        viewFicheJournaliere.getSettings().setSupportZoom(true);
        viewFicheJournaliere.loadUrl(Driver.URL_DISPATCH+"fichejournaliere.html");
        return rootView;
    }
}
