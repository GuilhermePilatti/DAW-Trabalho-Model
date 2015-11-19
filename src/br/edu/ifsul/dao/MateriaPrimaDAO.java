/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.MateriaPrima;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class MateriaPrimaDAO implements Serializable{
    private List<MateriaPrima> listarTodos;

    public MateriaPrimaDAO() {
    }
    
    public void pesistir(MateriaPrima objeto) throws Exception{
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
    
    public void merge(MateriaPrima objeto) throws Exception{
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
            
            MateriaPrima objeto = em.find(MateriaPrima.class, id);
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
    
    public MateriaPrima getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.find(MateriaPrima.class, id);
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public List<MateriaPrima> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.createQuery("from MateriaPrima order by nome").getResultList();
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<MateriaPrima> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
