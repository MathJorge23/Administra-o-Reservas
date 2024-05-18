package com.example.telacadastro.model;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Restaurante {
    String txtNomeP, txtCpfP, txtDtNascimentoP,txtTelefoneP,txtEmailP;

    String txtLogP,txtNumeroP,txtBairroP,txtCidadeP,txtCepP;

    String btnP, btnC;

    String spinEstadoP;

    public Restaurante() {
    }

    public Restaurante(String txtNomeP, String txtCpfP, String txtDtNascimentoP, String txtTelefoneP,
                       String txtEmailP, String txtLogP, String txtNumeroP, String txtBairroP,
                       String txtCidadeP, String txtCepP, String btnP, String btnC, String spinEstadoP) {
        this.txtNomeP = txtNomeP;
        this.txtCpfP = txtCpfP;
        this.txtDtNascimentoP = txtDtNascimentoP;
        this.txtTelefoneP = txtTelefoneP;
        this.txtEmailP = txtEmailP;
        this.txtLogP = txtLogP;
        this.txtNumeroP = txtNumeroP;
        this.txtBairroP = txtBairroP;
        this.txtCidadeP = txtCidadeP;
        this.txtCepP = txtCepP;
        this.btnP = btnP;
        this.btnC = btnC;
        this.spinEstadoP = spinEstadoP;
    }

    public String getTxtNomeP() {
        return txtNomeP;
    }

    public void setTxtNomeP(String txtNomeP) {
        this.txtNomeP = txtNomeP;
    }

    public String getTxtCpfP() {
        return txtCpfP;
    }

    public void setTxtCpfP(String txtCpfP) {
        this.txtCpfP = txtCpfP;
    }

    public String getTxtDtNascimentoP() {
        return txtDtNascimentoP;
    }

    public void setTxtDtNascimentoP(String txtDtNascimentoP) {
        this.txtDtNascimentoP = txtDtNascimentoP;
    }

    public String getTxtTelefoneP() {
        return txtTelefoneP;
    }

    public void setTxtTelefoneP(String txtTelefoneP) {
        this.txtTelefoneP = txtTelefoneP;
    }

    public String getTxtEmailP() {
        return txtEmailP;
    }

    public void setTxtEmailP(String txtEmailP) {
        this.txtEmailP = txtEmailP;
    }

    public String getTxtLogP() {
        return txtLogP;
    }

    public void setTxtLogP(String txtLogP) {
        this.txtLogP = txtLogP;
    }

    public String getTxtNumeroP() {
        return txtNumeroP;
    }

    public void setTxtNumeroP(String txtNumeroP) {
        this.txtNumeroP = txtNumeroP;
    }

    public String getTxtBairroP() {
        return txtBairroP;
    }

    public void setTxtBairroP(String txtBairroP) {
        this.txtBairroP = txtBairroP;
    }

    public String getTxtCidadeP() {
        return txtCidadeP;
    }

    public void setTxtCidadeP(String txtCidadeP) {
        this.txtCidadeP = txtCidadeP;
    }

    public String getTxtCepP() {
        return txtCepP;
    }

    public void setTxtCepP(String txtCepP) {
        this.txtCepP = txtCepP;
    }

    public String getBtnP() {
        return btnP;
    }

    public void setBtnP(String btnP) {
        this.btnP = btnP;
    }

    public String getBtnC() {
        return btnC;
    }

    public void setBtnC(String btnC) {
        this.btnC = btnC;
    }

    public String getSpinEstadoP() {
        return spinEstadoP;
    }

    public void setSpinEstadoP(String spinEstadoP) {
        this.spinEstadoP = spinEstadoP;
    }
}
