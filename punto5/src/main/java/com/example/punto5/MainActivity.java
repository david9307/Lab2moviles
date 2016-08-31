package com.example.punto5;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner lista;
    EditText txt,persona,password1,password2,email;
    String[] datos={"Ciudades","Medellin","Bogota","Barranquilla"};
    TextView mostrar,ciudad,gustos;
    String sexo="Femenino",ciud,dat="nada";
    String[] gusto;
    Button enviar,fecha;
    DatePicker datePicker;
    TextView dateView;
    RadioButton r1,r2;
    CheckBox r3,r4,r5,r6;
    int control=0;
    ArrayList<String> vec = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persona=(EditText)findViewById(R.id.person);
        password1=(EditText)findViewById(R.id.passw);
        password2=(EditText)findViewById(R.id.passw2);
        email=(EditText)findViewById(R.id.email);
        r1=(RadioButton)findViewById(R.id.rd1);
        r2=(RadioButton)findViewById(R.id.rd2);
        r3=(CheckBox) findViewById(R.id.correr);
        r4=(CheckBox) findViewById(R.id.dormir);
        r5=(CheckBox) findViewById(R.id.pasear);
        r6=(CheckBox) findViewById(R.id.nadar);
        enviar=(Button)findViewById(R.id.enviar);
        lista=(Spinner)findViewById(R.id.ciudades_spinner);
        datePicker=(DatePicker)findViewById(R.id.date);
        fecha=(Button)findViewById(R.id.fecha);
        txt=(EditText)findViewById(R.id.txtdate);
        mostrar=(TextView)findViewById(R.id.mostrar);
        ciudad=(TextView)findViewById(R.id.ciudad);
        gustos=(TextView)findViewById(R.id.gustos);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
        lista.setAdapter(adapter);

        datePicker.setVisibility(View.INVISIBLE);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String validar1 = persona.getText().toString();
                String validar2= password1.getText().toString();
                String validar3= password2.getText().toString();
                String validar4= email.getText().toString();
                String validar5= txt.getText().toString();
                String comp="nada";
                int look=0,error=0;

                if(TextUtils.isEmpty(validar1)) {
                    persona.setError("Error");
                    error=1;
                }

                if(TextUtils.isEmpty(validar3)) {
                    password2.setError("Error");
                    error=1;
                    look=1;
                }
                if(look==0) {
                    if (validar2.equals(validar3)){

                    }
                    else{
                        error=1;
                    }


                }

                if(TextUtils.isEmpty(validar4)) {
                    email.setError("Error");
                    error=1;
                }

                if(TextUtils.isEmpty(validar2)) {
                    password1.setError("Error");
                    error=1;
                    look=1;
                }



                if(dat.equals(comp)){
                    error=1;
                    txt.setError("Error");
                }

                if(ciud.equals("Ciudades")){
                    error=1;
                    ciudad.setError("Error");
                }

                if(error==1){

                    mostrar.setText("Uno o mas campos son incorrectos");

                }
                else{

                   mostrar.setText("Su registro ha sido exitoso"
                   + Html.fromHtml("<br />")+"Usuario"+":"+validar1+Html.fromHtml("<br />")+"Correo"+
                           ":"+validar4+Html.fromHtml("<br />")+"Gustos"+":"+vec+Html.fromHtml("<br />")+
                           "Fecha nacimiento"+":"+validar5+Html.fromHtml("<br />")+"Sexo"+":"+sexo+
                           Html.fromHtml("<br />")+"Ciudad"+":"+ciud);

                }
            }
        });


        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mes=datePicker.getMonth();
                int año=datePicker.getYear();
                int dia=datePicker.getDayOfMonth();
                String data=dia+"/"+mes+"/"+año;
                dat=data;
                txt.setText(data);
                datePicker.setVisibility(View.INVISIBLE);
                r3.setVisibility(View.VISIBLE);
                r4.setVisibility(View.VISIBLE);
                r5.setVisibility(View.VISIBLE);
                r6.setVisibility(View.VISIBLE);
                enviar.setVisibility(View.VISIBLE);
                lista.setVisibility(View.VISIBLE);
                ciudad.setVisibility(View.VISIBLE);
                gustos.setVisibility(View.VISIBLE);
                if(dat.equals("nada")){

                }
                else{
                    txt.setError(null);
                }
            }
        });


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
                r3.setVisibility(View.INVISIBLE);
                r4.setVisibility(View.INVISIBLE);
                r5.setVisibility(View.INVISIBLE);
                r6.setVisibility(View.INVISIBLE);
                enviar.setVisibility(View.INVISIBLE);
                lista.setVisibility(View.INVISIBLE);
                ciudad.setVisibility(View.INVISIBLE);
                gustos.setVisibility(View.INVISIBLE);

            }
        });

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ciud=datos[position];
                if(ciud.equals("Ciudades")){

                }
                else{
                    ciudad.setError(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void radiobuttonclicked(View view){


        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rd1:
                if (checked)
                    sexo="Femenino";
                break;
            case R.id.rd2:
                if (checked)
                    sexo="Masculino";
                break;


        }



    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();


        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.correr:
                if (checked)
                vec.add("Correr");
                else
                    vec.remove("Correr");
                break;
            case R.id.dormir:
                if (checked)
                    vec.add("Dormir");
                else
                vec.remove("Dormir");
                break;

            case R.id.pasear:
                if (checked)
                    vec.add("Pasear");
                else
                    vec.remove("Pasear");
                    break;

            case R.id.nadar:
                if (checked)
                    vec.add("Nadar");
                else
                vec.remove("Nadar");
                    break;
        }
    }
}
