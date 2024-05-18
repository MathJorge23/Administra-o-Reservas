package com.example.telacadastro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telacadastro.admin_reservas.Menu;
import com.example.telacadastro.cadastro.CadastroRest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginRest extends AppCompatActivity {

    Button btnEntrar, btnS, btnRegistrar;

    EditText email, senha;

    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_rest);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnRegistrar = (Button) findViewById(R.id.btnRegis);
        btnS = (Button) findViewById(R.id.btnSair);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);

        mAuth = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener(v -> {
            entrar();

        });

        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent (LoginRest.this, CadastroRest.class);
            startActivity(intent);
        });

        btnS.setOnClickListener(v -> {
            finish();
        });
    }

    public void entrar(){
        mAuth.signInWithEmailAndPassword(email.getText().toString(),senha.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(getApplicationContext(), Menu.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(LoginRest.this, "Falha na autenticação.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }//email : mathjor.silva@gmail.com senha 32131156Theco@

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(getApplicationContext(),Menu.class);
            startActivity(i);
            finish();
        }
    }

}