/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venda")
public class Venda implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double valorTotal;
    
    @NotNull(message = "A quantidade de sacas deve ser informada")
    @Column(name = "quantidadesacas", columnDefinition = "INTEGER")
    private Integer quantidadeSacas;
    
    @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double pesoTotal;
    
    @NotNull(message = "A data da venda deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "datavenda", nullable = false)
    private Calendar dataVenda;
    
    @NotNull(message = "A data da entrega deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataentrega", nullable = false)
    private Calendar dataEntrega;
    
    @NotNull(message = "O pedido deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pedido", referencedColumnName = "codigo", nullable = false)
    private Pedido pedido;

    public Venda() {
    }
    
    @Transient
    public String getDataVendaFormatada(){
        if(dataVenda != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(dataVenda.getTime());
        } else{
            return "";
        }
    }
    
    @Transient
    public String getDataEntregaFormatada(){
        if(dataEntrega != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(dataEntrega.getTime());
        } else{
            return "";
        }
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

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}
