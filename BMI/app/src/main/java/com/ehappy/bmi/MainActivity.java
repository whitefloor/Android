package com.ehappy.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText enterHeight,enterWwight;
    private Button bmiCount;
    private TextView txtBmi;
    double weight,height,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmiCount = (Button)findViewById(R.id.bmiCount);
        bmiCount.setOnClickListener(listener);
        enterHeight = (EditText)findViewById(R.id.enterHeight);
        enterWwight = (EditText)findViewById(R.id.enterWeight);
        txtBmi = (TextView)findViewById(R.id.txtBmi);

    }

    private Button.OnClickListener listener = new Button.OnClickListener(){
        public void onClick(View v){
            height = Double.parseDouble(enterHeight.getText().toString());
            weight = Double.parseDouble(enterWwight.getText().toString());

            bmi = weight / (height*height);
            String bmiString = Double.toString(bmi);
            txtBmi.setText(bmiString);

            if(bmi<=18){
                Toast.makeText(MainActivity.this, R.string.underweight,Toast.LENGTH_LONG).show();
            }else if (bmi>18 && bmi<25){
                Toast.makeText(MainActivity.this,R.string.moderateweight ,Toast.LENGTH_LONG ).show();
            }else {
                Toast.makeText(MainActivity.this,R.string.overweight ,Toast.LENGTH_LONG ).show();
            }
        }
    };

    public boolean onCreateOptionsMenu(Menu menu){
        return super.onCreateOptionsMenu(menu);
    }

}

