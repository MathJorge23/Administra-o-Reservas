package com.example.telacadastro.avaliacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.telacadastro.LoginRest;
import com.example.telacadastro.R;
import com.example.telacadastro.admin_reservas.Menu;
import com.example.telacadastro.admin_reservas.ReservasCanceladas;
import com.example.telacadastro.admin_reservas.ReservasConfirmadas;
import com.example.telacadastro.admin_reservas.ReservasPendentes;
import com.example.telacadastro.model.Reserva;
import com.example.telacadastro.recycler.ReservasAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AvaliacoesRecebidas extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Reserva> reservas;
    ReservasAdapter reservasAdapter;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    TextView btnEditar,  btnResConfirmadas, btnResCanceladas,btnResPentende,
            btnAvRecebidas, btnAvanPend, btnLogout, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacoes_recebidas);

        btnEditar = (TextView) findViewById(R.id.txtEditPerfil);
        btnResConfirmadas = (TextView) findViewById(R.id.txtResConfirmadas);
        btnResCanceladas = (TextView) findViewById(R.id.txtResRecusadas);
        btnResPentende = (TextView) findViewById(R.id.txtResPendentes);
        btnAvanPend = (TextView) findViewById(R.id.txtAvaPendentes);
        btnAvRecebidas = (TextView) findViewById(R.id.txtAvaRecebidas);
        btnLogout = (TextView) findViewById(R.id.txtLogout);
        btnAdmin = (TextView) findViewById(R.id.txtAdmin);


        reservas = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getApplicationContext(), LoginRest.class);
            startActivity(i);
            finish();
        });

        btnAvanPend.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this, AvaliacaoPendentes.class);
            startActivity(intent);
        });

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this, Menu.class);
            startActivity(intent);
        });

        btnResConfirmadas.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this, ReservasConfirmadas.class);
            startActivity(intent);
        });

        btnResCanceladas.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this,ReservasCanceladas.class);
            startActivity(intent);
        });

        btnResPentende.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this, ReservasPendentes.class);
            startActivity(intent);
        });

        btnAvRecebidas.setOnClickListener(v -> {
            Intent intent = new Intent( AvaliacoesRecebidas.this, AvaliacoesRecebidas.class);
            startActivity(intent);
        });
    }
    }
