package com.df.calcuadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class calculadoraBasica extends AppCompatActivity implements View.OnClickListener {

    EditText txtValor1;
    EditText txtValor2;
    Button btnCalc;
    Spinner selectorOperador;
    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_basica);
        Intent intent = getIntent();
        nombreUsuario = intent.getStringExtra("nombre");
        txtValor1 = findViewById(R.id.TextValor1);
        txtValor2 = findViewById(R.id.TextValor2);
        btnCalc = findViewById(R.id.btnCalc);
        selectorOperador = findViewById(R.id.operacion);
        btnCalc.setOnClickListener(this);
        Toast.makeText(this, "Bienvenido: " + nombreUsuario, Toast.LENGTH_SHORT).show();
    }

    public Double calculadoraBasica(double valor1, double valor2, String operacion){
        double resultado = 0.0;
        switch (operacion){
            case "Suma":{
                resultado = valor1 + valor2;
                break;
            }
            case "Resta":{
                resultado = valor1 - valor2;
                break;
            }
            case "Multiplicacion":{
                resultado = valor1 * valor2;
                break;
            }
            case "Division":
                resultado = valor1 / valor2;
                break;
        }
        return resultado;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalc: {
                Double valor1 = Double.parseDouble(txtValor1.getText().toString());
                Double valor2 = Double.parseDouble(txtValor2.getText().toString());
                String operador = selectorOperador.getSelectedItem().toString();
                Double basic = calculadoraBasica(valor1, valor2, operador);
                Toast.makeText(this, "El resultado de la operación es: " + basic, Toast.LENGTH_LONG).show();
            }
        }
    }
}