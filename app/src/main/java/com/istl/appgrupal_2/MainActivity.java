package com.istl.appgrupal_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtValorIngresado;
    private Spinner spnOpciones;
    private Button btnConvertir;
    private TextView txtRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        txtValorIngresado = (TextView) findViewById(R.id.txtValorIngresado);
        spnOpciones = (Spinner) findViewById(R.id.spnOpciones);
        btnConvertir = (Button) findViewById(R.id.btnConvertir);
        txtRespuesta = (TextView) findViewById(R.id.txtRespuesta);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public double CelsiusaFarenheit(){
        int celcius = Integer.valueOf(txtValorIngresado.getText().toString());
        celcius = celcius*2-celcius/5;
        celcius = celcius+32;
        return celcius;
    }

    public double CelsiusaKelvin(){
        int celcius =Integer.valueOf(txtValorIngresado.getText().toString());
        double result = celcius + 273.15;
        return result;
    }
    public void enviarresultado(){
        if(spnOpciones.getSelectedItemPosition()==0){
            txtRespuesta.setText("El resultado es : " +CelsiusaFarenheit() +"Grados Farenheit");
        }else{
            txtRespuesta.setText("El resultado es : " +CelsiusaKelvin() +"Grados Kelvin");
        }
    }
    @Override
    public void onClick(View v) {
        if (v==btnConvertir){
            if (txtValorIngresado.getText().toString().isEmpty()){
                txtValorIngresado.setError("Ingrese un valor");
            }else{
                enviarresultado();
            }
        }
    }
}
