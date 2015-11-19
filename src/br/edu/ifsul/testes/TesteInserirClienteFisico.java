/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.ClienteFisicoDAO;
import br.edu.ifsul.modelo.ClienteFisico;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class TesteInserirClienteFisico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            //ClienteFisico cf = new ClienteFisico();
            ClienteFisicoDAO dao = new ClienteFisicoDAO();
            /*cf.setNome("Guilherme Pavão Pilatti");
            cf.setEndereco("Rua Vitório Deconto");
            cf.setCidade("Marau");
            cf.setCpf("596.654.737-86");
            cf.setRg("0213456789");
            
            em.getTransaction().begin();
            dao.pesistir(cf); //inserir
            em.getTransaction().commit();*/
            
            for(ClienteFisico cf : dao.getListarTodos()){
                System.out.println("Nome: " +cf.getNome());
            }
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
