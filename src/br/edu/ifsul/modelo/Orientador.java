package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "orientador")
public class Orientador implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_setor", allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode ser em branco")
    @Length(max = 14, message = "O cpf não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    @NotNull(message = "A instituicao não pode ser nula")
    @NotBlank(message = "A instituicao pode ser em branco")
    @Length(max = 50, message = "A instituicao não pode ter mais que {max} caracteres")
    @Column(name = "instituicao", length = 50, nullable = false)
    private String instituicao;
    @NotNull(message = "A titulacao não pode ser nula")
    @NotBlank(message = "A titulacao não pode ser em branco")
    @Length(max = 50, message = "A titulacao não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", length = 50, nullable = false)
    private String titulacao;
    @OneToMany(mappedBy = "orientador", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Publicacao> publicacao = new ArrayList<>();
    
    public Orientador() {
    }
    
    public void adicionarPublicacao(Publicacao obj){
        obj.setOrientador(this);
        this.getPublicacao().add(obj);
    }
    
    public void removerPublicacao(int idx){
        this.getPublicacao().remove(idx);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orientador other = (Orientador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public List<Publicacao> getPublicacoes() {
        return getPublicacao();
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.setPublicacao(getPublicacao());
    }

    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }
    
    
}
