package com.example.gabriel.prueba1ertri;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MuestroResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muestro_resultados);

        //obtengo los textview por id
        TextView lblCantIgnorados = (TextView)findViewById(R.id.lblCantIgnorados);
        TextView lblCantMismoContenido = (TextView)findViewById(R.id.lblCantMismoContenido);
        TextView lblCantCheckbox = (TextView)findViewById(R.id.lblCantCheckbox);
        TextView lblCaracTextoMasCorto = (TextView)findViewById(R.id.lblCaracTextoMasCorto);
        TextView lblCantL = (TextView)findViewById(R.id.lblCantL);

        // creo un bundle y recibo los valores del bundle a traves del intent y se los asigno a variables
        Bundle datosRecibidos = this.getIntent().getExtras();
        int CantIgnorados = datosRecibidos.getInt("contIgnorados");
        int CantMismoContenido = datosRecibidos.getInt("contMismoContenido");
        int CantCheckbox = datosRecibidos.getInt("contCheckbox");
        int caracTextoMasCorto = datosRecibidos.getInt("caracTextoMasCorto");
        int CantL = datosRecibidos.getInt("contL");

        //concateno los valores de las variables para mostrar
        lblCantIgnorados.setText("Se ingnoro el ingreso " + Integer.toString(CantIgnorados)+ " veces");
        lblCantMismoContenido.setText("Se ingreso el mismo contenido " + Integer.toString(CantMismoContenido) + " veces");
        lblCantCheckbox.setText("Se tildo el checkbox " + Integer.toString(CantCheckbox) + " veces");
        lblCaracTextoMasCorto.setText("El texto mas corto tenia " + Integer.toString(caracTextoMasCorto) + " caracteres");
        lblCantL.setText("Se ingreso la L " + Integer.toString(CantL) + " veces");
    }
}
