/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ws
 */
public class FornecedorDAO implements Serializable{
    private List<Fornecedor> listarTodos;

    public FornecedorDAO() {
    }
    
    public void pesistir(Fornecedor objeto) throws Exception{
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
    
    public void merge(Fornecedor objeto) throws Exception{
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
            
            Fornecedor objeto = em.find(Fornecedor.class, id);
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
    
    public Fornecedor getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.find(Fornecedor.class, id);
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public List<Fornecedor> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-Trabalho-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            return em.createQuery("from Fornecedor order by nome").getResultList();
        } catch(Exception e){
            throw new Exception("Erro ao executar a operação de persistência:" +e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Fornecedor> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
