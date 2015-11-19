/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_fornecedor", sequenceName = "seq_fornecedor_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_fornecedor", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "O endereço deve ser informado")
    @NotNull(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço não pode ter mais de {max} caracteres")
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;
    
    @CNPJ
    @NotBlank(message = "O CNPJ deve ser informado")
    @NotNull(message = "O CNPJ deve ser informado")
    @Length(max = 18, message = "O CNPJ não pode ter mais de {max} caracteres")
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;
    
    @NotBlank(message = "O telefone deve ser informado")
    @NotNull(message = "O telefone deve ser informado")
    @Length(max = 14, message = "O telefone não pode ter mais de {max} caracteres")
    @Column(name = "telefone", nullable = false, length = 14)
    private String telefone;

    public Fornecedor() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codigo);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
