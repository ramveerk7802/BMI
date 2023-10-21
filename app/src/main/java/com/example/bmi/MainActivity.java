package com.example.bmi;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton btncalculate = findViewById(R.id.btncalculate);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat formatter =  new DecimalFormat("#.00");
                EditText edtheight = findViewById(R.id.edtheight);
                EditText edtweight = findViewById(R.id.edtweight);
                TextView txtResult = findViewById(R.id.txtResult);
                if(edtheight.getText().toString().equals("") || edtweight.getText().toString().equals("")){
                    txtResult.setText("Enter the data.");
                    return;
                }
                int height = Integer.parseInt(edtheight.getText().toString());
                int weight = Integer.parseInt(edtweight.getText().toString());
                if(height<=0 ||height>245 || weight<=0 || weight>200){
                    txtResult.setText("Invalid Data !");
                    return;
                }
                double ht = height/100.0;
                double bmi = weight/Math.pow(ht,2);
                if(bmi<18) {
                    txtResult.setText("Body Mass Index : " + formatter.format(bmi) + "\nYou are under Weight.");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.color_uw));
                    txtResult.setTextColor(getResources().getColor(R.color.white));
                }
                else if(bmi>25){
                    txtResult.setText("Body Mass Index : "+formatter.format(bmi)+"\nYou are over weight");
                    txtResult.setTextColor(getResources().getColor(R.color.white));
                    txtResult.setBackgroundColor(getResources().getColor(R.color.color_ow));
                }
                else {
                    txtResult.setText("Body Mass Index : " + formatter.format(bmi) + "\nYou are normal.");
                    txtResult.setBackgroundColor(getResources().getColor(R.color.color_normal));
                    txtResult.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }
}