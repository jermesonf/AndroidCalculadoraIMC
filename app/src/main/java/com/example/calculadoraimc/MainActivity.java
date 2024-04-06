package com.example.calculadoraimc;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //@Autor JERMESON FERREIRA

    //definindo os tipos e variaveis
    TextView txtResultado;
    EditText txtAltura, txtPeso;
    ImageView img;
    double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //vinculando o Java com o android
        txtResultado = findViewById(R.id.txtResultado);
        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        img = findViewById(R.id.img);

        img.setImageResource(R.drawable.imc); //Definir imagem no ImageView (R = diretorio res)

    };

        public void calculo()
        {
            double altura = Double.parseDouble(txtAltura.getText().toString());
            double peso = Double.parseDouble(txtPeso.getText().toString());

            imc = peso / (altura * altura);
        }


        public void mostre(View v){

            calculo();
            String imcResultadoForrmatado = String.format("%.2f", imc); //formatando o valor para 2 casas decimais depois da virgula

            try {


                if (imc < 16) {
                    txtResultado.setText("Baixo peso (Grau I): " + imcResultadoForrmatado);
                } else if (imc >= 16 && imc <= 16.99) {
                    txtResultado.setText("Baixo peso (Grau II): " + imcResultadoForrmatado);
                } else if (imc >= 17 && imc <= 18.49) {
                    txtResultado.setText("Baixo peso (Grau III): " + imcResultadoForrmatado);
                } else if (imc >= 18.50 && imc <= 24.99) {
                    txtResultado.setText("Peso adequado: " + imcResultadoForrmatado);
                } else if (imc >= 25 && imc <= 29.99) {
                    txtResultado.setText("Sobrepeso: " + imcResultadoForrmatado);
                } else if (imc >= 30 && imc <= 34.99) {
                    txtResultado.setText("Obesidade (Grau I): " + imcResultadoForrmatado);
                } else if (imc >= 35 && imc <= 39.99) {
                    txtResultado.setText("Obesidade (Grau II): " + imcResultadoForrmatado);
                } else {
                    txtResultado.setText("Obesidade (Grau III): " + imcResultadoForrmatado);
                }
            }
            catch(Exception erro)
            {
                //try catch = tratamento de erros
            }

        }//fim metódo mostre


}//ultima chave