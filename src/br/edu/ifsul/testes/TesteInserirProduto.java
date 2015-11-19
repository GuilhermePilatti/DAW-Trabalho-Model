/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.ClienteFisicoDAO;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Produto;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class TesteInserirProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            ProdutoDAO dao = new ProdutoDAO();
            Produto p = new Produto();
            p.setNome("PigMix Crescimento 30");
            p.setFase("Crescimento");
            p.setPesoSaca(25);
            p.setValorUnitario(65.58);
            
            em.getTransaction().begin();
            dao.pesistir(p); //inserir
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
