package com.deitel.twittersearches;

import android.app.Activity;
import android.app.ListFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FirstFragment extends ListFragment {


    private ArrayAdapter<String> adapter; // binds tags to ListView

    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
   public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        MainActivity pActivity = (MainActivity) getActivity();
        getListView().setOnItemLongClickListener(pActivity.getOnItemLongClickListener());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity pActivity = (MainActivity) getActivity();
        adapter=pActivity.getAdapter();
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.transferToSecondFragment(uri);
        }
    }*/
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String tag = (String) ((TextView) v).getText();
        if (mListener != null) {
            mListener.transferToSecondFragment(tag);
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void transferToSecondFragment(String url);
    }

}
