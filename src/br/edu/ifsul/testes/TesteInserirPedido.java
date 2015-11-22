/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.ClienteFisicoDAO;
import br.edu.ifsul.dao.PedidoDAO;
import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Pedido;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class TesteInserirPedido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
            em = emf.createEntityManager();
            
            PedidoDAO dao = new PedidoDAO();
            Pedido p = new Pedido();
            p.setDataPedido(Calendar.getInstance());
            p.setPesoTotal(1000.00);
            p.setQuantidadeSacas(40);
            p.setValorTotal(2400.00);
            
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
