package com.example.custom;


//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioButton radioButton;
    RadioGroup radioGroup;
    CheckBox cb1, cb2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (CheckBox) findViewById(R.id.checkBox3);
        cb2 = (CheckBox) findViewById(R.id.checkBox4);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder("");

                if (cb1.isChecked()) {
                    String s1 = cb1.getText().toString();
                    sb.append(s1);
                }

                if (cb2.isChecked()) {
                    String s2 = cb2.getText().toString();
                    sb.append("\n" + s2);

                }
                if (sb != null && !sb.toString().equals("")) {
                    Toast.makeText(getApplicationContext(), sb, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Nothing Selected", Toast.LENGTH_LONG).show();
                }

            }
        });
        final Button customButton = findViewById(R.id.custom_button);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    customButton.setEnabled(true);
                } else {
                    customButton.setEnabled(false);
                }
            }
        });
    }

    public void onclickbuttonMethod(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
        }

    }
}





