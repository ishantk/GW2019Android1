package com.auribises.gw2019android1;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerFragment extends Fragment implements MyListener{

    WebView webView;

    public LowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lower, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        webView = view.findViewById(R.id.webView);

        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);

        webView.getSettings().setJavaScriptEnabled(true);

        String url = "https://zeenews.india.com/";

//        Toast.makeText(getActivity(), "Webview Loaded", Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(), "WebView Loaded with "+url, Toast.LENGTH_LONG).show();

        webView.loadUrl(url);

    }

    @Override
    public void onClick(int position, String url) {

        Toast.makeText(getContext(), "WebView Loaded with "+url+" Position: "+position, Toast.LENGTH_LONG).show();
        webView.loadUrl(url);

    }
}
