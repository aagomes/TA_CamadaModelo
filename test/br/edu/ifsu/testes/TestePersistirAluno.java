package br.edu.ifsu.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Orientador;
import br.edu.ifsul.modelo.Publicacao;
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
public class TestePersistirAluno {    
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirAluno() {
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
            Aluno obj = new Aluno();
            obj.setNome("ZE Gomes");
            obj.setSexo("masculino");
            obj.setDataNascimento(Calendar.getInstance());
            obj.setCpf("123.456.777-88");
            obj.setOrientador(em.find(Orientador.class,1));
            Curso c = em.find(Curso.class, "TSPI");
            obj.getCursos().add(c);  
            Publicacao p = em.find(Publicacao.class, "TCC 1/2017");
            obj.getPublicacoes().add(p);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            } catch (Exception e) {
            exception = true;            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
}

