package com.example.berenice.calculadora;

import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity implements OnClickListener{

    boolean decimal=false;
    boolean suma=false;
    boolean resta=false;
    boolean divi=false;
    boolean mult=false;
    boolean cambio=false;
    double [] numero=new double [20];
    double resultado;

    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button n0=(Button)findViewById(R.id.btn0);
        n0.setOnClickListener(this);
        Button n1=(Button)findViewById(R.id.btn1);
        n1.setOnClickListener(this);
        Button n2=(Button)findViewById(R.id.btn2);
        n2.setOnClickListener(this);
        Button n3=(Button)findViewById(R.id.btn3);
        n3.setOnClickListener(this);
        Button n4=(Button)findViewById(R.id.btn4);
        n4.setOnClickListener(this);
        Button n5=(Button)findViewById(R.id.btn5);
        n5.setOnClickListener(this);
        Button n6=(Button)findViewById(R.id.btn6);
        n6.setOnClickListener(this);
        Button n7=(Button)findViewById(R.id.btn7);
        n7.setOnClickListener(this);
        Button n8=(Button)findViewById(R.id.btn8);
        n8.setOnClickListener(this);
        Button n9=(Button)findViewById(R.id.btn9);
        n9.setOnClickListener(this);

        Button limpiar=(Button)findViewById(R.id.btnAc);
        limpiar.setOnClickListener(this);
        Button punto=(Button)findViewById(R.id.btnPunto);
        punto.setOnClickListener(this);
        Button sum=(Button)findViewById(R.id.btnSuma);
        sum.setOnClickListener(this);
        Button rest=(Button)findViewById(R.id.btnResta);
        rest.setOnClickListener(this);
        Button div=(Button)findViewById(R.id.btnDiv);
        div.setOnClickListener(this);
        Button igual=(Button)findViewById(R.id.btnIgual);
        igual.setOnClickListener(this);
        Button mul=(Button)findViewById(R.id.btnMul);
        mul.setOnClickListener(this);


    }

    private void setScreen(String message) {
        TextView tv = (TextView) findViewById(R.id.screen);
        tv.setText(message);
    }
    @Override
    public void onClick(View v) {

        TextView pantalla=(TextView)findViewById(R.id.texto);
        int seleccion=v.getId();
        String a=pantalla.getText().toString();
        String d="Error";
         try {
                switch (seleccion) {
                    case R.id.btn0:
                        pantalla.setText(a + "0");
                        break;
                    case R.id.btn1:
                        pantalla.setText(a + "1");
                        break;
                    case R.id.btn2:
                        pantalla.setText(a + "2");
                        break;
                    case R.id.btn3:
                        pantalla.setText(a + "3");
                        break;
                    case R.id.btn4:
                        pantalla.setText(a + "4");
                        break;
                    case R.id.btn5:
                        pantalla.setText(a + "5");
                        break;
                    case R.id.btn6:
                        pantalla.setText(a + "6");
                        break;
                    case R.id.btn7:
                        pantalla.setText(a + "7");
                        break;
                    case R.id.btn8:
                        pantalla.setText(a + "8");
                        break;
                    case R.id.btn9:
                        pantalla.setText(a + "9");
                        break;

                    case R.id.btnPunto:
                        if (decimal == false) {
                            pantalla.setText(a + ".");
                        } else {
                            return;
                        }
                        decimal = true;
                        break;
                    case R.id.btnAc:
                        pantalla.setText("");
                        decimal = false;
                        break;
                    case R.id.btnSuma:
                        suma = true;
                        numero[0] = Double.parseDouble(a);
                        pantalla.setText("");
                        decimal = false;
                        break;
                    case R.id.btnResta:
                        resta = true;
                        numero[0] = Double.parseDouble(a);
                        pantalla.setText("");
                        decimal = false;
                        break;
                    case R.id.btnDiv:
                        divi = true;
                        numero[0] = Double.parseDouble(a);
                        pantalla.setText("");
                        decimal = false;
                        break;
                    case R.id.btnMul:
                        mult = true;
                        numero[0] = Double.parseDouble(a);
                        pantalla.setText("");
                        decimal = false;
                        break;
                    case R.id.btnIgual:
                        numero[1] = Double.parseDouble(a);
                        if (suma == true) {
                            resultado = numero[0] + numero[1];
                            pantalla.setText(String.valueOf(resultado));
                        } else if (resta == true) {
                            resultado = numero[0] - numero[1];
                            pantalla.setText(String.valueOf(resultado));
                        } else if (mult == true) {
                            resultado = numero[0] * numero[1];
                            pantalla.setText(String.valueOf(resultado));
                        } else if (divi == true) {
                            if (numero[0] == 0 && numero[1] == 0) {
                                pantalla.setText(d);
                            } else if (numero[0] != 0 && numero[1] != 0) {
                                resultado = numero[0] / numero[1];
                                pantalla.setText(String.valueOf(resultado));
                            } else if (numero[0] != 0 && numero[1] == 0) {
                                pantalla.setText(d);
                            } else if (numero[0] == 0 && numero[1] == 1) {
                                pantalla.setText("0");
                            } else if (numero[0] == 0 && numero[1] != 0) {
                                pantalla.setText("0");
                            } else if (numero[0] == 1 && numero[1] == 0) {
                                pantalla.setText("No Existe");
                            }

                        }
                        decimal = false;
                        suma = false;
                        resta = false;
                        divi = false;
                        mult = false;
                        break;
                }
            } catch (Exception e) {
                pantalla.setText("ERROR");

            }
            ;
        }
    }

