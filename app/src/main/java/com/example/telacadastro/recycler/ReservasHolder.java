package com.example.telacadastro.recycler;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.telacadastro.R;

public class ReservasHolder extends RecyclerView.ViewHolder {

    protected TextView txtNome, txtQtdPess,txtData, txtHora;

    protected ImageButton btnConfirmar, btnCancelar, btnEditar;

    public ReservasHolder(View itemView){
        super(itemView);

        txtNome = (TextView) itemView.findViewById(R.id.textNome);
        txtQtdPess = (TextView) itemView.findViewById(R.id.txtQtdPessoas);
        txtData = (TextView) itemView.findViewById(R.id.textData);
        txtHora = (TextView) itemView.findViewById(R.id.textHora);
        btnConfirmar = (ImageButton) itemView.findViewById(R.id.btnConfRes);
        btnCancelar = (ImageButton) itemView.findViewById(R.id.btnDelete);
        btnEditar = (ImageButton) itemView.findViewById(R.id.btnEditar);

    }


}
