package com.example.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2,res;
    Button calc;
    RadioGroup grupo;
    RadioButton r1,r2,r3,r4;

    int control=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        res=(EditText)findViewById(R.id.res);
        calc=(Button)findViewById(R.id.calc);
        r1=(RadioButton)findViewById((R.id.rd1));
        r2=(RadioButton)findViewById((R.id.rd2));
        r3=(RadioButton)findViewById((R.id.rd3));
        r4=(RadioButton)findViewById((R.id.rd4));
        grupo=(RadioGroup)findViewById(R.id.radio) ;


        calc.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                float numl1, numl2;
                float resul = 0;
                int error = 0;
                String validar1 = num1.getText().toString();
                String validar2 = num2.getText().toString();

                if (TextUtils.isEmpty(validar1)) {
                    num1.setError("Error");
                    error = 1;
                }

                if (TextUtils.isEmpty(validar2)) {
                    num2.setError("Error");
                    error = 1;
                }


                if (error == 0) {
                    switch (control) {
                        case 0:
                            numl1 = (float) Integer.parseInt(num1.getText().toString());
                            numl2 = (float) Integer.parseInt(num2.getText().toString());
                            resul = numl1 + numl2;
                            break;
                        case 1:
                            numl1 = (float) Integer.parseInt(num1.getText().toString());
                            numl2 = (float) Integer.parseInt(num2.getText().toString());
                            resul = numl1 - numl2;
                            break;
                        case 2:
                            numl1 = (float) Integer.parseInt(num1.getText().toString());
                            numl2 = (float) Integer.parseInt(num2.getText().toString());
                            resul = numl1 * numl2;
                            break;
                        case 3:
                            numl1 = (float) Integer.parseInt(num1.getText().toString());
                            numl2 = (float) Integer.parseInt(num2.getText().toString());
                            resul = numl1 / numl2;
                            break;
                    }
                    String mytext = Float.toString(resul);
                    res.setText(mytext);

                }
            }

        });
    }

    public void radiobuttonclicked(View view){


        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rd1:
                if (checked)
                    control=0;
                break;
            case R.id.rd2:
                if (checked)
                    control=1;
                break;
            case R.id.rd3:
                if (checked)
                    control=2;
                break;

            case R.id.rd4:
                if (checked)
                    control=3;
                break;
        }



    }

}


