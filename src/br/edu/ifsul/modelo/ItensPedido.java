/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_itens_pedido", sequenceName = "seq_itens_pedido_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_itens_pedido", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O pedido deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pedido", referencedColumnName = "codigo", nullable = false)
    private Pedido pedido;
    
    @NotNull(message = "O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "codigo", nullable = false)
    private Produto produto;
    
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", columnDefinition = "INTEGER")
    private Integer quantidade;
    
    @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double peso;

    public ItensPedido() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
