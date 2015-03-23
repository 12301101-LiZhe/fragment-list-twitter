package com.deitel.twittersearches;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "tag";


    // TODO: Rename and change types of parameters
    private String tag;

    private TextView textview;
    private static final String SEARCHES = "searches";
    private SharedPreferences savedSearches;

    private WebView webview;
    private Handler mHandler;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String tag) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, tag);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tag = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        textview = (TextView)view.findViewById(R.id.tagTextView);
        webview = (WebView)view.findViewById(R.id.webView);

        webview.getSettings().setJavaScriptEnabled(true);

        savedSearches = getActivity().getSharedPreferences(SEARCHES, Context.MODE_PRIVATE);
        String url = getString(R.string.searchURL) + savedSearches.getString(tag, "");
        textview.setText(tag);
        webview.loadUrl(url);
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false);
    }


}
