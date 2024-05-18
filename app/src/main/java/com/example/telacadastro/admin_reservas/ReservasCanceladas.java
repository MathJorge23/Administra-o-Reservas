package com.example.telacadastro.admin_reservas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.telacadastro.avaliacao.AvaliacoesRecebidas;
import com.example.telacadastro.LoginRest;
import com.example.telacadastro.R;
import com.example.telacadastro.model.Reserva;
import com.example.telacadastro.recycler.ReservasAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ReservasCanceladas extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Reserva> reservas;
    ReservasAdapter reservasAdapter;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    TextView btnEditar,  btnResConfirmadas, btnResCanceladas,btnResPentende,
            btnAvRecebidas, btnAvanPend, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_canceladas);

        btnEditar = (TextView) findViewById(R.id.txtEditPerfil);
        btnResConfirmadas = (TextView) findViewById(R.id.txtResConfirmadas);
        btnResCanceladas = (TextView) findViewById(R.id.txtResRecusadas);
        btnResPentende = (TextView) findViewById(R.id.txtResPendentes);
        btnAvanPend = (TextView) findViewById(R.id.txtAvaPendentes);
        btnAvRecebidas = (TextView) findViewById(R.id.txtAvaRecebidas);
        btnLogout = (TextView) findViewById(R.id.txtLogout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewReservas);
        reservas = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getApplicationContext(), LoginRest.class);
            startActivity(i);
            finish();
        });

        btnResConfirmadas.setOnClickListener(v -> {
            Intent intent = new Intent( ReservasCanceladas.this, ReservasConfirmadas.class);
            startActivity(intent);
        });

        btnResCanceladas.setOnClickListener(v -> {
            Intent intent = new Intent( ReservasCanceladas.this,ReservasCanceladas.class);
            startActivity(intent);
        });

        btnResPentende.setOnClickListener(v -> {
            Intent intent = new Intent( ReservasCanceladas.this, ReservasPendentes.class);
            startActivity(intent);
        });

        btnAvRecebidas.setOnClickListener(v -> {
            Intent intent = new Intent( ReservasCanceladas.this, AvaliacoesRecebidas.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        buscarReservasCanceladas();
    }

    public void buscarReservasCanceladas() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("reservas")
                .whereEqualTo("status", "E") // Filtrar apenas as reservas com status "P"
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            reservas.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Reserva reserva = document.toObject(Reserva.class);
                                reservas.add(reserva);
                            }
                            iniciarRecycler();
                        }
                    }
                });
    }

    public void iniciarRecycler(){
        LinearLayoutManager layout =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layout);
        reservasAdapter = new ReservasAdapter(reservas);
        recyclerView.setAdapter(reservasAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
    }
}