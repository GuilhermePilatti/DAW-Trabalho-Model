/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.ClienteFisico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class ClienteFisicoDAO implements Serializable{
    private List<ClienteFisico> listarTodos;

    public ClienteFisicoDAO() {
    }
    
    public void pesistir(ClienteFisico objeto) throws Exception{
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
    
    public void merge(ClienteFisico objeto) throws Exception{
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
            
            ClienteFisico objeto = em.find(ClienteFisico.class, id);
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
    
    public ClienteFisico getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.find(ClienteFisico.class, id);
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public List<ClienteFisico> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.createQuery("from ClienteFisico order by nome").getResultList();
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<ClienteFisico> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
