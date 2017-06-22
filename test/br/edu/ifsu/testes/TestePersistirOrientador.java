package br.edu.ifsu.testes;

import br.edu.ifsul.modelo.Publicacao;
import br.edu.ifsul.modelo.Orientador;
import java.util.Calendar;
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
public class TestePersistirOrientador {    
    EntityManagerFactory emf;
    EntityManager em;

    /**
     *
     */
    public TestePersistirOrientador() {

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
            Orientador obj = new Orientador();
            obj.setNome("Jorge");
            obj.setCpf("123.123.123.12");
            obj.setTitulacao("Graduação");
            Publicacao p = em.find(Publicacao.class, "TCC TSPI 1/2017");
            p.setDataPublicacao(Calendar.getInstance());
            p.setTipo("Artigo");
            obj.getPublicacoes().add(p);            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true; 
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
