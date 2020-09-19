package com.adriandipaulo.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    TextView mData;
    TextView mNombre;
    TextView mTel;
    TextView mMail;
    TextView mDatosC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        Bundle parametros = getIntent().getExtras();
        String data = parametros.getString("datos");
        String nombreC= parametros.getString("nombreC");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String datosCom = parametros.getString("datosCom");

         final Button editarDatos;
         mNombre = findViewById(R.id.mNombre);
         mTel = findViewById(R.id.mTel);
         mMail = findViewById(R.id.mMail);
         mDatosC = findViewById(R.id.mInfo);
         mData= findViewById(R.id.mData);
         mData.setText("Fecha de Nacimiento: " + data);
         mTel.setText("Tel: "+ telefono);
         mNombre.setText("Nombre: "+ nombreC);
         mMail.setText("Email: "  + email);
         mDatosC.setText("Descripción: " + datosCom);


        editarDatos= (Button) findViewById(R.id.editDatos);
        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent sIntent = new Intent(MostrarDatos.this,MainActivity.class);
               // startActivity(sIntent);
                // ENCOTRE METODO MEJOR SI HAGO FINISH REGRESO A AL ACTIVITY ANTERIOR CON LOS DATOS CARGADOS YA QUE QUEDO EN PAUSA
                finish();

            }

    });
}
}