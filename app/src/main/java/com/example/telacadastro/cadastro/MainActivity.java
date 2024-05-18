package com.example.telacadastro.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.telacadastro.R;

public class MainActivity extends AppCompatActivity {
EditText txtNomeP, txtCpfP, txtDtNascimentoP,txtTelefoneP,txtEmailP;

EditText txtLogP,txtNumeroP,txtBairroP,txtCidadeP,txtCepP;

Button btnP, btnC;

Spinner spinEstadoP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNomeP= findViewById(R.id.razaoSocial);
        txtCpfP = findViewById(R.id.cnpj);
        txtDtNascimentoP = findViewById(R.id.nomeFantasia);
        txtTelefoneP = findViewById(R.id.telRest);
        txtEmailP = findViewById(R.id.emailRest);

        txtLogP = findViewById(R.id.ruaRest);
        txtNumeroP = findViewById(R.id.numRest);
        txtBairroP = findViewById(R.id.bairroRest);
        txtCidadeP = findViewById(R.id.cidadeRest);
        txtCepP = findViewById(R.id.cepRest);
        spinEstadoP = findViewById(R.id.spinnerEstRest);

        btnP = (Button) findViewById(R.id.btnProximo);
        btnC = (Button) findViewById(R.id.btnCancelar);


        String nomeP, cpfP,dtNascimentoP,telefoneP,emailP,ruaP,numeroP,bairroP,cidadeP,cepP,estadoP;

        String[] siglasEstados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
                "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

        // Adapter para o Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, siglasEstados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinEstadoP.setAdapter(adapter);


        nomeP= txtNomeP.getText().toString();
        cpfP =txtCpfP.getText().toString();
        dtNascimentoP =txtDtNascimentoP.getText().toString();
        telefoneP =txtTelefoneP.getText().toString();
        emailP = txtEmailP.getText().toString();
        ruaP = txtLogP.getText().toString();
        numeroP = txtNumeroP.getText().toString();
        bairroP  = txtBairroP.getText().toString();
        cidadeP = txtCidadeP.getText().toString();
        cepP = txtCepP.getText().toString();

        btnP.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, CadastroRest.class);
            startActivity(intent);
        });

        btnC.setOnClickListener(v -> {
            finish();
        });






    }
}