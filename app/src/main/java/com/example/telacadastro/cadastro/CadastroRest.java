package com.example.telacadastro.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.telacadastro.R;

public class CadastroRest extends AppCompatActivity {

    EditText txtNomeRest, txtNomeFat, txtCnpj, txtTelRest, txtEmailRest;
    EditText txtRuaRest, txtBairroRest, txtCidadeRest, txtCepRest, txtEstRest, txtNumRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rest);

        txtNomeRest = findViewById(R.id.razaoSocial);
        txtNomeFat = findViewById(R.id.nomeFantasia);
        txtCnpj = findViewById(R.id.cnpj);
        txtTelRest = findViewById(R.id.telRest);
        txtEmailRest = findViewById(R.id.emailRest);

        txtRuaRest = findViewById(R.id.ruaRest);
        txtBairroRest = findViewById(R.id.bairroRest);
        txtCidadeRest = findViewById(R.id.cidadeRest);
        txtCepRest = findViewById(R.id.cepRest);
        txtNumRest = findViewById(R.id.numRest);
    }
}