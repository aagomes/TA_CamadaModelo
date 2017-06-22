package br.edu.ifsu.testes;

import br.edu.ifsul.modelo.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author alexandre
 */
public class TestePersistirCurso {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirCurso() {
    }    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2017-1-6N1T2-ModelPU");
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
            Curso c1 = new Curso();
            c1.setNome("TSPI");            
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    
        }
}
