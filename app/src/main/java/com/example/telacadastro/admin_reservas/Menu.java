package com.example.telacadastro.admin_reservas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telacadastro.avaliacao.AvaliacaoPendentes;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Reserva> reservas;
    ReservasAdapter reservasAdapter;

     FirebaseAuth mAuth;
     FirebaseFirestore db;

     EditText txtPeriodoIni, txtPeriodoFin,btnQtdReserva;

    TextView btnEditar,  btnResConfirmadas, btnResCanceladas,btnResPentende,
            btnAvRecebidas, btnAvanPend, btnLogout, btnConfirma,txtPeriodoAtual, txtQuantidadeDispo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnEditar = (TextView) findViewById(R.id.txtEditPerfil);
        btnResConfirmadas = (TextView) findViewById(R.id.txtResConfirmadas);
        btnResCanceladas = (TextView) findViewById(R.id.txtResRecusadas);
        btnResPentende = (TextView) findViewById(R.id.txtResPendentes);
        btnAvanPend = (TextView) findViewById(R.id.txtAvaPendentes);
        btnAvRecebidas = (TextView) findViewById(R.id.txtAvaRecebidas);
        btnLogout = (TextView) findViewById(R.id.txtLogout);

        btnConfirma = (TextView) findViewById(R.id.btnConfirmar);
        txtPeriodoIni = (EditText) findViewById(R.id.txtDataI);
        txtPeriodoFin = (EditText) findViewById(R.id.txtDataF);
        btnQtdReserva= (EditText) findViewById(R.id.qtdReserva);


        txtPeriodoAtual = (TextView) findViewById(R.id.periodoAtual);
        txtQuantidadeDispo = (TextView) findViewById(R.id.lugaresDisp);


        reservas = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();


        btnConfirma.setOnClickListener(v -> {
            // Pegar os valores dos EditTexts
            String dataInicioStr = txtPeriodoIni.getText().toString();
            String dataFimStr = txtPeriodoFin.getText().toString();

            // Converter as strings para datas
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date dataInicio = null;
            Date dataFim = null;
            try {
                dataInicio = dateFormat.parse(dataInicioStr);
                dataFim = dateFormat.parse(dataFimStr);
            } catch (ParseException e) {
                e.printStackTrace();
                // Exibir mensagem de erro se o formato da data estiver incorreto
                Toast.makeText(getApplicationContext(), "Formato de data inválido! Use dd/MM/yyyy.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verificar se as datas foram convertidas corretamente
            if (dataInicio != null && dataFim != null) {
                // Exibir mensagem de confirmação
                Toast.makeText(getApplicationContext(), "Envio confirmado com sucesso!", Toast.LENGTH_SHORT).show();

                // Atualizar os TextViews
                // Use dateFormat.format(dataInicio) e dateFormat.format(dataFim) para formatar as datas corretamente
                txtPeriodoAtual.setText("De: " + dateFormat.format(dataInicio) + " Até: " + dateFormat.format(dataFim));

                // Atualizar a quantidade disponível. Pegue o texto do EditText e defina no TextView
                txtQuantidadeDispo.setText(btnQtdReserva.getText().toString());
            } else {
                // Exibir mensagem de erro se as datas não forem válidas
                Toast.makeText(getApplicationContext(), "Por favor, insira datas válidas!", Toast.LENGTH_SHORT).show();
            }
        });


        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getApplicationContext(), LoginRest.class);
            startActivity(i);
            finish();
        });

        btnAvanPend.setOnClickListener(v -> {
            Intent intent = new Intent( Menu.this, AvaliacaoPendentes.class);
            startActivity(intent);
        });


        btnResConfirmadas.setOnClickListener(v -> {
            Intent intent = new Intent( Menu.this, ReservasConfirmadas.class);
            startActivity(intent);
        });

        btnResCanceladas.setOnClickListener(v -> {
            Intent intent = new Intent( Menu.this, ReservasCanceladas.class);
            startActivity(intent);
        });

        btnResPentende.setOnClickListener(v -> {
            Intent intent = new Intent( Menu.this, ReservasPendentes.class);
            startActivity(intent);
        });

        btnAvRecebidas.setOnClickListener(v -> {
            Intent intent = new Intent( Menu.this, AvaliacoesRecebidas.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
    public void buscarReservasPendentes() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("reservas")
                .whereEqualTo("status", "C") // Filtrar apenas as reservas com status "P"
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

                        }
                    }
                });
    }

    public void buscarReservasHoje() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("reservas")
                .whereEqualTo("data", "06/05/2024")//Filtrar com reservas para hoje
                .whereEqualTo("status","C")// Filtrar apenas as reservas com status "C"
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

                        }
                    }
                });
    }

    public void buscarReservasConfirmadas() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("reservas")
                .whereEqualTo("status", "C") // Filtrar apenas as reservas com status "P"
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