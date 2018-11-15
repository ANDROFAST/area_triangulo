package com.androfast.pc.appcalcularareatriangulo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText altura;
    EditText base;
    Button calcular;
    TextView resultado;


    AlertDialog.Builder dialog;
    double area;
    DecimalFormat formato = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = (EditText) findViewById(R.id.edTxtAltura);
        base = (EditText) findViewById(R.id.edTxtBase);


        calcular = (Button) findViewById(R.id.btnCalcular);

        resultado = (TextView) findViewById(R.id.txtResultado);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calcular.getText().toString().equals("Limpiar")){
                    altura.setText("");
                    base.setText("");
                    resultado.setText("");
                    base.requestFocus();
                    calcular.setText("Calcular");
                }else{
                    if(altura.getText().toString().length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar la altura del triángulo");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                altura.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        if(base.getText().toString().length() == 0){
                            dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("Error");
                            dialog.setMessage("Ingresar la base del triángulo");
                            dialog.setCancelable(false);
                            dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo, int id) {
                                    dialogo.cancel();
                                    base.requestFocus();
                                }
                            });
                            dialog.show();
                        }else{
                            area = Double.parseDouble(altura.getText().toString()) * Double.parseDouble(base.getText().toString()) / 2;
                            resultado.setText("El área es: " + formato.format(area));
                            calcular.setText("Limpiar");
                        }
                    }
                }
            }
        });

    }
}
