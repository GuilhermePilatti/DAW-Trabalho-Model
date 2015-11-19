/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "cliente_fisico")
public class ClienteFisico extends Cliente implements Serializable{
    @NotBlank(message = "O RG deve ser informado")
    @NotNull(message = "O RG deve ser informado")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    @Column(name = "rg", nullable = false, length = 10)
    private String rg;
    
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @NotNull(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public ClienteFisico() {
    }
}
