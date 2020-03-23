package com.matheussilas.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editHeight, editWeight;
    TextView txtTotal, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        txtTotal = findViewById(R.id.txtTotal);
        txtResult = findViewById(R.id.txtResult);

    }

    public void calculateIMC(View view) {
        calculate();
    }

    public void calculate() {
        String Height = editHeight.getText().toString();
        String Weight = editWeight.getText().toString();

        DecimalFormat format = new DecimalFormat("0.00");

        if (Height.equals("") || Height == null) {
            Toast.makeText(getApplicationContext(), "Preencher o campo altura", Toast.LENGTH_LONG).show();
        } else if (Weight.equals("") || Weight == null) {
            Toast.makeText(getApplicationContext(), "Preencha o campo peso", Toast.LENGTH_LONG).show();
        } else {
            Double HeightCalculate = Double.parseDouble(Height);
            Double WeightCalculate = Double.parseDouble(Weight);

            Double total = WeightCalculate / (HeightCalculate * HeightCalculate);

            if (total < 16.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Magreza Grave");
            } else if (total < 17.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Magreza Moderada");
            } else if (total < 18.50) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Magreza Leve");
            } else if (total < 25.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Saudável");
            } else if (total < 30.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Sobrepeso");
            } else if (total < 35.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Obesidade Grau 1");
            } else if (total < 40.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Obesidade Grau 2");
            } else if (total > 40.00) {
                txtTotal.setText(format.format(total));
                txtResult.setText("Obesidade Grau 2");
            }
        }
    }
}