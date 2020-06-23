package id.egin.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentFirst extends Fragment {
    private Button btnEvent;
    private EditText etFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String stringFromActivity;
    private Bundle bundle;

    public FragmentFirst() {
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
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnEvent = getActivity().findViewById(R.id.btnEvent);
        etFragment = getActivity().findViewById(R.id.et_fragment);

        bundle = this.getArguments();
        if(bundle != null) {
            stringFromActivity = bundle.getString("editTextActivity");
        }
        etFragment.setText(stringFromActivity);

        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // etFragment.setText("Event Invoked In Fragment");
                Bundle bundle1 = new Bundle();
                bundle1.putString("editTextFrag1", etFragment.getText().toString());

                FragmentSecond scnfragment = new FragmentSecond();
                scnfragment.setArguments(bundle1);
                fragmentTransaction.replace(R.id.ui_container, scnfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}