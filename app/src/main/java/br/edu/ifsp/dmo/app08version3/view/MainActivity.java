package br.edu.ifsp.dmo.app08version3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.edu.ifsp.dmo.app08version3.R;

public class MainActivity extends AppCompatActivity {

    private EditText[] editTexts;
    private RadioGroup radioGroup;
    private RadioButton aritmeticaRadioButton;
    private RadioButton ponderadaRadioButton;
    private RadioButton harmonicaRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts = new EditText[5];
        editTexts[0] = findViewById(R.id.editText1);
        editTexts[1] = findViewById(R.id.editText2);
        editTexts[2] = findViewById(R.id.editText3);
        editTexts[3] = findViewById(R.id.editText4);
        editTexts[4] = findViewById(R.id.editText5);

        radioGroup = findViewById(R.id.radioGroup);
        aritmeticaRadioButton = findViewById(R.id.aritmeticaRadioButton);
        ponderadaRadioButton = findViewById(R.id.ponderadaRadioButton);
        harmonicaRadioButton = findViewById(R.id.harmonicaRadioButton);

        Button calcularButton = findViewById(R.id.calcularButton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] valores = new double[5];
                for (int i = 0; i < 5; i++) {
                    valores[i] = Double.parseDouble(editTexts[i].getText().toString());
                }

                String tipoMedia = "";
                if (aritmeticaRadioButton.isChecked()) {
                    tipoMedia = "Média Aritmética";
                } else if (ponderadaRadioButton.isChecked()) {
                    tipoMedia = "Média Ponderada";
                } else if (harmonicaRadioButton.isChecked()) {
                    tipoMedia = "Média Harmônica";
                }

                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("valores", valores);
                intent.putExtra("tipoMedia", tipoMedia);
                startActivity(intent);
            }
        });
    }
}