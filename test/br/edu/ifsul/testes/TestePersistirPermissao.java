package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autorizacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eriks
 */
public class TestePersistirPermissao {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirPermissao() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2018-1-6N1-ModelPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Autorizacao p1 = new Autorizacao();
            p1.setName("ADMINISTRADOR");
            p1.setDescription("Usuario administrativo");
            Autorizacao p2 = new Autorizacao();
            p2.setName("USUARIO");
            p2.setDescription("Usuario simples");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
