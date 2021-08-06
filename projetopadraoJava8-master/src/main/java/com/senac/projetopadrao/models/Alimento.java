package com.senac.projetopadrao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Alimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade; //int
    private String categoria;
    private double valorUnitario; //double
    private String formaDePagamento;
    private String parcelas;
    //private double valorTotal = quantidade * valorUnitario;
    private String data;
    private String dataArquivada;
    //private String somaTotal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    //public String getSomaTotal() {
     //   return somaTotal;
    //}

    //public void setSomaTotal(String somaTotal) {
     //   this.somaTotal = somaTotal;
    //}


    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
//        this.dataArquivada = data;
    }

    public String getDataArquivada() {
        return dataArquivada;
    }

    public void setDataArquivada(String dataArquivada) {
        this.dataArquivada = dataArquivada;
        this.data = dataArquivada;
    }
}
