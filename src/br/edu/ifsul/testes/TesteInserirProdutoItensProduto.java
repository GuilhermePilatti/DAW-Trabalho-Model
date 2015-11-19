/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.ClienteFisicoDAO;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.ItensProduto;
import br.edu.ifsul.modelo.MateriaPrima;
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
public class TesteInserirProdutoItensProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            Produto p = em.find(Produto.class, 1);
            ItensProduto ip = new ItensProduto();
            ip.setMateriaPrima(em.find(MateriaPrima.class, 1));
            ip.setQuantidade(5.250);
            ip.setUnidade("Kg");
            p.adicionarItem(ip);
            
            em.getTransaction().begin();
            em.persist(p); //inserir
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
