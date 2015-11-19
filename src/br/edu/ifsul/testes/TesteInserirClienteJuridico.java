/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.ClienteJuridico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class TesteInserirClienteJuridico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            ClienteJuridico cj = new ClienteJuridico();
            cj.setNome("Suitec");
            cj.setEndereco("Av. Barão");
            cj.setCidade("Marau");
            cj.setCnpj("87.256.764/0001-20");
            cj.setIe("012.568.245.102");
            
            em.getTransaction().begin();
            em.persist(cj); //inserir
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.getTransaction().rollback();
        } finally{
            em.close();
            emf.close();
        }
    }
    
}
