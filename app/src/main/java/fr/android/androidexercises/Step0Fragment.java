package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Step0Fragment extends Fragment {

    private static final String step0 = "This is step 0";

    private TextView textView;
    private OnNextStep0Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // cast context to listener
        listener = (OnNextStep0Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step0, container, false);
        // findViewById textView (TextView)
        textView = (TextView) view.findViewById(R.id.textView);
        // findViewById nextButton (Button)
        View nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call onNext() from listener
                listener.onNextStep0();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // setText(step0)
        textView.setText(R.string.hello0);
    }

    public interface OnNextStep0Listener {
        void onNextStep0();
    }
}
