package fr.android.androidexercises;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Step2Fragment extends Fragment {
    public static final String ARG_NAME_TEXT = "text";

    private TextView textView;

    public static Fragment newInstance(String s) {
        Step2Fragment step2Fragment = new Step2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", s);
        step2Fragment.setArguments(bundle);
        return step2Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step2, container, false);
        textView = (TextView) view.findViewById(R.id.text_step2);
        textView.setText(getArguments().getString(ARG_NAME_TEXT));
        return view;
    }
}
