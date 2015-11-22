/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.ClienteFisicoDAO;
import br.edu.ifsul.dao.PedidoDAO;
import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.ItensPedido;
import br.edu.ifsul.modelo.ItensProduto;
import br.edu.ifsul.modelo.MateriaPrima;
import br.edu.ifsul.modelo.Pedido;
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
public class TesteInserirPedidoItensPedido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            Pedido p = em.find(Pedido.class, 1);
            ItensPedido ip = new ItensPedido();
            ip.setPedido(p);
            ip.setPeso(1000.00);
            ip.setQuantidade(40);
            ip.setProduto(em.find(Produto.class, 1));
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
