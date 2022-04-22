package com.df.calcuadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCalculadoraIMC;
    private Button btnConversorUnidades;
    private Button btnCalculadoraGeneral;
    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculadoraIMC = findViewById(R.id.btnCalcularImc);
        btnConversorUnidades = findViewById(R.id.btnTemperatura);
        btnCalculadoraGeneral = findViewById(R.id.btnCalculadora);
        txtNombre = findViewById(R.id.txtNombreUsuario);
        btnCalculadoraIMC.setOnClickListener(this);
        btnConversorUnidades.setOnClickListener(this);
        btnCalculadoraGeneral.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnCalcularImc:
                intent = new Intent(this, calcImc.class);
                intent.putExtra("nombre", txtNombre.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnTemperatura:
                intent = new Intent(this, conversorTemp.class);
                intent.putExtra("nombre", txtNombre.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnCalculadora:
                intent = new Intent(this, calculadoraBasica.class);
                intent.putExtra("nombre", txtNombre.getText().toString());
                startActivity(intent);
                break;
        }
    }
}