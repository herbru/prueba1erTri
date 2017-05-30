
package com.example.gabriel.prueba1ertri;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    int contIgnorados = 0;
    int contIguales = 0;
    int contChecked = 0;
    int caracTextoMasCorto = 999999;
    int contL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void procesar (View view){

        //declaro los elementos del layout
        EditText txtUno = (EditText)findViewById(R.id.txtUno);
        EditText txtDos = (EditText)findViewById(R.id.txtDos);
        CheckBox check = (CheckBox)findViewById(R.id.checkbox);

        //obtengo el contenido que ingreso el usuario en los textviews
        String textoUno = txtUno.getText().toString();
        String textoDos = txtDos.getText().toString();

        if (textoUno.length() == 0|| textoDos.length()== 0){
            //entra al if si el usuario no ingreso nada
            contIgnorados++;
            Toast.makeText(this, "No pueden haber campos vacios", Toast.LENGTH_SHORT).show();
        }
        else if(textoUno.compareTo("Fin") == 0 || textoDos.compareTo("Fin") == 0 ){
            //entra al if  si el usuario ingreso Fin
            //aca envio a la otra activity un bundle con los contadores a traves de un intent
            Bundle bundle = new Bundle();
            bundle.putInt("contIgnorados", contIgnorados);
            bundle.putInt("contCheckbox", contChecked);
            bundle.putInt("contMismoContenido", contIguales);
            bundle.putInt("caracTextoMasCorto", caracTextoMasCorto);
            bundle.putInt("contL", contL);
            Intent miIntent = new Intent(MainActivity.this, MuestroResultados.class);
            miIntent.putExtras(bundle);
            startActivity(miIntent);
        }
        else{
            //entra aca si el usuario no ingreso Fin e ingreso algo
            if (textoUno.compareTo(textoDos) == 0){
                //entra aca si los textos son iguales
                contIguales++;
            }
            if (check.isChecked()){
                //entra aca si el checkbox esta tildado
                contChecked++;
            }
            else {
                //entra aca si el checkbox esta destildado
                if (textoUno.length() < caracTextoMasCorto) {
                    //entra aca si el texto ingresado en el primer Edittext es el mas corto jamas ingresado
                    caracTextoMasCorto = textoUno.length();
                }
                if (textoDos.length() < caracTextoMasCorto) {
                    //entra aca si el texto ingresado en el segundo EditText es el mas corto jamas ingresado
                    caracTextoMasCorto = textoDos.length();
                }
            }
            //hago una repetitiva por texto ingresado y si el caracter en el que estoy parado es 'L' sumo uno al contador
            for (int i = 0; i < textoUno.length(); i++) {
                if (textoUno.charAt(i) == 'L') {
                    contL++;
                }
            }
            for (int i = 0; i < textoDos.length(); i++) {
                if (textoDos.charAt(i) == 'L') {
                    contL++;
                }
            }
        }
    }

}
