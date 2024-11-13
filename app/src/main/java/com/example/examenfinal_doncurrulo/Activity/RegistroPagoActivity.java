package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examenfinal_doncurrulo.R;

import java.util.Random;

public class RegistroPagoActivity extends AppCompatActivity {

    EditText numerotar,ccv,nombrepro,fecha;
    ConstraintLayout repago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pago);

        EditText numerotar = findViewById(R.id.numerotar);
        EditText ccv = findViewById(R.id.ccv);
        EditText nombrepro = findViewById(R.id.nombrepro);
        EditText fecha = findViewById(R.id.fecha);
        ConstraintLayout repago = findViewById(R.id.regreso);

        // Validar los campos al hacer clic en el botón
        repago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numTarjeta = numerotar.getText().toString().trim();
                String codigoCcv = ccv.getText().toString().trim();
                String nombrePersona = nombrepro.getText().toString().trim();
                String fechaVencimiento = fecha.getText().toString().trim();

                // Validar que todos los campos estén completos
                if (numTarjeta.isEmpty() || codigoCcv.isEmpty() || nombrePersona.isEmpty() || fechaVencimiento.isEmpty()) {
                    // Mostrar un mensaje de error si algún campo está vacío
                    Toast.makeText(getApplicationContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                }// Validar el formato del número de tarjeta
                    else if (!numTarjeta.matches("^\\d{16}$")) {
                        numerotar.setError("Por favor ingrese un número de tarjeta válido");
                        return;
                    }

                    // Validar el formato del código CCV
                    else if (!codigoCcv.matches("^\\d{3}$")) {
                        ccv.setError("Por favor ingrese un código CCV válido");
                        return;
                    }

                    // Validar que el nombre de la persona no contenga números o caracteres especiales
                    else if (!nombrePersona.matches("^[a-zA-Z ]+$")) {
                        nombrepro.setError("Por favor ingrese un nombre válido");
                        return;
                    }

                    // Validar el formato de la fecha de vencimiento
                    else if (!fechaVencimiento.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
                        fecha.setError("Por favor ingrese una fecha de vencimiento válida (MM/YY)");
                        return;
                    }else {
                        // Generar un código de pago aleatorio y mostrarlo en un Toast
                    String codigo = generarCodigoPago();
                    Toast.makeText(getApplicationContext(), "Código de pago: " + codigo, Toast.LENGTH_SHORT).show();
                    // Si todo está bien, redirigir al usuario a otro activity
                    Intent intent = new Intent(getApplicationContext(), PagoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    // Generar un código de pago aleatorio
    private String generarCodigoPago() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

}