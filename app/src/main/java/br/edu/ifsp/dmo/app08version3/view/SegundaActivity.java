package br.edu.ifsp.dmo.app08version3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifsp.dmo.app08version3.R;
import br.edu.ifsp.dmo.app08version3.controller.DadosCalculo;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        double[] valores = intent.getDoubleArrayExtra("valores");
        String tipoMedia = intent.getStringExtra("tipoMedia");

        DadosCalculo dadosCalculo = new DadosCalculo(valores, tipoMedia);
        double resultado = dadosCalculo.calcularMedia();

        TextView resultadoTextView = findViewById(R.id.resultadoTextView);
        resultadoTextView.setText("Resultado: " + resultado);
    }
}