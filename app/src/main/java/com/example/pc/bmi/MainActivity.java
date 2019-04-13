package com.example.pc.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private EditText Name, Height, Weight;
    private TextView Result_txt;

    int size = 25;

    public void response(View view) {
        Name = findViewById(R.id.name_input);
        Height = findViewById(R.id.Height_input);
        Weight = findViewById(R.id.Weight_input);
        Result_txt = findViewById(R.id.Result);

        float height = Float.parseFloat(Height.getText().toString());
        float weight = Float.parseFloat(Weight.getText().toString());
        float BMI1 = calculateBMI(height, weight);
        String BMI2 = String.valueOf(BMI1);
        Result_txt.setTextSize(size);
        Result_txt.setText(Name.getText().toString() + " Hello~" + "\n" + "your BMI is " + BMI2);
        Toast.makeText(this, sandardBMI(BMI1), Toast.LENGTH_LONG).show();
    }

    private float calculateBMI(float h, float w) {
        float BMI = (float) (w / Math.pow((h / 100), 2));
        return BMI;
    }

    private String sandardBMI(double st) {
        String alert = "";
        if(st>25){
            alert = String.valueOf("You are too heavy ! ");
            getWindow().setBackgroundDrawableResource(R.drawable.fat);
        }
        else if (st<18.5){
            alert = String.valueOf("You are too slim! !!");
            getWindow().setBackgroundDrawableResource(R.drawable.good);
        }
        else{
            alert = String.valueOf("Your body is good !");
            getWindow().setBackgroundDrawableResource(R.drawable.nice);

        }


        return alert;
    }
}
