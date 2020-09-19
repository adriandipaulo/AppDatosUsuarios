package com.adriandipaulo.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView nombreC;
    TextView pic;
    TextView tele;
    TextView email;
    TextView datosGeneral;
    String date;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button siguiente;
        nombreC= findViewById(R.id.tNombreCompleto);
        pic= findViewById(R.id.fechaNa);
        tele= findViewById(R.id.tTel);
        email= findViewById(R.id.tEmail);
        datosGeneral = findViewById(R.id.tDatosCompletos);

        Calendar calendar= Calendar.getInstance();
        final int año= calendar.get(calendar.YEAR);
        final int mes= calendar.get(calendar.MONTH);
        final int dia= calendar.get(calendar.DAY_OF_MONTH);
     pic.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             DatePickerDialog datePickerDialog= new DatePickerDialog(MainActivity.this,
                     android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                     setListener,año,mes,dia);
             datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
             datePickerDialog.show();

         }
     });
     setListener = new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
             mes +=1;
             date = dia + "/" + mes + "/" +año;
             pic.setText(date);

         }
     };
     siguiente= (Button) findViewById(R.id.butSguiente);
     siguiente.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent sIntent = new Intent(MainActivity.this,MostrarDatos.class);
             sIntent.putExtra("datos",date);
             sIntent.putExtra("nombreC",nombreC.getText().toString());
             sIntent.putExtra("telefono",tele.getText().toString());
             sIntent.putExtra("email",email.getText().toString());
             sIntent.putExtra("datosCom",datosGeneral.getText().toString());
             startActivity(sIntent);

         }
     });
    }
}