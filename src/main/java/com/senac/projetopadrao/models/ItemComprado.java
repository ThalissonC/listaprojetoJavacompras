package com.senac.projetopadrao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ItemComprado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeItemComprado;
    @Column(name = "quantidade", nullable = false, columnDefinition = "int DEFAULT 1")
    private int quantidadeItemComprado; //int
    private String categoriaItemComprado;
    private double valorUnitarioItemComprado; //double
    private String formaDePagamento;
    private String parcelas;
    //private double valorTotal = quantidade * valorUnitario;
    private String dataItemComprado;

    //private String somaTotal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeItemComprado() {
        return nomeItemComprado;
    }

    public void setNomeItemComprado(String nomeItemComprado) {
        this.nomeItemComprado = nomeItemComprado;
    }

    public int getQuantidadeItemComprado() {
        return quantidadeItemComprado;
    }

    public void setQuantidadeItemComprado(int quantidadeItemComprado) {
        this.quantidadeItemComprado = quantidadeItemComprado;
    }

    public String getCategoriaItemComprado() {
        return categoriaItemComprado;
    }

    public void setCategoriaItemComprado(String categoriaItemComprado) {
        this.categoriaItemComprado = categoriaItemComprado;
    }

    public double getValorUnitarioItemComprado() {
        return valorUnitarioItemComprado;
    }

    public void setValorUnitarioItemComprado(double valorUnitarioItemComprado) {
        this.valorUnitarioItemComprado = valorUnitarioItemComprado;
    }

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

    public String getDataItemComprado() {
        return dataItemComprado;
    }

    public void setDataItemComprado(String dataItemComprado) {
        this.dataItemComprado = dataItemComprado;
    }


}
