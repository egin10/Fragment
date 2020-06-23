package id.egin.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etActivity;
    private Button btnActivity;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etActivity = findViewById(R.id.editTextActivity);
        btnActivity = findViewById(R.id.btnActivity);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void btnActivityClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("editTextActivity", etActivity.getText().toString());

        FragmentFirst newfragment = new FragmentFirst();
        newfragment.setArguments(bundle);
        fragmentTransaction.add(R.id.ui_container, newfragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
         btnActivity.setEnabled(false);
    }
}