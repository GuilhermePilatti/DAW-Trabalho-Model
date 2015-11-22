/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_pedido", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valortotal", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double valorTotal;
    
    @NotNull(message = "A quantidade de sacas deve ser informada")
    @Column(name = "quantidadesacas", columnDefinition = "INTEGER")
    private Integer quantidadeSacas;
    
    @NotNull(message = "A data do pedido deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "datapedido", nullable = false)
    private Calendar dataPedido;
    
    @NotNull(message = "O peso total deve ser informado")
    @Column(name = "pesototal", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double pesoTotal;
    
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "codigo", nullable = false)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ItensPedido> itens = new ArrayList<>();

    public Pedido() {
    }
    
    @Transient
    public String getDataPedidoFormatada(){
        if(dataPedido != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(dataPedido.getTime());
        } else{
            return "";
        }
    }
    
    public void adicionarItem(ItensPedido obj){
        obj.setPedido(this);
        this.itens.add(obj);
    }
    
    public void removerItem(int index){
        this.itens.remove(index);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidadeSacas() {
        return quantidadeSacas;
    }

    public void setQuantidadeSacas(Integer quantidadeSacas) {
        this.quantidadeSacas = quantidadeSacas;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dataPedido.toString();
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
