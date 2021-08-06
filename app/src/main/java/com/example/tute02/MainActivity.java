package com.example.tute02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rd_btn_c;
    RadioButton rd_btn_f;
    Button btn_calculate;
    TextView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rd_btn_c = findViewById(R.id.rd_btn_c);
        rd_btn_f = findViewById(R.id.rd_btn_f);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_view = findViewById(R.id.tv_view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer() {
        Calculations cal = new Calculations();

        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please enter the temperature", Toast.LENGTH_SHORT).show();
        }else {

            Float temp = Float.parseFloat(value);

            if(rd_btn_c.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }else if (rd_btn_f.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp)L;
            }else  {
                Toast.makeText(this, "please select a radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }

            tv_view.setText(new Float(temp).toString());
        }

    }
}