package id.egin.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSecond extends Fragment {
    private Button btnFragment2;
    private TextView tvFragment2;
    private String stringFromFrag1;
    private Bundle bundle;

    public FragmentSecond() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvFragment2 = getActivity().findViewById(R.id.tvFragment2);
        btnFragment2 = getActivity().findViewById(R.id.btnFragment2);

        bundle = this.getArguments();
        if(bundle != null) {
            stringFromFrag1 = bundle.getString("editTextFrag1");
        }
        tvFragment2.setText(stringFromFrag1);

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tlp = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + stringFromFrag1));
                startActivity(tlp);
            }
        });
    }
}