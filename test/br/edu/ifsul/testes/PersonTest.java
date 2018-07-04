/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.edu.ifsul.modelo.Autorizacao;
import br.edu.ifsul.modelo.Gamer;

/**
 *
 * @author eriks
 */
public class PersonTest {
    
    EntityManagerFactory emf;
    EntityManager em;

    public PersonTest() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("projeto-ta-etapa2PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {            
            Gamer obj = new Gamer();
            Autorizacao p = new Autorizacao();
            p = em.find(Autorizacao.class, "ADMINISTRADOR");
            obj = em.find(Gamer.class, 1);            
            obj.getAutorizacoes().add(p);
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
