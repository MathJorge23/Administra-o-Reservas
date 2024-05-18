package com.example.telacadastro.recycler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telacadastro.R;
import com.example.telacadastro.model.Reserva;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasHolder> {
    private final List<Reserva> reservas;

    public ReservasAdapter(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @NonNull
    @Override
    public ReservasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReservasHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itens_reservas,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReservasHolder holder, int position) {
        Reserva reserva = reservas.get(position);
        holder.txtNome.setText(reserva.getNome());
        holder.txtQtdPess.setText(reserva.getQtdpessoas());
        holder.txtData.setText(reserva.getData());
        holder.txtHora.setText(reserva.getHora());

        // Configurar o clique do botão Confirmar
        holder.btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você pode implementar a lógica para confirmar a reserva
                // por exemplo, chamar um método na sua atividade ou fragmento para lidar com isso
                // algo como:
                // mListener.onConfirmarClicked(reserva);
            }
        });

        // Configurar o clique do botão Cancelar
        holder.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você pode implementar a lógica para cancelar a reserva
                // por exemplo, chamar um método na sua atividade ou fragmento para lidar com isso
                // algo como:
                // mListener.onCancelarClicked(reserva);
            }
        });

        // Configurar o clique do botão Editar
        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você pode implementar a lógica para editar a reserva
                // por exemplo, chamar um método na sua atividade ou fragmento para lidar com isso
                // algo como:
                // mListener.onEditarClicked(reserva);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservas != null ? reservas.size() : 0;
    }

    // Método para atualizar o status da reserva para "C" no Firestore
    private void atualizarStatusReservaParaConcluido(Reserva reserva) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference reservaRef = db.collection("reservas").document(reserva.getId());

        // Crie um mapa para armazenar os novos valores que serão atualizados no documento
        Map<String, Object> updates = new HashMap<>();
        updates.put("status", "C"); // Atualize o campo "status" para "C"

        // Atualize o documento da reserva no Firestore
        reservaRef.update(updates)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Atualização bem-sucedida
                        // Você pode lidar com isso conforme necessário, como atualizar o RecyclerView
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Trate falhas na atualização, se necessário
                    }
                });
    }
}



