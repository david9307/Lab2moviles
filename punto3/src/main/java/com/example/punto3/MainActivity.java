package com.example.punto3;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



import static java.lang.Math.PI;

public class MainActivity extends AppCompatActivity {

    RadioButton r1, r2, r3, r4;
    TextView radio, lado, base, altura, lado1, lado2;
    EditText num1, num2, resultado;
    Button area;
    int control = 0;
    RadioGroup grupo;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radio = (TextView) findViewById(R.id.rad);
        lado = (TextView) findViewById(R.id.lado);
        lado1 = (TextView) findViewById(R.id.lado1);
        lado2 = (TextView) findViewById(R.id.lado2);
        base = (TextView) findViewById(R.id.bas);
        altura = (TextView) findViewById(R.id.altura);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        area = (Button) findViewById(R.id.calc);
        resultado = (EditText) findViewById(R.id.resul);
        grupo = (RadioGroup) findViewById(R.id.radio);
        lado.setVisibility(View.VISIBLE);
        base.setVisibility(View.INVISIBLE);
        num2.setVisibility(View.INVISIBLE);
        radio.setVisibility(View.INVISIBLE);
        altura.setVisibility(View.INVISIBLE);
        lado1.setVisibility(View.INVISIBLE);
        lado2.setVisibility(View.INVISIBLE);

        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float numl1 = 0, numl2 = 0, resul = 0;
                int error = 0;
                String validar1 = num1.getText().toString();
                String validar2 = num2.getText().toString();



                if (error == 0) {
                    switch (control) {
                        case 0:
                            if (TextUtils.isEmpty(validar1)) {
                                num1.setError("Error");

                            }
                            else {
                                numl1 = (float) Integer.parseInt(num1.getText().toString());
                                resul = numl1 * numl1;
                            }
                            break;
                        case 1:
                            if (TextUtils.isEmpty(validar1)) {
                                num1.setError("Error");

                            }
                            else {
                                numl1 = (float) Integer.parseInt(num1.getText().toString());
                                resul = numl1 * numl1 * (float) PI;
                            }
                            break;
                        case 2:
                            if (TextUtils.isEmpty(validar1)) {
                                num1.setError("Error");
                                error = 1;
                            }
                            if (TextUtils.isEmpty(validar2)) {
                                num2.setError("Error");
                                error = 1;
                            }

                            if(error==1){}
                            else {
                                numl1 = (float) Integer.parseInt(num1.getText().toString());
                                numl2 = (float) Integer.parseInt(num2.getText().toString());
                                resul = (numl1 * numl2) / 2;
                            }
                            break;
                        case 3:
                            if (TextUtils.isEmpty(validar1)) {
                                num1.setError("Error");
                                error = 1;
                            }
                            if (TextUtils.isEmpty(validar2)) {
                                num2.setError("Error");
                                error = 1;
                            }
                            if(error==1){}
                            else {
                                numl1 = (float) Integer.parseInt(num1.getText().toString());
                                numl2 = (float) Integer.parseInt(num2.getText().toString());
                                resul = numl1 * numl2;
                            }
                            break;
                    }

                    String mytext = Float.toString(resul);
                    resultado.setText(mytext);

                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    public void radiobuttonclicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd1:
                if (checked)
                    control = 0;
                lado.setVisibility(View.VISIBLE);
                base.setVisibility(View.INVISIBLE);
                num2.setVisibility(View.INVISIBLE);
                radio.setVisibility(View.INVISIBLE);
                altura.setVisibility(View.INVISIBLE);
                lado1.setVisibility(View.INVISIBLE);
                lado2.setVisibility(View.INVISIBLE);

                break;
            case R.id.rd2:
                if (checked)
                    control = 1;
                lado.setVisibility(View.INVISIBLE);
                base.setVisibility(View.INVISIBLE);
                num2.setVisibility(View.INVISIBLE);
                radio.setVisibility(View.VISIBLE);
                altura.setVisibility(View.INVISIBLE);
                lado1.setVisibility(View.INVISIBLE);
                lado2.setVisibility(View.INVISIBLE);

                break;
            case R.id.rd3:
                if (checked)
                    control = 2;
                lado.setVisibility(View.INVISIBLE);
                base.setVisibility(View.VISIBLE);
                num2.setVisibility(View.VISIBLE);
                radio.setVisibility(View.INVISIBLE);
                altura.setVisibility(View.VISIBLE);
                lado1.setVisibility(View.INVISIBLE);
                lado2.setVisibility(View.INVISIBLE);

                break;

            case R.id.rd4:
                if (checked)
                    control = 3;
                lado.setVisibility(View.INVISIBLE);
                base.setVisibility(View.INVISIBLE);
                num2.setVisibility(View.VISIBLE);
                radio.setVisibility(View.INVISIBLE);
                altura.setVisibility(View.INVISIBLE);
                lado1.setVisibility(View.VISIBLE);
                lado2.setVisibility(View.VISIBLE);

                break;
        }


    }

}
