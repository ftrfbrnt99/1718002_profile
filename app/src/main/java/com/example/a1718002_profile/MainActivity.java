package com.example.a1718002_profile;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button profilebtn;
    TextView tgl_lahir,add,mhs,tlp;
    Spinner mLanguage;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        tgl_lahir = (TextView) findViewById(R.id.tgl_lahir);
        add = (TextView) findViewById(R.id.add);
        mhs = (TextView) findViewById(R.id.mhs);
        tlp = (TextView) findViewById(R.id.tlpn);
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else {
            mLanguage.setSelection(mAdapter.getPosition("Indonesia"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();
                        tgl_lahir.setText(resources.getString(R.string.born));
                        add.setText(resources.getString(R.string.address));
                        mhs.setText(resources.getString(R.string.knowledge));
                        tlp.setText(resources.getString(R.string.phone));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "in");
                        resources = context.getResources();
                        tgl_lahir.setText(resources.getString(R.string.born));
                        add.setText(resources.getString(R.string.address));
                        mhs.setText(resources.getString(R.string.knowledge));
                        tlp.setText(resources.getString(R.string.phone));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}
