/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pedido;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class PedidoDAO implements Serializable{
    private List<Pedido> listarTodos;

    public PedidoDAO() {
    }
    
    public void pesistir(Pedido objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.persist(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.getTransaction().rollback();
            
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public void merge(Pedido objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.merge(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.getTransaction().rollback();
            
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void remover(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            Pedido objeto = em.find(Pedido.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            
            em.getTransaction().rollback();
            
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public Pedido getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Pedido obj = em.find(Pedido.class, id);
            obj.getItens().size();
            return obj;
        } catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public List<Pedido> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.createQuery("from Pedido order by dataPedido").getResultList();
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Pedido> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
