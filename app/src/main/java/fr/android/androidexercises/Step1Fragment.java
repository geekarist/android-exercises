package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Step1Fragment extends Fragment {
    private View mNextButton;
    private OnNextStep1Listener onNextStep1Listener;
    private EditText mEditText;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onNextStep1Listener = (OnNextStep1Listener) context;
    }

    // Override onCreateViewMethod
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step1, container, false);
        mEditText = (EditText) view.findViewById(R.id.edit_text_step1);
        mNextButton = view.findViewById(R.id.nextButton1);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextStep1Listener.onNextStep1(mEditText.getText().toString());
            }
        });
        return view;
    }

    public interface OnNextStep1Listener {
        void onNextStep1(String s);
    }
}
